package com.getir.stockservice.service;


import com.getir.dto.ProductCreatedEvent;

public interface StockService {
    void createStock(ProductCreatedEvent event);
}