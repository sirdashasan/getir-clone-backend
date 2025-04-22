package com.getir.productservice.repository;

import com.getir.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findBySlugTr(String slugTr);
    Product findBySlugEn(String slugEn);
}
