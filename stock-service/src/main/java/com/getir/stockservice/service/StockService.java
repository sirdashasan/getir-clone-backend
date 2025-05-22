package com.getir.stockservice.service;


import com.getir.dto.ProductCreatedEvent;

import java.util.UUID;

public interface StockService {
    void createStock(ProductCreatedEvent event);
    void deleteStock(String  productId);
}