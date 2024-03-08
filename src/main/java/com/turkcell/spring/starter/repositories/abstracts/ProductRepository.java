package com.turkcell.spring.starter.repositories.abstracts;

import com.turkcell.spring.starter.entities.Product;
import com.turkcell.spring.starter.services.dtos.product.responses.ProductListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
    // Native Query => Saf SQL
    //@Query(value="Select * from products where LOWER(name) LIKE %:query% ", nativeQuery = true)

    // JPQL => JPA + SQL
    @Query(value = "Select p from Product p WHERE LOWER(p.name) LIKE %:query%")
    List<Product> search(String query);
    @Query(value = "Select new com.turkcell.spring.starter.services.dtos.product.responses.ProductListResponse" +
            "(p.id, p.name, c.name, p.unitPrice)" +
            " from Product p JOIN p.category c" +
            " WHERE lower(p.name) LIKE %:query%"
            )
    List<ProductListResponse> searchDto(String query);

    // Derived Query Methods
    // Oto hazırlanmış method isimlendirmeleri
    List<Product> findByUnitPriceGreaterThan(double unitPrice);
}
// 8:15