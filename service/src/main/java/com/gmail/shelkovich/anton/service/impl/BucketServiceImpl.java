package com.gmail.shelkovich.anton.service.impl;

import com.gmail.shelkovich.anton.repository.model.Product;
import com.gmail.shelkovich.anton.service.BucketService;
import com.gmail.shelkovich.anton.service.converter.OrderConverter;
import com.gmail.shelkovich.anton.service.converter.ProductConverter;
import com.gmail.shelkovich.anton.service.model.Bucket;
import com.gmail.shelkovich.anton.service.model.dto.OrderDTO;
import com.gmail.shelkovich.anton.service.model.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;


@Service("bucketService")
public class BucketServiceImpl extends AbstractService implements BucketService {

    @Autowired
    private Bucket bucket;

    @Override
    @Transactional(readOnly = true)
    public void addToBucket(Long productId, Integer count){
        Product product = daoList.getProductDao().getById(productId);
        bucket.addProduct(ProductConverter.toDTO(product), count);
    }

    @Override
    @Transactional(readOnly = true)
    public void removeFromBucket(Long productId){
        Product product = daoList.getProductDao().getById(productId);
        bucket.removeProduct(ProductConverter.toDTO(product));
    }

    @Override
    @Transactional(readOnly = true)
    public void changeProductCount(Long productId, Integer newCount){
        Product product = daoList.getProductDao().getById(productId);
        bucket.changeCount(ProductConverter.toDTO(product), newCount);
    }

    @Override
    @Transactional(readOnly = true)
    public int getProductCount(Long productId){
        Product product = daoList.getProductDao().getById(productId);
        return bucket.getCount(ProductConverter.toDTO(product));
    }

    @Override
    public Set<Map.Entry<ProductDTO, Integer>> getAll(){
        return bucket.getAll();
    }

    @Override
    public Integer getTotalCount(){
        return bucket.getAll().size();
    }

    @Override
    public BigDecimal getTotalPrice(){
        BigDecimal totalPrice = new BigDecimal(0);
        for(Map.Entry<ProductDTO, Integer> product: bucket.getAll() ){
            totalPrice = totalPrice.add(product.getKey().getPrice().multiply(new BigDecimal(product.getValue())));
        }
        return totalPrice;
    }

    @Override
    public void cleanBucket(){
        bucket.clean();
    }

    @Override
    @Transactional(readOnly = true)
    public void loadOrderToBucket(Long orderId){
        OrderDTO order = OrderConverter.toDTO(daoList.getOrderDao().getById(orderId),null);
        for (Map.Entry<ProductDTO, Integer> entry : order.getProducts().entrySet()) {
            bucket.addProduct(entry.getKey(), entry.getValue());
        }
    }
}
