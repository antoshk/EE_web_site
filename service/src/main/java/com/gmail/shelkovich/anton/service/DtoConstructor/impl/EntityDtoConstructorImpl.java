package com.gmail.shelkovich.anton.service.DtoConstructor.impl;

import com.gmail.shelkovich.anton.repository.model.*;
import com.gmail.shelkovich.anton.service.Exception.IllegalOrderStatusException;
import com.gmail.shelkovich.anton.service.model.OrderStatus;
import com.gmail.shelkovich.anton.service.model.dto.entity.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class EntityDtoConstructorImpl {

    public ProductDTO getProductDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setDescription(product.getDescription());
            productDTO.setPrice(product.getPrice());
            productDTO.setActive(product.getActive());
        return productDTO;
    }

    public OrderDTO getOrderDTO(Order order, UserDTO userDTO){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        try {
            orderDTO.setStatus(OrderStatus.getStringStatus(order.getStatus()));
        } catch (IllegalOrderStatusException e) {
            e.printStackTrace();
        }
        if (userDTO == null){
            orderDTO.setUser(getUserDTO(order.getUser(), false));
        } else {
            orderDTO.setUser(userDTO);
        }

        for(OrderPosition position: order.getOrderPositions()){
            orderDTO.getProducts().put(getProductDTO(position.getProduct()), position.getCount());
        }

        return orderDTO;
    }

    public UserDTO getUserDTO(User user, Boolean loadOrders){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setRole(new AbstractMap.SimpleEntry<Long, String>(user.getRole().getId(),user.getRole().getName()));
        userDTO.setAddress(user.getAddress());
        userDTO.setFullName(user.getFullName());
        userDTO.setAdditionalInfo(user.getAdditionalInfo());
        userDTO.setEmail(user.getEmail());
        userDTO.setActive(user.getActive());
        userDTO.setPassword(user.getPassword());
        userDTO.setPhone(user.getPhone());

        if(loadOrders){
            List<Order> orders = user.getOrders();
            List<OrderDTO> orderDTOs = new ArrayList<>();
            for (Order order: orders) {
                orderDTOs.add(getOrderDTO(order, userDTO));
            }
            userDTO.setOrders(orderDTOs);
        }
        return userDTO;
    }

    public CommentDTO getCommentDTO(Comment comment, Boolean loadUser){
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setMessage(comment.getMessage());
        if(loadUser){
            commentDTO.setUserDTO(getUserDTO(comment.getUser(), false));
        }
        return commentDTO;
    }

    public PieceOfNewsDTO getPieceOfNewsDTO(PieceOfNews pieceOfNews, Boolean loadComments){
        PieceOfNewsDTO pieceOfNewsDTO = new PieceOfNewsDTO();
        pieceOfNewsDTO.setId(pieceOfNews.getId());
        pieceOfNewsDTO.setNewsTilte(pieceOfNews.getNewsTilte());
        pieceOfNewsDTO.setNewsBody(pieceOfNews.getNewsBody());
        pieceOfNewsDTO.setPhotoURI(pieceOfNews.getPhotoURI());
        pieceOfNewsDTO.setPublicationDate(pieceOfNews.getPublicationDate());
        pieceOfNewsDTO.setUserDTO(getUserDTO(pieceOfNews.getUser(), false));
        pieceOfNewsDTO.setCommentCount(pieceOfNews.getComments().size());
        if(loadComments){
            for(Comment comment: pieceOfNews.getComments())
            pieceOfNewsDTO.getComments().add(getCommentDTO(comment, false));
        }
        return pieceOfNewsDTO;
    }





























}
