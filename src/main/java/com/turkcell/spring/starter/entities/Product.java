package com.turkcell.spring.starter.entities;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="products")
@Entity
@Data
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
}
// Event-Driven Development