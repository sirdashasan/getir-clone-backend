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

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(name = "category_slug" , nullable = false)
    private String categorySlug;

    @Column(name = "subcategory_tr")
    private String subcategoryTr;

    @Column(name = "subcategory_en")
    private String subcategoryEn;

    private Double price;

    @Column(name = "old_price")
    private Double oldPrice;

    private String quantity;
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
