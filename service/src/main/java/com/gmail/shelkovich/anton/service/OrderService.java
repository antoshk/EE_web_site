package com.gmail.shelkovich.anton.service;

import com.gmail.shelkovich.anton.repository.dao.SortOrder;
import com.gmail.shelkovich.anton.repository.model.Order;
import com.gmail.shelkovich.anton.repository.model.OrderStatus;
import com.gmail.shelkovich.anton.service.converter.OrderConverter;
import com.gmail.shelkovich.anton.service.converter.UserConverter;
import com.gmail.shelkovich.anton.service.model.dto.OrderDTO;
import com.gmail.shelkovich.anton.service.model.dto.ProductDTO;
import com.gmail.shelkovich.anton.service.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class OrderService extends AbstractService {

    @Autowired
    private BucketService bucketService;

    @Autowired
    private UserService userService;


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

    @Transactional
    public void updateOrderStatus(Long id, OrderStatus status){
        daoList.getOrderDao().getById(id).setStatus(status);
    }

    @Transactional(readOnly = true)
    public List<OrderDTO> getCurrentUserOrders(){
        Long id = userService.getCurrentUser().getId();
        UserDTO user = UserConverter.toDTO(daoList.getUserDao().getById(id), true);
        return user.getOrders();
    }

    @Transactional(readOnly = true)
    public List<OrderDTO> getAll(){
        return getAll(SortOrder.ASC);
    }

    @Transactional(readOnly = true)
    public List<OrderDTO> getAll(SortOrder sortOrder){
        return OrderConverter.toDTO(daoList.getOrderDao().getAll(sortOrder));
    }

    @Transactional(readOnly = true)
    public boolean isCurrentUserOrderOwner(Long orderId){
        for(OrderDTO order: getCurrentUserOrders()){
            if(order.getId().equals(orderId)) return true;
        }
        return false;
    }

    @Transactional
    public void deleteOrder(Long orderId){
        Order order = daoList.getOrderDao().getById(orderId);
        if(order.getStatus().equals(OrderStatus.NEW)){
            daoList.getOrderDao().delete(orderId);
        }

    }

}
