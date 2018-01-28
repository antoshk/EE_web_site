package com.gmail.shelkovich.anton.repository.dao.impl;

import com.gmail.shelkovich.anton.repository.dao.GenericDao;
import com.gmail.shelkovich.anton.repository.dao.SortOrder;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
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
        sessionFactory.getCurrentSession().merge(bean);
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
    public List<T> getPage(int count, int page, SortOrder sortOrder) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM " + entityClass.getName() + " ORDER BY " + OrderToInstruction(sortOrder));
        query.setMaxResults(count);
        query.setFirstResult((page - 1) * count);
        return query.list();
    }

    @Override
    public Integer getRowCount(){
        String countStr = sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) as count FROM " + entityClass.getName()).uniqueResult().toString();
        Integer count = null;
        try {
            count = Integer.parseInt(countStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    protected String OrderToInstruction(SortOrder order){
        switch (order){
            case ASC: return " id ASC";
            case DESC: return " id DESC";
            case RANDOM: return " RAND()";
            default: return " id ASC";
        }
    }
}
