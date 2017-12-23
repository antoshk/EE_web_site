package com.gmail.shelkovich.anton.repository.interfaces;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T extends Serializable, ID extends Serializable> {
    List<T> read(T bean);
    ID add(T bean);
    T getById(ID id);
    Boolean delete(ID id);

}
