package com.gmail.shelkovich.anton.service.model;

import com.gmail.shelkovich.anton.service.model.dto.entity.UserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class AppUserDetails implements UserDetails {

    private UserDTO userDTO;
    private Collection<GrantedAuthority> grantedAuthorities;

    public AppUserDetails(UserDTO userDTO){
        this.userDTO = userDTO;
        this.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(userDTO.getRole().getValue()));
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public Long getUserId(){
        return userDTO.getId();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return userDTO.getPassword();
    }

    @Override
    public String getUsername() {
        return userDTO.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
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
