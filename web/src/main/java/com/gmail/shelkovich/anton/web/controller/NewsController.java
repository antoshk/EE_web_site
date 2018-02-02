package com.gmail.shelkovich.anton.web.controller;

import com.gmail.shelkovich.anton.service.NewsService;
import com.gmail.shelkovich.anton.service.model.dto.PieceOfNewsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Value("${controller.newsPerPage:9}")
    private Integer newsPerPage;

    @Autowired
    private NewsService newsService;


    @GetMapping
    public String newsFirstPage(ModelMap model) throws IOException {
        model.addAttribute("news", newsService.getShortenNewsByPage(newsPerPage, null));
        model.addAttribute("pagination", newsService.getPagination(newsPerPage, null));
        return "news";
    }

    @GetMapping(value = "/page/{page}")
    public String productsPage(@PathVariable Integer page, ModelMap model) throws IOException {
        model.addAttribute("catalog", newsService.getShortenNewsByPage(newsPerPage, page));
        model.addAttribute("pagination", newsService.getPagination(newsPerPage, page));
        return "news";
    }

    @GetMapping("/{newsId}")
    public String newsSinglePage(@PathVariable Long newsId, ModelMap model) throws IOException {
        model.addAttribute("pieceOfNews", newsService.getById(newsId));
        return "pieceOfNews";
    }

    @RequestMapping(value="/{newsId}/comments", method = RequestMethod.GET)
    public String getListOfComments(@PathVariable Long newsId, ModelMap model) throws IOException {
        PieceOfNewsDTO pieceOfNews = newsService.getById(newsId);
        model.addAttribute("comments", pieceOfNews.getComments());
        return "ajax_commentList";
    }

    @RequestMapping(value="/{newsId}/commentsadd", method = RequestMethod.GET)
    public String addComment(@PathVariable Long newsId, @RequestParam(value="message") String message, ModelMap model) throws IOException {
        if(message.length() < 2000 && message.length() > 0){
            newsService.addNewComment(message, newsId);
            model.addAttribute("hasErrors", false);
        } else{
            model.addAttribute("hasErrors", true);
        }
        PieceOfNewsDTO pieceOfNews = newsService.getById(newsId);
        model.addAttribute("comments", pieceOfNews.getComments());
        return "ajax_commentList";
    }




}
