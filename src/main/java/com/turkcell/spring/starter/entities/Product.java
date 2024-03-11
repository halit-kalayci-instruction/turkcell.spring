package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="products")
@Entity
public class Product
{
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="unitprice")
    private double unitPrice;

    @Column(name="stock")
    private long stock;

    // private int categoryId; => YANLIŞ KULLANIM
    @ManyToOne()
    @JoinColumn(name="category_id")
    private Category category;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
// Event-Driven Development