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

    @NotBlank(message = "categorySlug must not be blank")
    private String categorySlug;

    @NotBlank(message = "subcategoryTr must not be blank")
    private String subcategoryTr;

    @NotBlank(message = "subcategoryEn must not be blank")
    private String subcategoryEn;

    @NotNull(message = "price must not be null")
    private Double price;

    @NotNull(message = "oldPrice must not be null")
    private Double oldPrice;

    @NotNull(message = "quantity must not be null")
    private Integer quantity;

    @NotBlank(message = "image must not be blank")
    private String image;
}
