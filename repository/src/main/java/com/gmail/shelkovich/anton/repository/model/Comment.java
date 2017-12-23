package com.gmail.shelkovich.anton.repository.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_COMMENTS")
public class Comment implements Serializable {
    private static final long serialVersionUID = 2050630126994592109L;

    @Id
    @Column(name = "F_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "F_MESSAGE")
    private String message;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "F_USER_ID")
    User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "F_NEWS_ID")
    PieceOfNews pieceOfNews;
}
