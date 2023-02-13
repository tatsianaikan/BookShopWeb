package com.example.bookshop.serviceimpl;

import com.example.bookshop.entity.Product;
import com.example.bookshop.mapper.Converter;
import com.example.bookshop.pojos.ProductObj;
import com.example.bookshop.repository.IProductRepository;
import com.example.bookshop.service.IProductService;
import jakarta.transaction.Transactional;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.bookshop.mapper.Converter.converter;

@Service("productServiceImpl")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Transactional
    public Product addProduct(ProductObj productObj) {
       return productRepository.save(converter.productToEntity(productObj));
    }

    @Transactional
    public Product editProduct(ProductObj productObj) {
        return productRepository.save(converter.productToEntity(productObj));
    }

    @Transactional
    public Product getProduct(int idProduct) {
        return productRepository.findById(idProduct).get();
    }

    @Transactional
    public Product searchProduct(int idProduct) {
        boolean exist = productRepository.equals(idProduct);
        return  exist? getProduct(idProduct) : null;
    }

    @Transactional
    public void deleteProduct(int idProduct) {
        productRepository.deleteById(idProduct);
    }

    @Transactional
    public List<Product> getAllProducts() {
        return(List<Product>) productRepository.findAll();
    }
}
