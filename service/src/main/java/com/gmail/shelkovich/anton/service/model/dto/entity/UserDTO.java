package com.gmail.shelkovich.anton.service.model.dto.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotBlank;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class UserDTO implements Serializable{

    private static final long serialVersionUID = 3266550439610719796L;
    private Long id;

    @NotEmpty(message = "{reg.user.fullName}")
    private String fullName;
    private String email;
    private String phone;


    private String address;

    @NotNull
    @Size(min=6, max=25)
    private String password;

    @NotNull
    @Size(min=6, max=25)
    private String passwordRep;
    private Boolean isActive;
    private String additionalInfo;
    private Map.Entry<Long, String> role;
    private List<OrderDTO> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRep() {
        return passwordRep;
    }

    public void setPasswordRep(String passwordRep) {
        this.passwordRep = passwordRep;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Map.Entry<Long, String> getRole() {
        return role;
    }

    public void setRole(Map.Entry<Long, String> role) {
        this.role = role;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }

}
