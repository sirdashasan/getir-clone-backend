package com.getir.subcategoryservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubcategoryRequest {

    @NotBlank(message = "nameTr must not be blank")
    private String nameTr;

    @NotBlank(message = "nameEn must not be blank")
    private String nameEn;

    @NotBlank(message = "slugTr must not be blank")
    private String slugTr;

    @NotBlank(message = "slugEn must not be blank")
    private String slugEn;

    @NotBlank(message = "categorySlugTr must not be blank")
    private String categorySlugTr;

    @NotBlank(message = "categorySlugEn must not be blank")
    private String categorySlugEn;

}
