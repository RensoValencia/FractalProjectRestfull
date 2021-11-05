package com.fracal.company.controller;

import com.fracal.company.model.Order;
import com.fracal.company.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public void createOrder(@RequestBody Order order) {
        orderService.create(order);
    }

    @PostMapping("/edit")
    public void editOrder(@RequestBody Order order) {
        orderService.edit(order);
    }

    @GetMapping("/list")
    public List<Order> listOrders() {
        return orderService.list();
    }

    @PostMapping("/search/{id}")
    public Order searchOrder(@PathVariable String id) {
        return orderService.search(id).get();
    }

    @PostMapping("/search/status/{status}")
    public List<Order> searchOrderName(@PathVariable String status) {
        return orderService.list().stream().filter(
                        data -> data.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    @PostMapping("/search/customer/{customer}")
    public List<Order> searchOrderCategory(@PathVariable String customer) {
        return orderService.list().stream().filter(
                         data -> data.getCustomer().equalsIgnoreCase(customer))
                .collect(Collectors.toList());
    }

    @PostMapping("/delete/{id}")
    public void deleteOrder(@PathVariable String id) {
        orderService.delete(id);
    }
}