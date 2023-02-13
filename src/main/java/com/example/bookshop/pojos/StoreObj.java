package com.example.bookshop.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
public class StoreObj implements Serializable {

    private ProductObj product;
    private int avaliable_qtu;
    private int booked_qty;
    private int sold_qty;
}
