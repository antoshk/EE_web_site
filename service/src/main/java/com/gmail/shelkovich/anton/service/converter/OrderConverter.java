package com.gmail.shelkovich.anton.service.converter;

import com.gmail.shelkovich.anton.repository.model.Order;
import com.gmail.shelkovich.anton.repository.model.OrderPosition;
import com.gmail.shelkovich.anton.service.model.dto.OrderDTO;
import com.gmail.shelkovich.anton.service.model.dto.ProductDTO;
import com.gmail.shelkovich.anton.service.model.dto.UserDTO;

import java.util.Map;

public class OrderConverter {

    public static OrderDTO toDTO(Order order, UserDTO userDTO) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setStatus(order.getStatus());
        if (userDTO == null) {
            orderDTO.setUser(UserConverter.toDTO(order.getUser(), false));
        } else {
            orderDTO.setUser(userDTO);
        }

        for (OrderPosition position : order.getOrderPositions()) {
            orderDTO.getProducts().put(ProductConverter.toDTO(position.getProduct()), position.getCount());
        }

        return orderDTO;
    }

    public static Order fromDTO(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        order.setStatus(orderDTO.getStatus());
        order.setUser(UserConverter.fromDTO(orderDTO.getUser(),false));

        for(Map.Entry<ProductDTO, Integer> product: orderDTO.getProducts().entrySet()){
            OrderPosition orderPosition = new OrderPosition();
            orderPosition.setProduct(ProductConverter.fromDTO(product.getKey()));
            orderPosition.setCount(product.getValue());
            order.getOrderPositions().add(orderPosition);
        }

        return order;
    }
}
