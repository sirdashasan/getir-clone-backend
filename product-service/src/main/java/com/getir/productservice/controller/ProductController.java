package com.getir.productservice.controller;

import com.getir.productservice.dto.ProductRequest;
import com.getir.productservice.dto.ProductResponse;
import com.getir.productservice.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponse> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/slug-tr/{slug}")
    public ResponseEntity<ProductResponse> getBySlugTr(@PathVariable String slug) {
        return ResponseEntity.ok(productService.getProductBySlugTr(slug));
    }

    @GetMapping("/slug-en/{slug}")
    public ResponseEntity<ProductResponse> getBySlugEn(@PathVariable String slug) {
        return ResponseEntity.ok(productService.getProductBySlugEn(slug));
    }


    @PostMapping
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest request) {
        return new ResponseEntity<>(productService.createProduct(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable UUID id, @Valid @RequestBody ProductRequest request) {
        return ResponseEntity.ok(productService.updateProduct(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
