package com.turkcell.spring.starter.services.mappers;

import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.services.dtos.product.requests.AddProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper
{
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class); // blueprint

    @Mapping(source = "categoryId", target = "category.id")
    Product productFromAddRequest(AddProductRequest request);
    // Aynı isime sahip alanlar oto eşlenir.
    // Farklı isime sahip alanlar configure edilmelidir.

}
