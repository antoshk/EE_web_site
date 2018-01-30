package com.gmail.shelkovich.anton.service.converter;

import com.gmail.shelkovich.anton.repository.model.Comment;
import com.gmail.shelkovich.anton.service.model.dto.CommentDTO;

public class CommentConverter {

    public static CommentDTO toDTO(Comment comment, Boolean loadUser){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setMessage(comment.getMessage());
        if(loadUser){
            commentDTO.setUser(UserConverter.toDTO(comment.getUser(), false));
        }
        return commentDTO;
    }

    public static Comment fromDTO(CommentDTO commentDTO){
        Comment comment = new Comment();
        comment.setId(commentDTO.getId());
        comment.setMessage(commentDTO.getMessage());
        comment.setUser(UserConverter.fromDTO(commentDTO.getUser(), false));
        return comment;
    }
}
