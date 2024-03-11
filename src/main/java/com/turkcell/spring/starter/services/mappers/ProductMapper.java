package com.turkcell.spring.starter.services.mappers;

import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.services.dtos.product.requests.AddProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper
{
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "categoryId", target = "category.id")
    //@Mapping(source = )
    Product productFromAddRequest(AddProductRequest request);
}
