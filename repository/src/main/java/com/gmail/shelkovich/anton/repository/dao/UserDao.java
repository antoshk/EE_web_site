package com.gmail.shelkovich.anton.repository.dao;

import com.gmail.shelkovich.anton.repository.model.User;

public interface UserDao extends GenericDao<User, Long>{
    User getByEmail(String value);
}
