package com.getir.categoryservice.service;

import com.getir.categoryservice.dto.CategoryRequest;
import com.getir.categoryservice.dto.CategoryResponse;
import com.getir.categoryservice.entity.Category;
import com.getir.categoryservice.mapper.CategoryMapper;
import com.getir.categoryservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryManager implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponse)
                .collect(Collectors.toList());
    }


    @Override
    public CategoryResponse getCategoryBySlugTr(String slugTr) {
        Category category = categoryRepository.findBySlugTr(slugTr);
        return categoryMapper.toResponse(category);
    }

    @Override
    public CategoryResponse getCategoryBySlugEn(String slugEn) {
        Category category = categoryRepository.findBySlugEn(slugEn);
        if (category == null) {
            throw new RuntimeException("Category not found with slugEn: " + slugEn);
        }
        return categoryMapper.toResponse(category);
    }


    @Override
    public CategoryResponse createCategory(CategoryRequest request) {
        Category category = categoryMapper.toEntity(request);
        Category saved = categoryRepository.save(category);
        return categoryMapper.toResponse(saved);
    }

    @Override
    public CategoryResponse updateCategory(UUID id, CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        categoryMapper.updateEntity(category, request);
        return categoryMapper.toResponse(categoryRepository.save(category));
    }

    @Override
    public void deleteCategory(UUID id) {
        categoryRepository.deleteById(id);
    }
}
