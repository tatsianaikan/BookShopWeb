package com.example.bookshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name="Product")
public class Product implements Serializable {

    @Id
    @Column(name="product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Column(unique = true)
    private String name;

    @Column
    private String description;

    @Column
    private String author;

    @Column
    private float price;

    @Column
    private String image_path;
}
