package com.turkcell.spring.starter.services.dtos.product.requests;

import com.turkcell.spring.starter.services.constants.Messages;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {
    //TODO: Move to constants & add multi language
    @NotBlank(message = Messages.ValidationErrors.NOT_BLANK)
    @Size(min = 3, max = 25, message = Messages.ValidationErrors.SIZE)
    private String name;
    @Min(0)
    private double unitPrice;
    @Min(0)
    private long stock;
    @Min(1)
    private int categoryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
// 8:45