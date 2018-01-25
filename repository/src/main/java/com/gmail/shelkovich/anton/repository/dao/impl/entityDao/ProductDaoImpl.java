package com.gmail.shelkovich.anton.repository.dao.impl.entityDao;

import com.gmail.shelkovich.anton.repository.dao.impl.GenericDaoImpl;
import com.gmail.shelkovich.anton.repository.model.Product;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productDAO")
public class ProductDaoImpl extends GenericDaoImpl<Product, Long> {

    public ProductDaoImpl() {
        super(Product.class);
    }

    @Override
    public List<Product> getPage(int count, int page, int sortOrder) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM " + entityClass.getName() + " WHERE isActive = true ORDER BY " + intToOrderInstruction(sortOrder));
        query.setMaxResults(count);
        query.setFirstResult((page - 1) * count);
        return query.list();
    }

    @Override
    public Product getById(Long id) {
        return (Product) sessionFactory.getCurrentSession().createQuery("FROM  " + entityClass.getName() + " WHERE isActive = true AND id = '" + id + "'").uniqueResult();
    }

    @Override
    public List<Product> getAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM " + entityClass.getName() +" WHERE isActive = true").list();
    }

    @Override
    public Integer getRowCount(){
        String countStr = sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) as count FROM " + entityClass.getName()+" WHERE isActive = true").uniqueResult().toString();
        Integer count = null;
        try {
            count = Integer.parseInt(countStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public boolean delete(Product bean) {
        if (bean == null) {
            return false;
        }
        if (sessionFactory.getCurrentSession().contains(bean)) {
            bean.setActive(false);
        } else {
            Product associatedBean = getById(bean.getId());
            if (associatedBean == null) {
                return false;
            }
            associatedBean.setActive(false);
        }
        return true;
    }

    public boolean hardDelete(Product bean){
        return super.delete(bean);
    }
}
