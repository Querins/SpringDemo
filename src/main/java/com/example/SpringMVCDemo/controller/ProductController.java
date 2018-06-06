package com.example.SpringMVCDemo.controller;

import com.example.SpringMVCDemo.domain.Product;
import com.example.SpringMVCDemo.dto.ProductDTO;
import com.example.SpringMVCDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(path="/{id}")
    public Product getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postProduct(@RequestBody ProductDTO product) {
        service.postProduct(product);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@PathVariable Long id, @RequestBody ProductDTO product) {
        service.updateProduct(id, product);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Iterable<Product> getAllProducts() {
        return service.findAllProducts();
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeProduct(@PathVariable Long id) {
        service.removeProduct(id);
    }

}
