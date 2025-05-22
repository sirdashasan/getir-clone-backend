package com.getir.stockservice.message;

import com.getir.dto.ProductDeletedEvent;
import com.getir.stockservice.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDeletedListener {

    private final StockService stockService;

    @RabbitListener(queues = RabbitMQConfig.PRODUCT_DELETED_QUEUE)
    public void handleProductDeleted(ProductDeletedEvent event) {
        stockService.deleteStock(event.getProductId());
        System.out.println("🗑️ Stock deleted for product: " + event.getProductId());
    }
}
