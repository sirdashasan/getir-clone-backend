package com.getir.subcategoryservice.dto;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubcategoryRequest {

    private String nameTr;
    private String nameEn;
    private String slugTr;
    private String slugEn;
    private String categorySlugTr;
    private String categorySlugEn;

}
