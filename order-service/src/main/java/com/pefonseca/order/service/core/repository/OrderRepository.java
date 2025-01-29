package com.pefonseca.order.service.core.repository;

import com.pefonseca.order.service.core.document.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
