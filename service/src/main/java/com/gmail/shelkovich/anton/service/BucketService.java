package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.service.model.dto.ProductDTO;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

public interface BucketService {
    @Transactional(readOnly = true)
    void addToBucket(Long productId, Integer count);

    @Transactional(readOnly = true)
    void removeFromBucket(Long productId);

    @Transactional(readOnly = true)
    void changeProductCount(Long productId, Integer newCount);

    @Transactional(readOnly = true)
    int getProductCount(Long productId);

    Set<Map.Entry<ProductDTO, Integer>> getAll();

    Integer getTotalCount();

    BigDecimal getTotalPrice();

    void cleanBucket();

    @Transactional(readOnly = true)
    void loadOrderToBucket(Long orderId);
}
