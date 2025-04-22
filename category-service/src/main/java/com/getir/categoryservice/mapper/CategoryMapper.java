package com.getir.categoryservice.mapper;

import com.getir.categoryservice.dto.CategoryRequest;
import com.getir.categoryservice.dto.CategoryResponse;
import com.getir.categoryservice.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryResponse toResponse(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .nameTr(category.getNameTr())
                .nameEn(category.getNameEn())
                .image(category.getImage())
                .slugTr(category.getSlugTr())
                .slugEn(category.getSlugEn())
                .build();
    }

    public Category toEntity(CategoryRequest request) {
        return Category.builder()
                .nameTr(request.getNameTr())
                .nameEn(request.getNameEn())
                .image(request.getImage())
                .slugTr(request.getSlugTr().toLowerCase())
                .slugEn(request.getSlugEn().toLowerCase())
                .build();
    }

    public void updateEntity(Category category, CategoryRequest request) {
        category.setNameTr(request.getNameTr());
        category.setNameEn(request.getNameEn());
        category.setImage(request.getImage());
        category.setSlugTr(request.getSlugTr().toLowerCase());
        category.setSlugEn(request.getSlugEn().toLowerCase());
    }
}
