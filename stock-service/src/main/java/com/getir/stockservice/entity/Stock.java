package com.getir.stockservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "stocks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stock {

    @Id
    private String productId;

    private String nameTr;

    private String nameEn;

    private String categorySlugTr;

    private String categorySlugEn;

    private String subcategorySlugTr;

    private String subcategorySlugEn;

    private int availableQuantity;
}
