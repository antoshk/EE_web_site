package com.gmail.shelkovich.anton.service.converter;

import com.gmail.shelkovich.anton.repository.model.Product;
import com.gmail.shelkovich.anton.service.model.dto.ProductDTO;

public class ProductConverter {

    public static ProductDTO toDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setActive(product.getActive());
        productDTO.setImageURI(product.getImageURI());
        return productDTO;
    }

    public static Product fromDTO(ProductDTO productDTO){
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setActive(productDTO.getActive());
        product.setImageURI(productDTO.getImageURI());
        return product;
    }
}
