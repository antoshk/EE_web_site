package com.gmail.shelkovich.anton.service.converter;

import com.gmail.shelkovich.anton.repository.model.Comment;
import com.gmail.shelkovich.anton.repository.model.PieceOfNews;
import com.gmail.shelkovich.anton.service.model.dto.CommentDTO;
import com.gmail.shelkovich.anton.service.model.dto.PieceOfNewsDTO;

public class NewsConverter {
    public static PieceOfNewsDTO toDTO(PieceOfNews pieceOfNews, Boolean loadComments){
        PieceOfNewsDTO pieceOfNewsDTO = new PieceOfNewsDTO();
        pieceOfNewsDTO.setId(pieceOfNews.getId());
        pieceOfNewsDTO.setNewsTilte(pieceOfNews.getNewsTilte());
        pieceOfNewsDTO.setNewsBody(pieceOfNews.getNewsBody());
        pieceOfNewsDTO.setPhotoURI(pieceOfNews.getPhotoURI());
        pieceOfNewsDTO.setPublicationDate(pieceOfNews.getPublicationDate());
        pieceOfNewsDTO.setUser(UserConverter.toDTO(pieceOfNews.getUser(), false));
        pieceOfNewsDTO.setCommentCount(pieceOfNews.getComments().size());
        if(loadComments){
            for(Comment comment: pieceOfNews.getComments())
                pieceOfNewsDTO.getComments().add(CommentsConverter.toDTO(comment, false));
        }
        return pieceOfNewsDTO;
    }

    public static PieceOfNews fromDTO(PieceOfNewsDTO pieceOfNewsDTO, boolean setComments){
        PieceOfNews pieceOfNews = new PieceOfNews();
        pieceOfNews.setId(pieceOfNewsDTO.getId());
        pieceOfNews.setNewsTilte(pieceOfNewsDTO.getNewsTilte());
        pieceOfNews.setNewsBody(pieceOfNewsDTO.getNewsBody());
        pieceOfNews.setPhotoURI(pieceOfNewsDTO.getPhotoURI());
        pieceOfNews.setPublicationDate(pieceOfNewsDTO.getPublicationDate());

        pieceOfNews.setUser(UserConverter.fromDTO(pieceOfNewsDTO.getUser(), false));

        if(setComments && pieceOfNewsDTO.getComments().size() > 0){
            for(CommentDTO commentDTO: pieceOfNewsDTO.getComments()){
                pieceOfNews.getComments().add(CommentsConverter.fromDTO(commentDTO));
            }
        }
        return pieceOfNews;
    }
}
