package com.gmail.shelkovich.anton.repository.impl;

import com.gmail.shelkovich.anton.repository.util.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class GenericDaoImpl<T extends Serializable> {

    private final Class<T> entityClass;
    private static Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    public GenericDaoImpl(){
        this.entityClass = (Class<T>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Long add(T bean){
        return (Long) session.save(bean);
    }

    public T getById(Long id){
        return (T)session.get(entityClass, id);
    }
}
