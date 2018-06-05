package com.example.SpringMVCDemo.repository;

import com.example.SpringMVCDemo.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
