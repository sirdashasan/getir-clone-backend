package com.getir.subcategoryservice.controller;

import com.getir.dto.SubcategoryResponse;
import com.getir.subcategoryservice.dto.SubcategoryRequest;

import com.getir.subcategoryservice.service.SubcategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/subcategories")
@RequiredArgsConstructor
public class SubcategoryController {

    private final SubcategoryService subcategoryService;

    @GetMapping
    public List<SubcategoryResponse> getAll() {
        return subcategoryService.getAllSubcategories();
    }

    @GetMapping("/slug-tr/{slug}")
    public ResponseEntity<SubcategoryResponse> getBySlugTr(@PathVariable String slug) {
        return ResponseEntity.ok(subcategoryService.getSubcategoriesBySlugTr(slug));
    }

    @GetMapping("/slug-en/{slug}")
    public ResponseEntity<SubcategoryResponse> getBySlugEn(@PathVariable String slug) {
        return ResponseEntity.ok(subcategoryService.getSubcategoriesBySlugEn(slug));
    }

    @PostMapping
    public ResponseEntity<SubcategoryResponse> create(@Valid @RequestBody SubcategoryRequest request,
                                                      @RequestHeader("X-Role") String role) {
        if (!"ROLE_ADMIN".equals(role)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return new ResponseEntity<>(subcategoryService.createSubcategory(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubcategoryResponse> update(@PathVariable UUID id,
                                                      @Valid @RequestBody SubcategoryRequest request,
                                                      @RequestHeader("X-Role") String role) {
        if (!"ROLE_ADMIN".equals(role)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(subcategoryService.updateSubcategory(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id,
                                       @RequestHeader("X-Role") String role) {
        if (!"ROLE_ADMIN".equals(role)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        subcategoryService.deleteSubcategory(id);
        return ResponseEntity.noContent().build();
    }
}
