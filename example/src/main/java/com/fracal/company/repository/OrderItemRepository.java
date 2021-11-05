package com.fracal.company.repository;

import com.fracal.company.model.OrderItem;
import com.fracal.company.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends MongoRepository<OrderItem, String> {
}
