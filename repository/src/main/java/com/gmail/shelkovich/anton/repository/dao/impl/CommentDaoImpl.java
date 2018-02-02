package com.gmail.shelkovich.anton.repository.dao.impl;

import com.gmail.shelkovich.anton.repository.dao.CommentDao;
import com.gmail.shelkovich.anton.repository.model.Comment;
import org.springframework.stereotype.Repository;

@Repository("commentDAO")
public class CommentDaoImpl extends GenericDaoImpl<Comment, Long> implements CommentDao {

    public CommentDaoImpl() {
        super(Comment.class);
    }

}
