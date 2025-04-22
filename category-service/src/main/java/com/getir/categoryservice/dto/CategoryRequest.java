package com.getir.categoryservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryRequest {

    @NotBlank(message = "nameTr must not be blank")
    private String nameTr;

    @NotBlank(message = "nameEn must not be blank")
    private String nameEn;

    @NotBlank(message = "image must not be blank")
    private String image;

    @NotBlank(message = "slugTr must not be blank")
    private String slugTr;

    @NotBlank(message = "slugEn must not be blank")
    private String slugEn;
}
