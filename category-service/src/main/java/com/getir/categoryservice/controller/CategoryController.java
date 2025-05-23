package com.getir.categoryservice.controller;

import com.getir.categoryservice.dto.CategoryRequest;

import com.getir.categoryservice.service.CategoryService;
import com.getir.dto.CategoryResponse;
import jakarta.validation.Valid;
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
    public ResponseEntity<CategoryResponse> create(@Valid @RequestBody CategoryRequest request,
                                                   @RequestHeader("X-Role") String role) {
        if (!"ROLE_ADMIN".equals(role)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return new ResponseEntity<>(categoryService.createCategory(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable UUID id,
                                                   @Valid @RequestBody CategoryRequest request,
                                                   @RequestHeader("X-Role") String role) {
        if (!"ROLE_ADMIN".equals(role)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(categoryService.updateCategory(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id,
                                       @RequestHeader("X-Role") String role) {
        if (!"ROLE_ADMIN".equals(role)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
