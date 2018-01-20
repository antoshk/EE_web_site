package com.gmail.shelkovich.anton.service.model.dto;

import com.gmail.shelkovich.anton.repository.model.Product;
import com.gmail.shelkovich.anton.service.model.dto.entity.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class MainPageProductDTO {

    private List<ProductDTO> products = new ArrayList<>();

    public MainPageProductDTO(List<Product> products){

    }


}
