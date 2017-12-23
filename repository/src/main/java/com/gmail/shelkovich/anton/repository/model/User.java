package com.gmail.shelkovich.anton.repository.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "T_USERS")
public class User implements Serializable {

    private static final long serialVersionUID = 4367552545254505353L;

    @Id
    @Column(name="F_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="F_FULL_NAME")
    private String fullName;

    @Column(name="F_EMAIL")
    private String email;

    @Column(name="F_PHONE")
    private String phone;

    @Column(name="F_ADDRESS")
    private String address;

    @Column(name="F_PASSWORD")
    private String password;

    @Column(name="F_STATUS")
    private Integer status;

    @Column(name="F_ADDITIONAL_INFO")
    private String additionalInfo;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name="F_ROLE_ID")
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Order> orders;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Comment> comments;
}
