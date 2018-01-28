package com.gmail.shelkovich.anton.repository.dao.impl.entityDao;

import com.gmail.shelkovich.anton.repository.dao.HibernateUtils;
import com.gmail.shelkovich.anton.repository.dao.Role;
import com.gmail.shelkovich.anton.repository.dao.impl.OrderDaoImpl;
import com.gmail.shelkovich.anton.repository.dao.impl.ProductDaoImpl;
import com.gmail.shelkovich.anton.repository.dao.impl.UserDaoImpl;
import com.gmail.shelkovich.anton.repository.model.*;
import org.hibernate.Session;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

public class OrderDaoImplTest {

    @org.junit.Test
    public void crud() {
        Session session = HibernateUtils.getSessionFactory().getCurrentSession();
        ProductDaoImpl productDao = new ProductDaoImpl(){{this.sessionFactory = HibernateUtils.getSessionFactory();}};
        UserDaoImpl userDao = new UserDaoImpl(){{this.sessionFactory = HibernateUtils.getSessionFactory();}};
        OrderDaoImpl orderDao = new OrderDaoImpl(){{this.sessionFactory = HibernateUtils.getSessionFactory();}};


        User user = new User();
        user.setActive(true);
        user.setAdditionalInfo("");
        user.setAddress("asdf");
        user.setEmail("dd@dd.dd");
        user.setFullName("asdfasdf");
        user.setPassword("asdf");
        user.setPhone("1234");
        user.setRole(Role.USER);

        Product product = new Product();
        product.setImageURI("asdf");
        product.setName("sdfg");
        product.setActive(true);
        product.setPrice(new BigDecimal(10));
        product.setDescription("asdf");

        OrderPosition orderPosition = new OrderPosition();
        Order order = new Order();
        order.getOrderPositions().add(orderPosition);
        order.setStatus(OrderStatus.NEW);


        session.beginTransaction();
        try{
            productDao.add(product);
            assertTrue(session.contains(product));

            userDao.add(user);
            assertTrue(session.contains(user));

            session.detach(user);
            session.detach(product);

            orderPosition.setCount(5);
            orderPosition.setProduct(product);
            order.setUser(user);

            orderDao.add(order);
            assertTrue(session.contains(order));
            assertTrue(session.contains(orderPosition));
        } finally {
            session.getTransaction().rollback();
        }

    }
}