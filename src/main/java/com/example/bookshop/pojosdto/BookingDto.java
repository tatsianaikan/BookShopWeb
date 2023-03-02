package com.example.bookshop.pojosdto;

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
public class BookingDto implements Serializable {

    private Long bookingId;
    private ProductDto product;
    private String description;
    private UserDto user;
    private Date date;
    private Time time;
    private StatusDto status;
    private int quantity;

    public BookingDto(StatusDto status, String description, ProductDto product, UserDto user){
        this.status = status;
        this.description = description;
        this.product = product;
        this.user = user;
    }
}
