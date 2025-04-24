package com.getir.subcategoryservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "subcategory")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subcategory {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name_tr", nullable = false)
    private String nameTr;

    @Column(name = "name_en", nullable = false)
    private String nameEn;

    @Column(name = "slug_tr", nullable = false, unique = true)
    private String slugTr;

    @Column(name = "slug_en", nullable = false, unique = true)
    private String slugEn;

    @Column(name = "category_slug_tr", nullable = false)
    private String categorySlugTr;

    @Column(name = "category_slug_en", nullable = false)
    private String categorySlugEn;
}

