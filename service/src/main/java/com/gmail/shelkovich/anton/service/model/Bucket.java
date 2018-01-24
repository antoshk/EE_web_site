package com.gmail.shelkovich.anton.service.model;

import com.gmail.shelkovich.anton.service.model.dto.entity.ProductDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
@Scope(value="session", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class Bucket {

    private HashMap<ProductDTO, Integer> products = new HashMap<>();

    public void addProduct(ProductDTO product, Integer count){
        products.put(product, count);
    }

    public void removeProduct(ProductDTO product){
        products.remove(product);
    }

    public void changeCount(ProductDTO product, Integer newCount){
        if(newCount == 0){
            removeProduct(product);
        } else {
            addProduct(product, newCount);
        }
    }

    public Set<Map.Entry<ProductDTO, Integer>> getAll(){
        return products.entrySet();
    }

}
