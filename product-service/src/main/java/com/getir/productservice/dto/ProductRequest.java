package com.getir.productservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {

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

    @NotBlank(message = "subcategorySlugTr must not be blank")
    private String subcategorySlugTr;

    @NotBlank(message = "subcategorySlugEn must not be blank")
    private String subcategorySlugEn;

    @NotNull(message = "price must not be null")
    private Double price;

    @NotNull(message = "oldPrice must not be null")
    private Double oldPrice;

    @NotNull(message = "quantity must not be null")
    private Integer quantity;

    @NotBlank(message = "image must not be blank")
    private String image;
}
