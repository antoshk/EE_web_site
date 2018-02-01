package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.service.converter.exception.UserIsNotAllowed;
import com.gmail.shelkovich.anton.service.model.AppUserDetails;
import com.gmail.shelkovich.anton.service.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("appUserDetailsService")
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDTO user = userService.getByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException(email);
        }

        if(!user.getActive()){
            throw new UserIsNotAllowed("User "+user.getId()+" is blocked");
        }
        return new AppUserDetails(user);
    }
}
