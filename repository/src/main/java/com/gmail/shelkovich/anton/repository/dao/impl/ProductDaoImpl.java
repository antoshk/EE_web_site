package com.gmail.shelkovich.anton.repository.dao.impl;

import com.gmail.shelkovich.anton.repository.dao.ProductDao;
import com.gmail.shelkovich.anton.repository.model.Product;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository("productDAO")
public class ProductDaoImpl extends GenericDaoImpl<Product, Long> implements ProductDao {

    private static final Logger logger = Logger.getLogger(ProductDaoImpl.class);

    public ProductDaoImpl() {
        super(Product.class);
    }

    @Override
    public boolean delete(Product bean) {
        if (bean == null) {
            return false;
        }
        if (getCurrentSession().contains(bean)) {
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

    @Override
    public boolean hardDelete(Product bean){
        return super.delete(bean);
    }
}
