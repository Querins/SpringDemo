package com.example.SpringMVCDemo.converter;

public interface UpdateConverter<E, DTO> {

    E convert(DTO udateDTO, E oldEntity);

}
