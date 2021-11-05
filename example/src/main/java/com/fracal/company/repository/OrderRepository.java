package com.fracal.company.repository;

import com.fracal.company.model.Order;
import com.fracal.company.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
}
