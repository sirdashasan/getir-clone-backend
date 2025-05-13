package com.getir.categoryservice.service;

import com.getir.categoryservice.dto.CategoryRequest;
import com.getir.dto.CategoryResponse;


import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<CategoryResponse> getAllCategories();
    CategoryResponse getCategoryBySlugTr(String slugTr);
    CategoryResponse getCategoryBySlugEn(String slugEn);
    CategoryResponse createCategory(CategoryRequest request);
    CategoryResponse updateCategory(UUID id, CategoryRequest request);
    void deleteCategory(UUID id);
}
