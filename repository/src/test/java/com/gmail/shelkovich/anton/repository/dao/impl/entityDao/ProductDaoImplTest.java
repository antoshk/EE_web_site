package com.gmail.shelkovich.anton.repository.dao.impl.entityDao;

import com.gmail.shelkovich.anton.repository.dao.HibernateUtils;
import com.gmail.shelkovich.anton.repository.dao.impl.ProductDaoImpl;
import com.gmail.shelkovich.anton.repository.model.Product;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class ProductDaoImplTest {

    @org.junit.Test
    public void crud() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        ProductDaoImpl productDao = new ProductDaoImpl(){

            {
                this.sessionFactory = HibernateUtils.getSessionFactory();
            }

        };

        Product product = new Product();
        product.setName("product1");
        product.setDescription("description1");
        product.setPrice(new BigDecimal(10));
        product.setActive(true);
        product.setImageURI("default.png");

        session.beginTransaction();
        try{
            productDao.add(product);

            assertTrue(session.contains(product));

            List<Product> products = productDao.getAll();
            assertTrue(products.contains(product));
            session.detach(product);

            product.setName("product2");
            Product newProduct = productDao.update(product);
            assertEquals(newProduct.getName(), "product2");
            assertEquals(newProduct.getId(), product.getId());

            assertTrue(productDao.delete(newProduct));
            assertNull(productDao.getById(newProduct.getId()));
            products = productDao.getAll();
            assertFalse(products.contains(newProduct));

            assertTrue(productDao.hardDelete(product));
        } finally {
            session.getTransaction().rollback();
        }

    }
}