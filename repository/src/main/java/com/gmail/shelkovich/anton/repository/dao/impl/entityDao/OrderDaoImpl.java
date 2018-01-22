package com.gmail.shelkovich.anton.repository.dao.impl.entityDao;

import com.gmail.shelkovich.anton.repository.dao.impl.GenericDaoImpl;
import com.gmail.shelkovich.anton.repository.model.Order;
import org.springframework.stereotype.Repository;

@Repository("orderDAO")
public class OrderDaoImpl extends GenericDaoImpl<Order, Long> {
    public OrderDaoImpl() {
        super(Order.class);
    }
}
