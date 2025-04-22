package com.getir.productservice.service;

import com.getir.productservice.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    ProductResponse getProductBySlug(String slug);
}
