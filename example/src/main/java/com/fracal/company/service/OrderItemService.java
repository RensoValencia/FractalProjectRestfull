package com.fracal.company.service;

import com.fracal.company.model.OrderItem;
import com.fracal.company.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public void create(OrderItem orderItem) {
        orderItemRepository.insert(orderItem);
    }

    public void edit(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    public Optional<OrderItem> search(String orderItemId) {
        return orderItemRepository.findById(orderItemId);
    }

    public void delete(String orderItemId) {
        orderItemRepository.deleteById(orderItemId);
    }

    public List<OrderItem> list() {
        return orderItemRepository.findAll();
    }
}