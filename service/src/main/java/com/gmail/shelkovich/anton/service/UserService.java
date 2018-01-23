package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.service.model.dto.entity.UserDTO;

public class UserService extends AbstractService {

    public UserDTO getUserDTOByEmail(String email){
        return dtoConstructor.getUserDTO(daoFabric.userDao.getByStringUniqueField(email), false);
    }
}
