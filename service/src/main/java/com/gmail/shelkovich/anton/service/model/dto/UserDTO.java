package com.gmail.shelkovich.anton.service.model.dto;

import com.gmail.shelkovich.anton.repository.dao.Role;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class UserDTO implements Serializable{

    private static final long serialVersionUID = 3266550439610719796L;
    private Long id;

    @NotEmpty(message = "{reg.user.emptyRequiredField}")
    private String fullName;

    @Email(message = "{reg.user.email.invalid}")
    @NotEmpty(message = "{reg.user.emptyRequiredField}")
    private String email;

    @NotEmpty(message = "{reg.user.emptyRequiredField}")
    private String phone;

    @NotEmpty(message = "{reg.user.emptyRequiredField}")
    private String address;

    @NotNull
    @Size(min=6, max=25, message = "{reg.user.passwordNotInRange}")
    private String password;

    @NotNull
    private String confirmPassword;
    private Boolean isActive;

    @Size(max=2000, message = "{reg.user.tooLongValue}")
    private String additionalInfo;
    private Role role;
    private List<OrderDTO> orders = new ArrayList<>();

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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }

}
