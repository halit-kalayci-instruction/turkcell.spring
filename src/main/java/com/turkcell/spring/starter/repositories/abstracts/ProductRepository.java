package com.turkcell.spring.starter.repositories.abstracts;

import com.turkcell.spring.starter.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
}
