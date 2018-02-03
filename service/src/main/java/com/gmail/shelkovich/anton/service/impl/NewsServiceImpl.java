package com.gmail.shelkovich.anton.service.impl;

import com.gmail.shelkovich.anton.repository.dao.SortOrder;
import com.gmail.shelkovich.anton.repository.model.Comment;
import com.gmail.shelkovich.anton.repository.model.PieceOfNews;
import com.gmail.shelkovich.anton.service.FileService;
import com.gmail.shelkovich.anton.service.NewsService;
import com.gmail.shelkovich.anton.service.UserService;
import com.gmail.shelkovich.anton.service.converter.NewsConverter;
import com.gmail.shelkovich.anton.service.converter.UserConverter;
import com.gmail.shelkovich.anton.service.model.Pagination;
import com.gmail.shelkovich.anton.service.model.dto.PieceOfNewsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl extends AbstractService implements NewsService {

    @Autowired
    private Pagination pagination;

    @Value("${service.news.shortenDescription.length:140}")
    private Integer shortenBodyLength;

    @Autowired
    private UserService userService;

    @Autowired
    private FileService fileService;

    @Override
    @Transactional(readOnly = true)
    public List<PieceOfNewsDTO> getMainPageNews(){
        return getShortenNewsByPage(3, 1);
    }

    @Override
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
            if (body.length() > shortenBodyLength) {
                body = body.substring(0, shortenBodyLength) + "...";
                pieceOfNewsDTO.setNewsBody(body);
            }
            newsDTO.add(pieceOfNewsDTO);
        }
        return newsDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public Pagination getPagination(int itemsPerPage, Integer currentPage){
        int total = daoList.getNewsDao().getRowCount();
        return getAbstractPagination(pagination, currentPage, total, itemsPerPage);
    }

    @Override
    @Transactional(readOnly = true)
    public PieceOfNewsDTO getById(long id){
        PieceOfNews pieceOfNews = daoList.getNewsDao().getById(id);
        return NewsConverter.toDTO(pieceOfNews, true);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PieceOfNewsDTO> getAll(){
        List<PieceOfNews> news = daoList.getNewsDao().getAll();
        return NewsConverter.toDTO(news, false);
    }

    @Override
    @Transactional
    public void addNewComment(String message, Long newsId){
        PieceOfNews pieceOfNews = daoList.getNewsDao().getById(newsId);
        List<Comment> comments = pieceOfNews.getComments();
        Comment comment = new Comment();
        comment.setUser(UserConverter.fromDTO(userService.getCurrentUser(),false));
        comment.setMessage(message);
        comments.add(comment);
    }

    @Override
    @Transactional
    public void updateNews(PieceOfNewsDTO pieceOfNews){
        PieceOfNewsDTO old = getById(pieceOfNews.getId());
        pieceOfNews.setComments(old.getComments());
        pieceOfNews.setUser(old.getUser());
        if(pieceOfNews.getPhotoURI() == null){
            pieceOfNews.setPhotoURI(old.getPhotoURI());
        }
        daoList.getNewsDao().update(NewsConverter.fromDTO(pieceOfNews,true));
    }

    @Override
    @Transactional
    public void addNew(PieceOfNewsDTO pieceOfNews){
        pieceOfNews.setUser(userService.getCurrentUser());
        daoList.getNewsDao().add(NewsConverter.fromDTO(pieceOfNews,false));
    }

    @Override
    @Transactional
    public void delete(Long id){
        daoList.getNewsDao().delete(id);
        fileService.deleteFileByNewsId(id);
    }

    @Override
    @Transactional
    public void deleteComment(Long id){
        daoList.getCommentDao().delete(id);
    }
}
