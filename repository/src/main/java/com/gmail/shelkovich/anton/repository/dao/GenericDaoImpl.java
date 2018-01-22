package com.gmail.shelkovich.anton.repository.dao;

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

    private final Class<T> entityClass;

    @Autowired
    private SessionFactory sessionFactory;

    public GenericDaoImpl() {
        this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
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
    public void delete(T bean) {
        sessionFactory.getCurrentSession().delete(bean);
    }

    @Override
    public void delete(ID id) {
        this.delete(getById(id));
    }

    @Override
    public T update(T bean) {
        return (T) sessionFactory.getCurrentSession().merge(bean);
    }

    @Override
    public List<T> getPage(int count, int page, boolean sortByIdASC) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM " + entityClass.getName() + " ORDER BY id " + (sortByIdASC ? "ASC" : "DESC"));
        query.setMaxResults(count);
        query.setFirstResult((page - 1) * count);
        return query.list();
    }
}
