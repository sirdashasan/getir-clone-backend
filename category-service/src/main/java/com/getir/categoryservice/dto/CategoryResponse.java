package com.getir.categoryservice.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponse {
    private UUID id;
    private String nameTr;
    private String nameEn;
    private String image;
    private String slugTr;
    private String slugEn;
}
