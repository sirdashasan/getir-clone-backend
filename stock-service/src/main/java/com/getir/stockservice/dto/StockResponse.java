package com.getir.stockservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockResponse {
    private String productId;
    private String nameTr;
    private String nameEn;
    private String categorySlugTr;
    private String categorySlugEn;
    private String subcategorySlugTr;
    private String subcategorySlugEn;
    private int availableQuantity;
}
