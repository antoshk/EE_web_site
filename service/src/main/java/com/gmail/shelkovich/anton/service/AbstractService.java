package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.repository.dao.DaoFabric;
import com.gmail.shelkovich.anton.service.DtoConstructor.impl.EntityDtoConstructorImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractService {

    @Autowired
    @Qualifier("daoFabric")
    protected DaoFabric daoFabric;

    @Autowired
    protected EntityDtoConstructorImpl dtoConstructor;



}
