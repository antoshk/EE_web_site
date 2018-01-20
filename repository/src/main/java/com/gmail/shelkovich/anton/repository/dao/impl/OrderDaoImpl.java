package com.gmail.shelkovich.anton.repository.dao.impl;

import com.gmail.shelkovich.anton.repository.dao.GenericDaoImpl;
import com.gmail.shelkovich.anton.repository.model.Order;
import org.springframework.stereotype.Repository;

@Repository("orderDAO")
public class OrderDaoImpl extends GenericDaoImpl<Order, Long> {
}
