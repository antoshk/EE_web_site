package com.gmail.shelkovich.anton.repository.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "T_ORDERS")
public class Order implements Serializable {
    private static final long serialVersionUID = 132182107770158805L;

    @Id
    @Column(name="F_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="F_STATUS")
    private Integer status;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name="F_USER_ID")
    private User user;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private Set<OrderPosition> orderPositions;
}
