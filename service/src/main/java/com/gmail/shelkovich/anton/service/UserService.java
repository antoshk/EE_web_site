package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.repository.model.User;
import com.gmail.shelkovich.anton.service.converter.UserConverter;
import com.gmail.shelkovich.anton.service.model.AppUserDetails;
import com.gmail.shelkovich.anton.service.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService extends AbstractService {

    @Autowired
    private AppUserDetailsService userDetailsService;

    @Transactional
    public UserDTO getByEmail(String email){
        User user = daoList.getUserDao().getByEmail(email);
        if (user != null){
            return UserConverter.toDTO(daoList.getUserDao().getByEmail(email), false);
        } else {
            return null;
        }
    }

    public UserDTO getCurrentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof AppUserDetails) {
            return ((AppUserDetails)principal).getUserDTO();
        } else {
            return null;
        }
    }

    public String getCurrentUsername(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof AppUserDetails) {
            return ((AppUserDetails)principal).getUserDTO().getFullName();
        } else {
            return principal.toString();
        }
    }

    public void getRole(String role){

    }

    @Transactional
    public void addNewUser(UserDTO user){
        daoList.getUserDao().add(UserConverter.fromDTO(user, false));
    }

//    public void autoLogin(String username, String password) {
//        UserDetails user = this.userDetailsService.loadUserByUsername(username);
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(),
//                user.getAuthorities());
//        this.authenticationManager.authenticate(token);
//        if (token.isAuthenticated()) {
//            SecurityContextHolder.getContext().setAuthentication(token);
//        }
//
//    }
}
