package com.gmail.shelkovich.anton.repository.dao.impl;

import com.gmail.shelkovich.anton.repository.dao.UserDao;
import com.gmail.shelkovich.anton.repository.model.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User getByEmail(String value) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE email = :email");
        query.setParameter("email", value);
        return (User) query.uniqueResult();
    }
}
