package com.example.bookshop.pojos;

import com.example.bookshop.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookingObj implements Serializable {

    private Long bookingId;
    private ProductObj product;
    private String description;
    private UserObj user;
    private Date date;
    private Time time;
    private StatusObj status;
    private int quantity;

    public BookingObj(StatusObj status, String description, ProductObj product, UserObj user){
        this.status = status;
        this.description = description;
        this.product = product;
        this.user = user;
    }
}
