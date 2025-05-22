package com.getir.stockservice.message;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "product.exchange";
    public static final String QUEUE = "product-created-queue";
    public static final String ROUTING_KEY = "product.created";
    public static final String PRODUCT_DELETED_QUEUE = "product-deleted-queue";
    public static final String PRODUCT_DELETED_ROUTING_KEY = "product.deleted";

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(ROUTING_KEY);
    }


    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(messageConverter());
        factory.setDefaultRequeueRejected(false);
        return factory;
    }

    @Bean
    public Queue deletedQueue() {
        return new Queue(PRODUCT_DELETED_QUEUE);
    }

    @Bean
    public Binding deletedBinding(Queue deletedQueue, TopicExchange exchange) {
        return BindingBuilder
                .bind(deletedQueue)
                .to(exchange)
                .with(PRODUCT_DELETED_ROUTING_KEY);
    }
}
