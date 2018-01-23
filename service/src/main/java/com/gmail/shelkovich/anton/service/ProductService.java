package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.repository.dao.SortOrder;
import com.gmail.shelkovich.anton.repository.model.Product;
import com.gmail.shelkovich.anton.service.model.dto.entity.ProductDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends AbstractService {

    @Transactional(readOnly = true)
    public List<ProductDTO> getMainPageProducts(){
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<Product> products = daoFabric.productDao.getPage(6, 1, SortOrder.RANDOM);
        for(Product product: products){
            ProductDTO productDTO = dtoConstructor.getProductDTO(product);
            String description = productDTO.getDescription();
            if (description.length() > 140) {
                description = description.substring(0, 140) + "...";
                productDTO.setDescription(description);
            }
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }


}
