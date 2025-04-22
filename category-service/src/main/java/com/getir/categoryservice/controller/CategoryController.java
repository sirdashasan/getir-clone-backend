package com.getir.categoryservice.controller;

import com.getir.categoryservice.dto.CategoryRequest;
import com.getir.categoryservice.dto.CategoryResponse;
import com.getir.categoryservice.service.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponse> getAll() {
        return categoryService.getAllCategories();
    }


    @GetMapping("/slug-tr/{slug}")
    public ResponseEntity<CategoryResponse> getBySlugTr(@PathVariable String slug) {
        return ResponseEntity.ok(categoryService.getCategoryBySlugTr(slug));
    }

    @GetMapping("/slug-en/{slug}")
    public ResponseEntity<CategoryResponse> getBySlugEn(@PathVariable String slug) {
        return ResponseEntity.ok(categoryService.getCategoryBySlugEn(slug));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create( @RequestBody CategoryRequest request) {
        return new ResponseEntity<>(categoryService.createCategory(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable UUID id, @RequestBody CategoryRequest request) {
        return ResponseEntity.ok(categoryService.updateCategory(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
