package com.gmail.shelkovich.anton.web.controller.admin;

import com.gmail.shelkovich.anton.service.FileService;
import com.gmail.shelkovich.anton.service.NewsService;
import com.gmail.shelkovich.anton.service.UserService;
import com.gmail.shelkovich.anton.service.model.dto.PieceOfNewsDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/admin/news")
public class AdminNewsController {

    private static final Logger logger = Logger.getLogger(AdminNewsController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private NewsService newsService;

    @Autowired
    private FileService fileService;

    @GetMapping
    public String newsPage(ModelMap model) throws IOException {
        model.addAttribute("news", newsService.getAll());
        return "editNews";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editPieceOfNews(@PathVariable Long id, ModelMap model) {
        model.addAttribute("pieceOfNews", newsService.getById(id));
        return "editPieceOfNews";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String updatePieceOfNews(@PathVariable Long id, @Valid @ModelAttribute("pieceOfNews") PieceOfNewsDTO pieceOfNews, BindingResult result) {
        if (result.hasErrors()) {
            return "editPieceOfNews";
        }

        if (!pieceOfNews.getImage().isEmpty()) {
            String path = fileService.save(pieceOfNews.getImage(), "news/");
            if (path != null) {
                pieceOfNews.setPhotoURI(path);
                fileService.deleteFileByNewsId(pieceOfNews.getId());
            } else {
                pieceOfNews.setPhotoURI(null);
                logger.info("While updating news the returned path is null");
            }
        } else {
            logger.info("While updating news the image file is empty");
        }

        pieceOfNews.setId(id);
        newsService.updateNews(pieceOfNews);
        return "redirect:/admin/news";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPieceOfNews(ModelMap model) {
        model.addAttribute("pieceOfNews", new PieceOfNewsDTO());
        return "addPieceOfNews";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String savePieceOfNews(@Valid @ModelAttribute("pieceOfNews") PieceOfNewsDTO pieceOfNews, BindingResult result) {
        if (result.hasErrors()) {
            return "addPieceOfNews";
        }

        if (!pieceOfNews.getImage().isEmpty()) {
            String path = fileService.save(pieceOfNews.getImage(), "news/");
            if (path != null) {
                pieceOfNews.setPhotoURI(path);
            } else {
                logger.info("While updating news the returned file path is null");
                result.addError(new FieldError("pieceOfNews", "image","Can not save file"));
                return "addPieceOfNews";
            }
        } else {
            logger.info("While updating news the image file is empty");
            result.addError(new FieldError("pieceOfNews", "photo","Can not load file"));
            return "addPieceOfNews";
        }

        newsService.addNew(pieceOfNews);
        return "redirect:/admin/news";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String deletePieceOfNews(@PathVariable Long id) {
        newsService.delete(id);
        return "redirect:/admin/news";
    }

    @RequestMapping(value = "/{newsId}/comments/{commentId}/delete", method = RequestMethod.POST)
    public String deleteComment(@PathVariable Long newsId, @PathVariable Long commentId, ModelMap model) {
        newsService.deleteComment(commentId);
        PieceOfNewsDTO pieceOfNews = newsService.getById(newsId);
        model.addAttribute("comments", pieceOfNews.getComments());
        return "ajax_commentList";
    }


}
