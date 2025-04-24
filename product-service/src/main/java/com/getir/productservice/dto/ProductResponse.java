package com.getir.productservice.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private UUID id;
    private String nameTr;
    private String nameEn;
    private String slugTr;
    private String slugEn;
    private String categorySlugTr;
    private String categorySlugEn;
    private String subcategorySlugTr;
    private String subcategorySlugEn;
    private Double price;
    private Double oldPrice;
    private Integer quantity;
    private String image;
}
