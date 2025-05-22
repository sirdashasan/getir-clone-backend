package com.getir.stockservice.message;

import com.getir.stockservice.dto.ProductCreatedEvent;
import com.getir.stockservice.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductCreatedListener {

    private final StockService stockService;

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void handleProductCreated(ProductCreatedEvent event) {
        stockService.createStock(event);
        System.out.println("✅ Stock created for product: " + event.getProductId());
    }
}
