package com.getir.categoryservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name_tr", nullable = false)
    private String nameTr;

    @Column(name = "name_en")
    private String nameEn;

    private String image;

    @Column(name = "slug_tr", nullable = false, unique = true)
    private String slugTr;

    @Column(name = "slug_en", nullable = false, unique = true)
    private String slugEn;
}
