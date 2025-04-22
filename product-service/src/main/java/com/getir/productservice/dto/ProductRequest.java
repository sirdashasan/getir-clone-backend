package com.getir.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {
    private String nameTr;
    private String nameEn;
    private String slug;
    private String categorySlug;
    private String subcategoryTr;
    private String subcategoryEn;
    private Double price;
    private Double oldPrice;
    private Integer quantity;
    private String image;
}

