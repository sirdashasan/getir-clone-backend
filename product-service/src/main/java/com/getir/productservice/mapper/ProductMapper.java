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

    public Product toEntity(ProductRequest request) {
        return Product.builder()
                .nameTr(request.getNameTr())
                .nameEn(request.getNameEn())
                .slug(request.getSlug())
                .categorySlug(request.getCategorySlug())
                .subcategoryTr(request.getSubcategoryTr())
                .subcategoryEn(request.getSubcategoryEn())
                .price(request.getPrice())
                .oldPrice(request.getOldPrice())
                .quantity(request.getQuantity())
                .image(request.getImage())
                .build();
    }

    public void updateEntity(Product product, ProductRequest request) {
        product.setNameTr(request.getNameTr());
        product.setNameEn(request.getNameEn());
        product.setSlug(request.getSlug());
        product.setCategorySlug(request.getCategorySlug());
        product.setSubcategoryTr(request.getSubcategoryTr());
        product.setSubcategoryEn(request.getSubcategoryEn());
        product.setPrice(request.getPrice());
        product.setOldPrice(request.getOldPrice());
        product.setQuantity(request.getQuantity());
        product.setImage(request.getImage());
    }
}

