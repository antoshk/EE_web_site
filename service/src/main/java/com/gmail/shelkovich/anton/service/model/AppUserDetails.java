package com.gmail.shelkovich.anton.service.model;

import com.gmail.shelkovich.anton.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class AppUserDetails implements UserDetails {

    private Long userId;
    private Collection<GrantedAuthority> grantedAuthorities;

    @Autowired
    private UserService userService;

    public AppUserDetails(Long userId){
        this.userId = userId;
        String authority = userService.getById(userId).getRole().name();
        this.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(authority));
    }

    public Long getUserId(){
        return userId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return userService.getById(userId).getPassword();
    }

    @Override
    public String getUsername() {
        return userService.getById(userId).getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return userService.getById(userId).getActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
