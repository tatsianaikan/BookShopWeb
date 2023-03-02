package com.example.bookshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="User")
public class User implements Serializable {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column
    private String name;

    @Column
    private String login;

    @Column
    private String password;

   // @OneToMany
    @JoinColumn(name = "role_id", nullable = false)
    @Column
    private Role role;

    @Column
    private String email;

    @Column
    private Double phone;

    @Column
    private String address;
}
