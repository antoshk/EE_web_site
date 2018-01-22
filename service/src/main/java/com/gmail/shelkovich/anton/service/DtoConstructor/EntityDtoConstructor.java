package com.gmail.shelkovich.anton.service.DtoConstructor;

import com.gmail.shelkovich.anton.repository.model.*;
import com.gmail.shelkovich.anton.service.model.dto.entity.*;

public interface EntityDtoConstructor {
    ProductDTO getProductDTO(Product product);

    OrderDTO getOrderDTO(Order order, UserDTO userDTO);

    UserDTO getUserDTO(User user, Boolean loadOrders);

    CommentDTO getCommentDTO(Comment comment, Boolean loadUser);

    PieceOfNewsDTO getPieceOfNewsDTO(PieceOfNews pieceOfNews, Boolean loadComments);
}
