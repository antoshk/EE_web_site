package com.gmail.shelkovich.anton.service.converter;

import com.gmail.shelkovich.anton.repository.model.Order;
import com.gmail.shelkovich.anton.repository.model.OrderPosition;
import com.gmail.shelkovich.anton.repository.model.OrderStatus;
import com.gmail.shelkovich.anton.service.model.dto.OrderDTO;
import com.gmail.shelkovich.anton.service.model.dto.ProductDTO;
import com.gmail.shelkovich.anton.service.model.dto.UserDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
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

        if(order.getStatus().equals(OrderStatus.NEW)){
            orderDTO.setPossibleToEdit(true);
        }else{
            orderDTO.setPossibleToEdit(false);
        }

        BigDecimal totalPrice = new BigDecimal(0);
        for (OrderPosition position : order.getOrderPositions()) {
            orderDTO.getProducts().put(ProductConverter.toDTO(position.getProduct()), position.getCount());
            totalPrice = totalPrice.add(position.getProduct().getPrice().multiply(new BigDecimal(position.getCount())));
        }
        orderDTO.setTotalPrice(totalPrice);

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

    public static List<OrderDTO> toDTO(List<Order> orders){
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(Order order: orders){
            orderDTOS.add(toDTO(order, null));
        }
        return orderDTOS;
    }
}
