package com.gmail.shelkovich.anton.repository.dao.impl;

import com.gmail.shelkovich.anton.repository.dao.OrderDao;
import com.gmail.shelkovich.anton.repository.model.Order;
import org.springframework.stereotype.Repository;

@Repository("orderDAO")
public class OrderDaoImpl extends GenericDaoImpl<Order, Long> implements OrderDao{
    public OrderDaoImpl() {
        super(Order.class);
    }
}
