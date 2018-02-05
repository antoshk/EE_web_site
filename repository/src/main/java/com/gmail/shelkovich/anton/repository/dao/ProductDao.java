package com.gmail.shelkovich.anton.repository.dao;

import com.gmail.shelkovich.anton.repository.model.Product;

import java.util.List;

public interface ProductDao extends GenericDao<Product, Long> {
    List<Product> getPage(int count, int page, SortOrder sortOrder);

    boolean hardDelete(Product bean);
}
