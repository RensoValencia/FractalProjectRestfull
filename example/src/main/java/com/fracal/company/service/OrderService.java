package com.fracal.company.service;

import com.fracal.company.model.Order;
import com.fracal.company.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void create(Order order) {
        orderRepository.insert(order);
    }

    public void edit(Order order) {
        orderRepository.save(order);
    }

    public Optional<Order> search(String orderId) {
        return orderRepository.findById(orderId);
    }

    public void delete(String orderId) {
        orderRepository.deleteById(orderId);
    }

    public List<Order> list() {
        return orderRepository.findAll();
    }
}