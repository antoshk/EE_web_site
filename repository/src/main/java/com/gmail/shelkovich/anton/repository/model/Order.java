package com.gmail.shelkovich.anton.repository.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "t_orders")
public class Order implements Serializable {
    private static final long serialVersionUID = 132182107770158805L;

    @Id
    @Column(name="f_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="f_status")
    private Integer status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "f_order_id")
    private List<OrderPosition> orderPositions = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<OrderPosition> getOrderPositions() {
        return orderPositions;
    }

    public void setOrderPositions(List<OrderPosition> orderPositions) {
        this.orderPositions = orderPositions;
    }
}
