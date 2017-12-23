package com.gmail.shelkovich.anton.repository.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "T_ORDER_POSITIONS")
public class OrderPosition implements Serializable {

    private static final long serialVersionUID = 8429427757939707156L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "F_ID")
    private Long id;

    @Column(name = "F_COUNT")
    private Integer count;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "F_ORDER_ID")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "F_PRODUCT_ID")
    private Product product;
}
