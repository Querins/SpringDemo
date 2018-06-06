package com.example.SpringMVCDemo.dto;

import java.math.BigDecimal;

public class ProductDTO {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    String name;
    BigDecimal price;

}
