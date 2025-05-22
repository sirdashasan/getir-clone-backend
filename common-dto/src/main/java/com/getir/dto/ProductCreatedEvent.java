package com.getir.dto;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreatedEvent implements Serializable {
    private String productId;
    private String nameTr;
    private String nameEn;
    private String categorySlugTr;
    private String categorySlugEn;
    private String subcategorySlugTr;
    private String subcategorySlugEn;
    private int quantity;
}
