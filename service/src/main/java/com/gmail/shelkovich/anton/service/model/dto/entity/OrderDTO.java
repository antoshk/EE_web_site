package com.gmail.shelkovich.anton.service.model.dto.entity;

import java.util.HashMap;
import java.util.Map;

public class OrderDTO {

    private Long id;
    private String status;
    private UserDTO user;

    private Map<ProductDTO, Integer> products = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Map<ProductDTO, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<ProductDTO, Integer> products) {
        this.products = products;
    }
}
