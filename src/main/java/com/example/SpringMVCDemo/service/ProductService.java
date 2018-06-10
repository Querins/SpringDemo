package com.example.SpringMVCDemo.service;

import com.example.SpringMVCDemo.converter.CreateProductCreateConverter;
import com.example.SpringMVCDemo.converter.UpdateProductConverter;
import com.example.SpringMVCDemo.domain.Product;
import com.example.SpringMVCDemo.dto.ProductDTO;
import com.example.SpringMVCDemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private CreateProductCreateConverter createProductCreateConverter;

    @Autowired
    private UpdateProductConverter updateProductConverter;

    @Autowired
    private ProductRepository repository;

    private Product findEntityUnsafe(long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Product with given ID not found"));
    }

    public Product getById(long id) {
        return findEntityUnsafe(id);
    }

    public Iterable<Product> findAllProducts() {
        return repository.findAll();
    }

    public Product postProduct(ProductDTO productDTO) {
        Product createdProduct = createProductCreateConverter.convert(productDTO);
        repository.save(createdProduct);
        return createdProduct;
    }

    public void updateProduct(Long id, ProductDTO newProduct) {
        Product oldProduct = findEntityUnsafe(id);
        Product updatedProduct = updateProductConverter.convert(newProduct, oldProduct);
        repository.save(updatedProduct);
    }

    public void removeProduct(long id) {
        repository.delete(findEntityUnsafe(id));
    }
}
