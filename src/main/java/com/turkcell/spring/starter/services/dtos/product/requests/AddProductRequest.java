package com.turkcell.spring.starter.services.dtos.product.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {
    //TODO: Move to constants & add multi language
    @NotBlank(message = "Ürün ismi boş olamaz.")
    @Size(min = 3, max = 25, message = "Ürün ismi 3 ile 25 karakter arasında olmalıdır.")
    private String name;
    @Min(0)
    private double unitPrice;
    @Min(0)
    private long stock;
    @Min(1)
    private int categoryId;
}
// 8:45