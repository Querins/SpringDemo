package com.example.SpringMVCDemo.converter;

public interface CreateConverter<E, DTO> {

    E convert(DTO dto);

}
