package com.getir.categoryservice.service;

import com.getir.categoryservice.dto.CategoryRequest;
import com.getir.categoryservice.dto.CategoryResponse;
import com.getir.categoryservice.entity.Category;
import com.getir.categoryservice.exceptions.ApiException;
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
        if (category == null) {
            throw new ApiException("Category not found with slugEn: " + slugTr, HttpStatus.NOT_FOUND);
        }
        return categoryMapper.toResponse(category);
    }

    @Override
    public CategoryResponse getCategoryBySlugEn(String slugEn) {
        Category category = categoryRepository.findBySlugEn(slugEn);
        if (category == null) {
            throw new ApiException("Category not found with slugEn: " + slugEn, HttpStatus.NOT_FOUND);
        }
        return categoryMapper.toResponse(category);
    }


    @Override
    public CategoryResponse createCategory(CategoryRequest request) {
        boolean existsTr = categoryRepository.findBySlugTr(request.getSlugTr()) != null;
        boolean existsEn = categoryRepository.findBySlugEn(request.getSlugEn()) != null;

        if (existsTr || existsEn) {
            throw new ApiException("Category with same slugTr or slugEn already exists", HttpStatus.BAD_REQUEST);
        }

        Category category = categoryMapper.toEntity(request);
        Category saved = categoryRepository.save(category);
        return categoryMapper.toResponse(saved);
    }

    @Override
    public CategoryResponse updateCategory(UUID id, CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ApiException("Category not found with id: " + id, HttpStatus.NOT_FOUND));
        categoryMapper.updateEntity(category, request);
        return categoryMapper.toResponse(categoryRepository.save(category));
    }

    @Override
    public void deleteCategory(UUID id) {
        boolean exists = categoryRepository.existsById(id);
        if (!exists) {
            throw new ApiException("Category not found with id: " + id, HttpStatus.NOT_FOUND);
        }
        categoryRepository.deleteById(id);
    }

}
