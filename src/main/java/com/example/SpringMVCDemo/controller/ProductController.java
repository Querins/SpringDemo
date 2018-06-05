package com.example.SpringMVCDemo.controller;

import com.example.SpringMVCDemo.domain.Product;
import com.example.SpringMVCDemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping(path="/{id}")
    public Product getById(@PathVariable("id") Long id) {
        return repository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("Bad..."));
    }

    @PostMapping
    public void postProduct(Product product) {
        repository.save(product);
    }

    @GetMapping
    Iterable<Product> getAllProducts() {
        return repository.findAll();
    }

}
