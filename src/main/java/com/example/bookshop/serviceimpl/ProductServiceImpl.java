package com.example.bookshop.serviceimpl;

import com.example.bookshop.entity.Product;
import com.example.bookshop.pojosdto.ProductDto;
import com.example.bookshop.repository.IProductRepository;
import com.example.bookshop.service.IProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.bookshop.mapper.Converter.converter;

@Service("productServiceImpl")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Transactional
    public ProductDto addProduct(ProductDto productDto) {
       Product productEntry = productRepository.save(converter.productToEntity(productDto));
       return converter.productToDto(productEntry);
    }

    @Transactional
    public ProductDto editProduct(ProductDto productDto) {
        Product productEntry = productRepository.save(converter.productToEntity(productDto));
        return converter.productToDto(productEntry);
    }

    @Transactional
    public ProductDto getProduct(long idProduct) {
        Product productEntry = productRepository.findById(idProduct).get();
        return converter.productToDto(productEntry);
    }

    @Transactional
    public ProductDto searchProduct(long idProduct) {
        boolean exist = productRepository.equals(idProduct);
        return  exist? getProduct(idProduct) : null;
    }

    @Transactional
    public String deleteProduct(long idProduct) {
        ProductDto productDto = new ProductDto();
        productDto =  getProduct(idProduct);

        productRepository.deleteById(idProduct);
        return productDto.getDescription() + " was deleted!";

    }

    @Transactional
    public List<ProductDto> getAllProducts() {
        List<Product> productList = (List<Product>) productRepository.findAll();
        return  productList.stream()
                           .map(productEntry -> converter.productToDto(productEntry))
                           .collect(Collectors.toList());
    }
}
