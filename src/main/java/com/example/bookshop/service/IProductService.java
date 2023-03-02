package com.example.bookshop.service;


import com.example.bookshop.entity.Product;
import com.example.bookshop.pojosdto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IProductService {
    public ProductDto addProduct(ProductDto productDto);
    public ProductDto editProduct(ProductDto bookingDto);
    public ProductDto getProduct (int idProduct);
    public ProductDto searchProduct (int idProduct);
    public String deleteProduct(int idProduct);

    public List<ProductDto> getAllProducts();
}
