package com.turkcell.spring.starter.services.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductForListingDto {
    private int id;
    private String name;
    private String categoryName;
    private double unitPrice;
}
