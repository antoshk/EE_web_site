package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.repository.model.Product;
import com.gmail.shelkovich.anton.service.model.Bucket;
import com.gmail.shelkovich.anton.service.model.dto.entity.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Set;


@Service
public class BucketService extends AbstractService{

    @Autowired
    private Bucket bucket;

    @Transactional(readOnly = true)
    public void addToBucket(Long productId, Integer count){
        Product product = daoFabric.productDao.getById(productId);
        bucket.addProduct(dtoConstructor.getProductDTO(product), count);
    }

    @Transactional(readOnly = true)
    public void removeFromBucket(Long productId){
        Product product = daoFabric.productDao.getById(productId);
        bucket.removeProduct(dtoConstructor.getProductDTO(product));
    }

    @Transactional(readOnly = true)
    public void changeCount(Long productId, Integer newCount){
        Product product = daoFabric.productDao.getById(productId);
        bucket.changeCount(dtoConstructor.getProductDTO(product), newCount);
    }

    @Transactional(readOnly = true)
    public int getCount(Long productId){
        Product product = daoFabric.productDao.getById(productId);
        return bucket.getCount(dtoConstructor.getProductDTO(product));
    }

    public Set<Map.Entry<ProductDTO, Integer>> getAll(){
        return bucket.getAll();
    }

    public Integer getTotal(){
        return bucket.getAll().size();
    }
}
