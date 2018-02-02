package com.gmail.shelkovich.anton.repository.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DaoList {

    @Autowired
    private FeedbackDao feedbackDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private CommentDao commentDao;

    public FeedbackDao getFeedbackDao() {
        return feedbackDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public NewsDao getNewsDao() {
        return newsDao;
    }

    public CommentDao getCommentDao() {
        return commentDao;
    }
}
