package com.gmail.shelkovich.anton.repository.model;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "t_products")
@Where(clause = "f_is_active = true")
public class Product implements Serializable {
    private static final long serialVersionUID = 492276078161085568L;

    @Id
    @Column(name="f_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="f_name", nullable = false)
    private String name;

    @Column(name="f_description", columnDefinition = "text(2000)", nullable = false)
    private String description;

    @Column(name="f_price", nullable = false)
    private BigDecimal price;

    @Column(name = "f_image_uri", nullable = false)
    private String imageURI;

    @Column(name="f_is_active", nullable = false)
    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getActive() {
        return isActive;
    }

    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
