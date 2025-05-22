package com.getir.stockservice.service;


import com.getir.dto.ProductCreatedEvent;
import com.getir.stockservice.mapper.StockMapper;
import com.getir.stockservice.repository.StockRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class StockManager implements StockService {

    private final StockRepository stockRepository;
    private final StockMapper stockMapper;

    @Override
    public void createStock(ProductCreatedEvent event) {
        stockRepository.save(stockMapper.toEntity(event));
    }

    @Override
    public void deleteStock(String  productId) {
        stockRepository.deleteById(productId);
    }
}