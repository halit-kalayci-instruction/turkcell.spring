package com.turkcell.spring.starter.services.dtos.product.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {
    private String name;
    private double unitPrice;
    private long stock;
    private int categoryId;
}
