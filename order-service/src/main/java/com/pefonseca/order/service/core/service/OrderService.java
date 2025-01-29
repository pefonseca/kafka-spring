package com.pefonseca.order.service.core.service;

import com.pefonseca.order.service.core.document.Event;
import com.pefonseca.order.service.core.document.Order;
import com.pefonseca.order.service.core.dto.OrderRequest;
import com.pefonseca.order.service.core.producer.SagaProducer;
import com.pefonseca.order.service.core.repository.OrderRepository;
import com.pefonseca.order.service.core.utils.JsonUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {

    private static final String TRANSACTION_ID_PATTERN = "%s_%s";

    private final EventService eventService;
    private final SagaProducer producer;
    private final JsonUtil jsonUtil;
    private final OrderRepository orderRepository;

    public Order createOrder(OrderRequest orderRequest) {
        var order = Order.builder()
                         .products(orderRequest.getProducts())
                         .createdAt(LocalDateTime.now())
                         .transactionId(String.format(TRANSACTION_ID_PATTERN, Instant.now().toEpochMilli(), UUID.randomUUID()))
                         .build();

        orderRepository.save(order);

        var event = jsonUtil.toJson(createPayload(order));

        producer.sendEvent(event);

        return order;
    }

    private Event createPayload(Order order) {
        var event = Event.builder()
                         .orderId(order.getId())
                         .transactionId(order.getTransactionId())
                         .payload(order)
                         .createdAt(LocalDateTime.now())
                         .build();

        return eventService.save(event);
    }

}
