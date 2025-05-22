package com.getir.stockservice.service;

import com.getir.stockservice.dto.ProductCreatedEvent;

public interface StockService {
    void createStock(ProductCreatedEvent event);
}