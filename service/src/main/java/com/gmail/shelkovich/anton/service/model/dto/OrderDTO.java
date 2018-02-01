package com.gmail.shelkovich.anton.service.model.dto;

import com.gmail.shelkovich.anton.repository.model.OrderStatus;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class OrderDTO {

    private Long id;
    private OrderStatus status;
    private UserDTO user;
    private BigDecimal totalPrice;
    private boolean possibleToEdit;

    private Map<ProductDTO, Integer> products = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isPossibleToEdit() {
        return possibleToEdit;
    }

    public void setPossibleToEdit(boolean possibleToEdit) {
        this.possibleToEdit = possibleToEdit;
    }
}
