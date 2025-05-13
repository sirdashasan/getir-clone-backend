package com.getir.productservice.service;

import com.getir.dto.CategoryResponse;
import com.getir.productservice.dto.ProductRequest;
import com.getir.productservice.dto.ProductResponse;
import com.getir.productservice.entity.Product;
import com.getir.productservice.exceptions.ApiException;
import com.getir.productservice.mapper.ProductMapper;
import com.getir.productservice.repository.ProductRepository;
import com.getir.productservice.service.client.CategoryClient;
import com.getir.productservice.service.client.SubcategoryClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryClient categoryClient;
    private final SubcategoryClient subcategoryClient;

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse getProductBySlugTr(String slugTr) {
        Product product = productRepository.findBySlugTr(slugTr);
        if (product == null) {
            throw new ApiException("Product not found with slugTr: " + slugTr, HttpStatus.NOT_FOUND);
        }
        return productMapper.toResponse(product);
    }

    @Override
    public ProductResponse getProductBySlugEn(String slugEn) {
        Product product = productRepository.findBySlugEn(slugEn);
        if (product == null) {
            throw new ApiException("Product not found with slugEn: " + slugEn, HttpStatus.NOT_FOUND);
        }
        return productMapper.toResponse(product);
    }

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        boolean existsTr = productRepository.findBySlugTr(request.getSlugTr()) != null;
        boolean existsEn = productRepository.findBySlugEn(request.getSlugEn()) != null;

        if (existsTr || existsEn) {
            throw new ApiException("Product with same slugTr or slugEn already exists", HttpStatus.BAD_REQUEST);
        }

        // Category control - feign
        try {
            categoryClient.getBySlugTr(request.getCategorySlugTr());
        } catch (FeignException.NotFound e) {
            throw new ApiException("Category not found with slugTr: " + request.getCategorySlugTr(), HttpStatus.NOT_FOUND);
        }

        try {
            categoryClient.getBySlugEn(request.getCategorySlugEn());
        } catch (FeignException.NotFound e) {
            throw new ApiException("Category not found with slugEn: " + request.getCategorySlugEn(), HttpStatus.NOT_FOUND);
        }

        // Subcategory control - feign
        try {
            subcategoryClient.getBySlugTr(request.getSubcategorySlugTr());
        } catch (FeignException.NotFound e) {
            throw new ApiException("Subcategory not found with slugTr: " + request.getSubcategorySlugTr(), HttpStatus.NOT_FOUND);
        }

        try {
            subcategoryClient.getBySlugEn(request.getSubcategorySlugEn());
        } catch (FeignException.NotFound e) {
            throw new ApiException("Subcategory not found with slugEn: " + request.getSubcategorySlugEn(), HttpStatus.NOT_FOUND);
        }

        Product product = productMapper.toEntity(request);
        Product saved = productRepository.save(product);
        return productMapper.toResponse(saved);
    }

    @Override
    public ProductResponse updateProduct(UUID id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ApiException("Product not found with id: " + id, HttpStatus.NOT_FOUND));
        productMapper.updateEntity(product, request);
        return productMapper.toResponse(productRepository.save(product));
    }

    @Override
    public void deleteProduct(UUID id) {
        boolean exists = productRepository.existsById(id);
        if (!exists) {
            throw new ApiException("Product not found with id: " + id, HttpStatus.NOT_FOUND);
        }
        productRepository.deleteById(id);
    }
}
