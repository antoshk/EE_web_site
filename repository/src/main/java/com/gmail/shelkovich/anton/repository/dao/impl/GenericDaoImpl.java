package com.gmail.shelkovich.anton.repository.dao.impl;

import com.gmail.shelkovich.anton.repository.dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Component
public abstract class GenericDaoImpl<T extends Serializable, ID extends Number> implements GenericDao<T, ID> {

    protected final Class<T> entityClass;

    @Autowired
    protected SessionFactory sessionFactory;

    public GenericDaoImpl(Class<T> clazz) {
        //this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        entityClass = clazz;
    }

    @Override
    public T add(T bean) {
        sessionFactory.getCurrentSession().persist(bean);
        return bean;
    }

    @Override
    public T getById(ID id) {
        return sessionFactory.getCurrentSession().get(entityClass, id);
    }

    @Override
    public List<T> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM " + entityClass.getName()).list();
    }

    @Override
    public boolean delete(T bean) {
        if (bean != null) {
            sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().merge(bean));
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(ID id) {
        return delete(getById(id));
    }

    @Override
    public T update(T bean) {
        return (T) sessionFactory.getCurrentSession().merge(bean);
    }

    @Override
    public List<T> getPage(int count, int page, int sortOrder) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM " + entityClass.getName() + " ORDER BY id " + intToOrderInstruction(sortOrder));
        query.setMaxResults(count);
        query.setFirstResult((page - 1) * count);
        return query.list();
    }

    protected String intToOrderInstruction(int order){
        switch (order){
            case 1: return "ASC";
            case 2: return "DESC";
            case 3: return "NEWID()";
            default: return "ASC";
        }
    }
}
