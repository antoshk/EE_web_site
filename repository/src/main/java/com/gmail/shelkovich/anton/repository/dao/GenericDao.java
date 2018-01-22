package com.gmail.shelkovich.anton.repository.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T extends Serializable, ID extends Number> {
    T add(T bean);

    T getById(ID id);

    List<T> getAll();

    boolean delete(T bean);

    boolean delete(ID id);

    T update(T bean);

    List<T> getPage(int count, int page, int sortOrder);
}
