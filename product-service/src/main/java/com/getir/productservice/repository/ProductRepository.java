package com.getir.productservice.repository;

import com.getir.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findBySlug(String slug);
}
