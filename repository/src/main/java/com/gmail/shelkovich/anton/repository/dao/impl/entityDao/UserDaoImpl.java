package com.gmail.shelkovich.anton.repository.dao.impl.entityDao;

import com.gmail.shelkovich.anton.repository.dao.impl.GenericDaoImpl;
import com.gmail.shelkovich.anton.repository.model.User;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDaoImpl extends GenericDaoImpl<User, Long> {

    public UserDaoImpl() {
        super(User.class);
    }
}
