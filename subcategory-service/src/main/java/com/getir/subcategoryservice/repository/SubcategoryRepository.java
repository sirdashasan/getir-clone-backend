package com.getir.subcategoryservice.repository;

import com.getir.subcategoryservice.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubcategoryRepository extends JpaRepository<Subcategory, UUID> {
    Subcategory findBySlugTr(String slugTr);
    Subcategory findBySlugEn(String slugEn);
}
