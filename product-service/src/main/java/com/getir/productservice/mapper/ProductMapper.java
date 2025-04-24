package com.getir.productservice.mapper;


import com.getir.productservice.dto.ProductRequest;
import com.getir.productservice.dto.ProductResponse;
import com.getir.productservice.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .nameTr(product.getNameTr())
                .nameEn(product.getNameEn())
                .slugTr(product.getSlugTr())
                .slugEn(product.getSlugEn())
                .categorySlugTr(product.getCategorySlugTr())
                .categorySlugEn(product.getCategorySlugEn())
                .subcategorySlugTr(product.getSubcategorySlugTr())
                .subcategorySlugEn(product.getSubcategorySlugEn())
                .price(product.getPrice())
                .oldPrice(product.getOldPrice())
                .quantity(product.getQuantity())
                .image(product.getImage())
                .build();
    }

    public Product toEntity(ProductRequest request) {
        return Product.builder()
                .nameTr(request.getNameTr())
                .nameEn(request.getNameEn())
                .slugTr(request.getSlugTr().toLowerCase())
                .slugEn(request.getSlugEn().toLowerCase())
                .categorySlugTr(request.getCategorySlugTr().toLowerCase())
                .categorySlugEn(request.getCategorySlugEn().toLowerCase())
                .subcategorySlugTr(request.getSubcategorySlugTr().toLowerCase())
                .subcategorySlugEn(request.getSubcategorySlugEn().toLowerCase())
                .price(request.getPrice())
                .oldPrice(request.getOldPrice())
                .quantity(request.getQuantity())
                .image(request.getImage())
                .build();
    }

    public void updateEntity(Product product, ProductRequest request) {
        product.setNameTr(request.getNameTr());
        product.setNameEn(request.getNameEn());
        product.setSlugTr(request.getSlugTr().toLowerCase());
        product.setSlugEn(request.getSlugEn().toLowerCase());
        product.setCategorySlugTr(request.getCategorySlugTr().toLowerCase());
        product.setCategorySlugEn(request.getCategorySlugEn().toLowerCase());
        product.setSubcategorySlugTr(request.getSubcategorySlugTr().toLowerCase());
        product.setSubcategorySlugEn(request.getSubcategorySlugEn().toLowerCase());
        product.setPrice(request.getPrice());
        product.setOldPrice(request.getOldPrice());
        product.setQuantity(request.getQuantity());
        product.setImage(request.getImage());
    }
}

