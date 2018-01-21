package com.gmail.shelkovich.anton.service.DtoConstructor.impl;

import com.gmail.shelkovich.anton.repository.dao.DaoFabric;
import com.gmail.shelkovich.anton.service.model.dto.MainPageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MainPageDtoConstructorImpl {

    @Autowired
    @Qualifier("daoFabric")
    private DaoFabric daoFabric;

    public MainPageDTO getMainPageDTO(){
        MainPageDTO mainPageDTO = new MainPageDTO();




        return mainPageDTO;
    }
}
