package com.example.bookshop.repository;

import com.example.bookshop.entity.Status;
import org.springframework.data.repository.CrudRepository;

public interface IStatusRepository extends CrudRepository<Status, Integer> {
}
