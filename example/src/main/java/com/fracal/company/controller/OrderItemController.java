package com.fracal.company.controller;

import com.fracal.company.model.OrderItem;
import com.fracal.company.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orderItems")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/create")
    public void createProduct(@RequestBody OrderItem orderItem) {
        orderItemService.create(orderItem);
    }

    @PostMapping("/edit")
    public void editOrder(@RequestBody OrderItem orderItem) {
        orderItemService.edit(orderItem);
    }

    @GetMapping("/list")
    public List<OrderItem> listOrders() {
        return orderItemService.list();
    }

    @PostMapping("/search/{id}")
    public OrderItem searchOrder(@PathVariable String id) {
        return orderItemService.search(id).get();
    }

    @PostMapping("/search/date/{date}")
    public List<OrderItem> searchOrderItemDate(@PathVariable String date) {
        return orderItemService.list().stream().filter(
                        data -> data.getDate().equalsIgnoreCase(date))
                .collect(Collectors.toList());
    }

    @PostMapping("/search/quantity/{quantity}")
    public List<OrderItem> searchOrderItemQuantity(@PathVariable String quantity) {
        return orderItemService.list().stream().filter(
                        data -> data.getQuantity() > Integer.parseInt(quantity))
                .collect(Collectors.toList());
    }

    @PostMapping("/delete/{id}")
    public void deleteOrderItem(@PathVariable String id) {
        orderItemService.delete(id);
    }
}