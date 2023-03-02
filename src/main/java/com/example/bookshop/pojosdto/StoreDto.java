package com.example.bookshop.pojosdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
public class StoreDto implements Serializable {

    private ProductDto product;
    private int avaliable_qtu;
    private int booked_qty;
    private int sold_qty;
}
