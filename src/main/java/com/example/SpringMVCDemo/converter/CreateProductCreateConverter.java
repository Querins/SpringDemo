package com.example.SpringMVCDemo.converter;

import com.example.SpringMVCDemo.domain.Product;
import com.example.SpringMVCDemo.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateProductCreateConverter implements CreateConverter<Product, ProductDTO> {

    @Override
    public Product convert(ProductDTO productDTO) {

        if(productDTO.getName() == null) {
            throw new RuntimeException("name is required");
        }

        if(productDTO.getPrice() == null) {
            throw new RuntimeException("price is required");
        }

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        return product;
    }
}
