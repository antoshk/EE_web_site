package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.repository.model.OrderStatus;
import com.gmail.shelkovich.anton.service.converter.OrderConverter;
import com.gmail.shelkovich.anton.service.model.dto.OrderDTO;
import com.gmail.shelkovich.anton.service.model.dto.ProductDTO;
import com.gmail.shelkovich.anton.service.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class OrderService extends AbstractService {

    @Autowired
    BucketService bucketService;


    public OrderDTO generateOrder(UserDTO user) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setStatus(OrderStatus.NEW);
        orderDTO.setUser(user);
        for (Map.Entry<ProductDTO, Integer> entry : bucketService.getAll()) {
            orderDTO.getProducts().put(entry.getKey(), entry.getValue());
        }
        return orderDTO;
    }

    @Transactional
    public Long addNewOrder(OrderDTO orderDTO) {
        return daoList.getOrderDao().add(OrderConverter.fromDTO(orderDTO)).getId();
    }

    @Transactional
    public OrderDTO getById(Long id) {
        OrderDTO order = null;
        if (id != null) {
            order = OrderConverter.toDTO(daoList.getOrderDao().getById(id), null);
        }
        return order;
    }

    public BigDecimal getTotalPrice(OrderDTO order) {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<ProductDTO, Integer> product : order.getProducts().entrySet()) {
            totalPrice = totalPrice.add(product.getKey().getPrice().multiply(new BigDecimal(product.getValue())));
        }
        return totalPrice;
    }

}
