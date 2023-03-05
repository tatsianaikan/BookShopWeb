package com.example.bookshop.repository;



import com.example.bookshop.entity.Product;
import com.example.bookshop.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface IProductRepository extends CrudRepository<Product, Long> {
}
