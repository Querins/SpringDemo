package com.example.SpringMVCDemo.converter;

import com.example.SpringMVCDemo.domain.Product;
import com.example.SpringMVCDemo.dto.ProductDTO;
import com.example.SpringMVCDemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class UpdateProductConverter implements UpdateConverter<Product, ProductDTO> {

    @Autowired
    private ProductRepository repository;

    @Override
    public Product convert(ProductDTO updateDTO, Product oldEntity) {

        String newName = updateDTO.getName();
        BigDecimal newPrice = updateDTO.getPrice();

        if(newName != null && !newName.equals(oldEntity.getName())) {
            for (Product p : repository.findAll()) {
                if (p.getName().equals(newName)) throw new RuntimeException("Product with given name already exists");
            }
            oldEntity.setName(newName);
        }

        if(newPrice != null && !newPrice.equals(oldEntity.getPrice())) {
            if (newPrice.compareTo(BigDecimal.ZERO) <= 0) {
                throw new RuntimeException("Can't set negative or zero price");
            }
            if (newPrice.divide(oldEntity.getPrice(), 2, RoundingMode.HALF_UP).doubleValue() > 1.5) {
                throw new RuntimeException("Cannot increase product price more than on 50%");
            } else {
                oldEntity.setPrice(newPrice);
            }
        }

        return oldEntity;

    }
}
