package com.getir.categoryservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryRequest {
    private String nameTr;
    private String nameEn;
    private String image;
    private String slug;
}
