package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.repository.model.User;
import com.gmail.shelkovich.anton.service.converter.UserConverter;
import com.gmail.shelkovich.anton.service.model.AppUserDetails;
import com.gmail.shelkovich.anton.service.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService extends AbstractService {

    @Autowired
    private AppUserDetailsService userDetailsService;


    @Transactional(readOnly = true)
    public UserDTO getById(Long id){
        User user = daoList.getUserDao().getById(id);
        if (user != null){
            return UserConverter.toDTO(user, false);
        } else {
            return null;
        }
    }

    @Transactional(readOnly = true)
    public UserDTO getByEmail(String email){
        User user = daoList.getUserDao().getByEmail(email);
        if (user != null){
            return UserConverter.toDTO(user, false);
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

    @Transactional
    public UserDTO updateUser(UserDTO userDTO){
        User user = UserConverter.fromDTO(userDTO,false);
        user.setOrders(daoList.getUserDao().getById(user.getId()).getOrders());
        User updatedUser = daoList.getUserDao().update(user);
        return UserConverter.toDTO(updatedUser,false);
    }

    @Transactional
    public void deleteUser(Long id){
        daoList.getUserDao().delete(id);
    }

    @Transactional
    public void blockUser(Long id){
        User user = daoList.getUserDao().getById(id);
        user.setActive(false);
    }

    @Transactional
    public void unblockUser(Long id){
        User user = daoList.getUserDao().getById(id);
        user.setActive(true);
    }

    @Transactional(readOnly = true)
    public List<UserDTO> getAll(){
        List<User> users = daoList.getUserDao().getAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        for(User user: users){
            userDTOs.add(UserConverter.toDTO(user,false));
        }
        return userDTOs;
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
