package com.gmail.shelkovich.anton.service.converter;

import com.gmail.shelkovich.anton.repository.model.Order;
import com.gmail.shelkovich.anton.repository.model.User;
import com.gmail.shelkovich.anton.service.model.dto.OrderDTO;
import com.gmail.shelkovich.anton.service.model.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserConverter {

    public static UserDTO toDTO(User user, Boolean loadOrders){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setRole(user.getRole());
        userDTO.setAddress(user.getAddress());
        userDTO.setFullName(user.getFullName());
        userDTO.setAdditionalInfo(user.getAdditionalInfo());
        userDTO.setEmail(user.getEmail());
        userDTO.setActive(user.getActive());
        userDTO.setPassword(user.getPassword());
        userDTO.setPhone(user.getPhone());

        if(loadOrders){
            List<Order> orders = user.getOrders();
            List<OrderDTO> orderDTOList = new ArrayList<>();
            for (Order order: orders) {
                orderDTOList.add(OrderConverter.toDTO(order, userDTO));
            }
            userDTO.setOrders(orderDTOList);
        }
        return userDTO;
    }

    public static User fromDTO(UserDTO userDTO, boolean setOrders){
        User user = new User();
        user.setId(userDTO.getId());
        user.setRole(userDTO.getRole());
        user.setAddress(userDTO.getAddress());
        user.setFullName(userDTO.getFullName());
        user.setAdditionalInfo(userDTO.getAdditionalInfo());
        user.setEmail(userDTO.getEmail());
        user.setActive(userDTO.getActive());
        user.setPassword(userDTO.getPassword());
        user.setPhone(userDTO.getPhone());

        if(userDTO.getOrders() != null && userDTO.getOrders().size() > 0 && setOrders){
            for(OrderDTO orderDTO: userDTO.getOrders()){
                user.getOrders().add(OrderConverter.fromDTO(orderDTO));
            }
        }

        return user;
    }
}
