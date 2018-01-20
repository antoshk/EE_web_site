package com.gmail.shelkovich.anton.repository.dao;

import com.gmail.shelkovich.anton.repository.dao.GenericDao;
import com.gmail.shelkovich.anton.repository.util.HibernateUtil;
import org.hibernate.Session;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericDaoImpl<T extends Serializable, ID extends Number> implements GenericDao<T, ID> {

    private final Class<T> entityClass;
    private static Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    public GenericDaoImpl(){
        this.entityClass = (Class<T>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T add(T bean){
        session.persist(bean);
        return bean;
    }

    @Override
    public T getById(ID id){
        return (T)session.get(entityClass, id);
    }

    @Override
    public List<T> getAll(){
        return session.createQuery("FROM "+entityClass.getName()).list();
    }

    @Override
    public void delete(T bean){
        session.delete(bean);
    }

    @Override
    public void delete(ID id){
        this.delete(getById(id));
    }

    @Override
    public T update(T bean){
        return (T) session.merge(bean);
    }
}
