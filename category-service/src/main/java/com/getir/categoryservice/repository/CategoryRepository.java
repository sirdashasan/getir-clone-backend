package com.getir.categoryservice.repository;

import com.getir.categoryservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Category findBySlugTr(String slugTr);
    Category findBySlugEn(String slugEn);

}
