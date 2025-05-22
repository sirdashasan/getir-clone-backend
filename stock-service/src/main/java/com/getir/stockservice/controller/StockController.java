package com.getir.stockservice.controller;

import com.getir.stockservice.dto.StockResponse;
import com.getir.stockservice.mapper.StockMapper;
import com.getir.stockservice.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockRepository stockRepository;
    private final StockMapper stockMapper;

    @GetMapping
    public List<StockResponse> getAllStocks() {
        return stockRepository.findAll()
                .stream()
                .map(stockMapper::toResponse)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{productId}")
    public void deleteStock(@PathVariable String productId) {
        stockRepository.deleteById(productId);
    }
}
