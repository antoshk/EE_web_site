package com.gmail.shelkovich.anton.service.impl;

import com.gmail.shelkovich.anton.service.UserService;
import com.gmail.shelkovich.anton.service.exception.UserIsNotAllowed;
import com.gmail.shelkovich.anton.service.model.AppUserDetails;
import com.gmail.shelkovich.anton.service.model.dto.UserDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("appUserDetailsService")
public class AppUserDetailsService implements UserDetailsService {

    private static final Logger logger = Logger.getLogger(AppUserDetailsService.class);

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDTO user = userService.getByEmail(email);
        if(user == null){
            logger.info("While authorization User "+email+" not found");
            throw new UsernameNotFoundException(email);
        }

        if(!user.getActive()){
            logger.info("While authorization User "+email+" is blocked");
            throw new UserIsNotAllowed("User "+user.getId()+" is blocked");
        }
        return new AppUserDetails(user);
    }
}
