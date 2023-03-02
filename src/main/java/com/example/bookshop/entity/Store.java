package com.example.bookshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name="Store_Item")
public class Store implements Serializable {

    @Id
    @Column(name="store_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column
    private int avaliable_qtu;

    @Column
    private int booked_qty;

    @Column
    private int sold_qty;
}
