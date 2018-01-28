package com.gmail.shelkovich.anton.repository.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "t_order_positions")
public class OrderPosition implements Serializable {

    private static final long serialVersionUID = 8429427757939707156L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "f_id")
    private Long id;

    @Column(name = "f_count", nullable = false)
    private Integer count;

    @ManyToOne
    @JoinColumn(name = "f_product_id", nullable = false)
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
