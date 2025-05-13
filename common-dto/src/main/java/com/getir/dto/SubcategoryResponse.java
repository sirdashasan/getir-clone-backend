package com.getir.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubcategoryResponse {
    private UUID id;
    private String nameTr;
    private String nameEn;
    private String slugTr;
    private String slugEn;
    private String categorySlugTr;
    private String categorySlugEn;
}
