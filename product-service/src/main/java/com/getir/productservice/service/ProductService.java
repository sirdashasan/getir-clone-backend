package com.getir.productservice.service;

import com.getir.productservice.dto.ProductRequest;
import com.getir.productservice.dto.ProductResponse;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    ProductResponse getProductBySlugTr(String slugTr);
    ProductResponse getProductBySlugEn(String slugEn);
    ProductResponse createProduct(ProductRequest request);
    ProductResponse updateProduct(UUID id, ProductRequest request);
    void deleteProduct(UUID id);
}
