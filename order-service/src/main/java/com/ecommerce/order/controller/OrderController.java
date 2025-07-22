package com.ecommerce.order.controller;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository repo;

    public OrderController(OrderRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        order.setOrderDate(new Date());
        order.setStatus("PLACED");
        return repo.save(order);
    }

    @GetMapping("/{userId}")
    public List<Order> getOrders(@PathVariable Long userId) {
        return repo.findByUserId(userId);
    }
}
