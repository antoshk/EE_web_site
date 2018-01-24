package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.service.model.AppUserDetails;
import com.gmail.shelkovich.anton.service.model.dto.entity.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService extends AbstractService {

    @Transactional
    public UserDTO getUserDTOByEmail(String email){
        return dtoConstructor.getUserDTO(daoFabric.userDao.getByStringUniqueField(email), false);
    }

    public UserDTO getUserFromSecurityContext(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof AppUserDetails) {
            return ((AppUserDetails)principal).getUserDTO();
        } else {
            return null;
        }
    }

    public String getUsernameFromSecurityContext(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof AppUserDetails) {
            return ((AppUserDetails)principal).getUserDTO().getFullName();
        } else {
            return principal.toString();
        }
    }
}
