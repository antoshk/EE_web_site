package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.service.model.AppUserDetails;
import com.gmail.shelkovich.anton.service.model.dto.entity.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("appUserDetailsService")
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDTO user = userService.getUserDTOByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException(email);
        }
        return new AppUserDetails(user);
    }
}
