package com.getir.stockservice.mapper;

import com.getir.dto.ProductCreatedEvent;
import com.getir.stockservice.dto.StockResponse;
import com.getir.stockservice.entity.Stock;
import org.springframework.stereotype.Component;

@Component
public class StockMapper {

    public Stock toEntity(ProductCreatedEvent event) {
        return Stock.builder()
                .productId(event.getProductId())
                .nameTr(event.getNameTr())
                .nameEn(event.getNameEn())
                .categorySlugTr(event.getCategorySlugTr())
                .categorySlugEn(event.getCategorySlugEn())
                .subcategorySlugTr(event.getSubcategorySlugTr())
                .subcategorySlugEn(event.getSubcategorySlugEn())
                .availableQuantity(event.getQuantity())
                .build();
    }

    public StockResponse toResponse(Stock stock) {
        return StockResponse.builder()
                .productId(stock.getProductId())
                .nameTr(stock.getNameTr())
                .nameEn(stock.getNameEn())
                .categorySlugTr(stock.getCategorySlugTr())
                .categorySlugEn(stock.getCategorySlugEn())
                .subcategorySlugTr(stock.getSubcategorySlugTr())
                .subcategorySlugEn(stock.getSubcategorySlugEn())
                .availableQuantity(stock.getAvailableQuantity())
                .build();
    }
}
