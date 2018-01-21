package com.gmail.shelkovich.anton.repository.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_comments")
public class Comment implements Serializable {
    private static final long serialVersionUID = 2050630126994592109L;

    @Id
    @Column(name = "f_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "f_message", columnDefinition = "text")
    private String message;

    @ManyToOne
    @JoinColumn(name = "f_user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
