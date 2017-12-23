package com.gmail.shelkovich.anton.repository.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "T_PRODUCTS")
public class Product implements Serializable {
    private static final long serialVersionUID = 492276078161085568L;

    @Id
    @Column(name="F_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="F_NAME")
    private String name;

    @Column(name="F_DESCRIPTION")
    private String description;

    @Column(name="F_PRICE")
    private Double price;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    Set<OrderPosition> orderPositions;
}
