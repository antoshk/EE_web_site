package com.gmail.shelkovich.anton.repository.dao;

import com.gmail.shelkovich.anton.repository.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("daoFabric")
public class DaoFabric {

    @Autowired
    @Qualifier("feedbackDAO")
    public GenericDao<Feedback, Long> feedbackDao;

    @Autowired
    @Qualifier("userDAO")
    public GenericDao<User, Long> userDao;

    @Autowired
    @Qualifier("productDAO")
    public GenericDao<Product, Long> productDao;

    @Autowired
    @Qualifier("orderDAO")
    public GenericDao<Order, Long> orderDao;

    @Autowired
    @Qualifier("newsDAO")
    public GenericDao<PieceOfNews, Long> newsDao;

}
