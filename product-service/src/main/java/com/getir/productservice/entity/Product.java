package com.getir.productservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name_tr", nullable = false)
    private String nameTr;

    @Column(name = "name_en")
    private String nameEn;

    @Column(name = "slug_tr", nullable = false, unique = true)
    private String slugTr;

    @Column(name = "slug_en", nullable = false, unique = true)
    private String slugEn;

    @Column(name = "category_slug_tr", nullable = false)
    private String categorySlugTr;

    @Column(name = "category_slug_en", nullable = false)
    private String categorySlugEn;

    @Column(name = "subcategory_slug_tr")
    private String subcategorySlugTr;

    @Column(name = "subcategory_slug_en")
    private String subcategorySlugEn;

    private Double price;

    @Column(name = "old_price")
    private Double oldPrice;

    private Integer quantity;
    private String image;

    @Column(columnDefinition = "TEXT")
    private String details;

    @Column(columnDefinition = "TEXT")
    private String ingredients;

    @Column(columnDefinition = "TEXT")
    private String usage;

    @Column(name = "additional_info", columnDefinition = "TEXT")
    private String additionalInfo;
}
