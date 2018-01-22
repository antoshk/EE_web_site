package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.repository.dao.SortOrder;
import com.gmail.shelkovich.anton.repository.model.Product;
import com.gmail.shelkovich.anton.service.model.dto.entity.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class ProductService extends AbstractService {

    public List<ProductDTO> getMainPageProducts(){
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<Product> products = daoFabric.productDao.getPage(6, 1, SortOrder.RANDOM);
        for(Product product: products){
            ProductDTO productDTO = dtoConstructor.getProductDTO(product);

        }




        return productDTOList;
    }


}
