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
                .slug(category.getSlug())
                .build();
    }

    public Category toEntity(CategoryRequest request) {
        return Category.builder()
                .nameTr(request.getNameTr())
                .nameEn(request.getNameEn())
                .image(request.getImage())
                .slug(request.getSlug())
                .build();
    }

    public void updateEntity(Category category, CategoryRequest request) {
        category.setNameTr(request.getNameTr());
        category.setNameEn(request.getNameEn());
        category.setImage(request.getImage());
        category.setSlug(request.getSlug());
    }
}
