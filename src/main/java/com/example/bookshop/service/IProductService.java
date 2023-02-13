package com.example.bookshop.service;


import com.example.bookshop.entity.Product;
import com.example.bookshop.pojos.ProductObj;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IProductService {
    public Product addProduct(ProductObj productObj);
    public Product editProduct(ProductObj bookingObj);
    public Product getProduct (int idProduct);
    public Product searchProduct (int idProduct);
    public void deleteProduct(int idProduct);

    public List<Product> getAllProducts();
}
