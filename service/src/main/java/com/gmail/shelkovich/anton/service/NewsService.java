package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.repository.dao.SortOrder;
import com.gmail.shelkovich.anton.repository.model.Comment;
import com.gmail.shelkovich.anton.repository.model.PieceOfNews;
import com.gmail.shelkovich.anton.service.converter.NewsConverter;
import com.gmail.shelkovich.anton.service.converter.UserConverter;
import com.gmail.shelkovich.anton.service.model.Pagination;
import com.gmail.shelkovich.anton.service.model.dto.PieceOfNewsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService extends AbstractService {

    @Autowired
    private Pagination pagination;

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public List<PieceOfNewsDTO> getMainPageNews(){
        return getShortenNewsByPage(3, 1);
    }

    @Transactional(readOnly = true)
    public List<PieceOfNewsDTO> getShortenNewsByPage(int count, Integer page) {
        if (page == null){
            page = 1;
        }
        List<PieceOfNews> news = daoList.getNewsDao().getPage(count,page, SortOrder.DESC);
        List<PieceOfNewsDTO> newsDTO = new ArrayList<>();
        for (PieceOfNews pieceOfNews : news) {
            PieceOfNewsDTO pieceOfNewsDTO = NewsConverter.toDTO(pieceOfNews, false);
            String body = pieceOfNewsDTO.getNewsBody();
            if (body.length() > 140) {
                body = body.substring(0, 140) + "...";
                pieceOfNewsDTO.setNewsBody(body);
            }
            newsDTO.add(pieceOfNewsDTO);
        }
        return newsDTO;
    }

    @Transactional(readOnly = true)
    public Pagination getPagination(int itemsPerPage, Integer currentPage){
        int total = daoList.getNewsDao().getRowCount();
        return getAbstractPagination(pagination, currentPage, total, itemsPerPage);
    }

    @Transactional(readOnly = true)
    public PieceOfNewsDTO getById(long id){
        PieceOfNews pieceOfNews = daoList.getNewsDao().getById(id);
        PieceOfNewsDTO pieceOfNewsDTO = NewsConverter.toDTO(pieceOfNews, true);
        return pieceOfNewsDTO;
    }

    @Transactional
    public void addNewComment(String message, Long newsId){
        PieceOfNews pieceOfNews = daoList.getNewsDao().getById(newsId);
        List<Comment> comments = pieceOfNews.getComments();
        Comment comment = new Comment();
        comment.setUser(UserConverter.fromDTO(userService.getCurrentUser(),false));
        comment.setMessage(message);
        comments.add(comment);
    }
}
