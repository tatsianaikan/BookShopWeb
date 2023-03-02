package com.example.bookshop.pojosdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {

    private String name;
    private String description;
    private String author;
    private float price;
    private String image_path;

   public ProductDto(String name){
        this.name = name;
    }
}
