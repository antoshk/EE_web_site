package com.gmail.shelkovich.anton.repository.dao.impl;

import com.gmail.shelkovich.anton.repository.dao.GenericDaoImpl;
import com.gmail.shelkovich.anton.repository.model.User;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDaoImpl extends GenericDaoImpl<User, Long> {
}
