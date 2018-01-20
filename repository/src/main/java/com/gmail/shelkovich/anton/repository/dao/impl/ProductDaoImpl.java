package com.gmail.shelkovich.anton.repository.dao.impl;

import com.gmail.shelkovich.anton.repository.dao.GenericDaoImpl;
import com.gmail.shelkovich.anton.repository.model.Product;
import org.springframework.stereotype.Repository;

@Repository("productDAO")
public class ProductDaoImpl extends GenericDaoImpl<Product, Long> {
}
