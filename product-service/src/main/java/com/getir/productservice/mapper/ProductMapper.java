package com.getir.productservice.mapper;

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
                .slug(product.getSlug())
                .categorySlug(product.getCategorySlug())
                .subcategoryTr(product.getSubcategoryTr())
                .subcategoryEn(product.getSubcategoryEn())
                .price(product.getPrice())
                .oldPrice(product.getOldPrice())
                .quantity(product.getQuantity())
                .image(product.getImage())
                .build();
    }
}
