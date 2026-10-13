package com.project.glowweb.Controller;

import org.springframework.data.domain.Sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.glowweb.Entity.Order;
import com.project.glowweb.Repo.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;


    // CREATE ORDER
    @PostMapping
    public Order createOrder(@RequestBody Order order) {

        String orderId =
                "GLO" + System.currentTimeMillis();

        order.setId(orderId);

        order.setOrderDate(
                LocalDateTime.now()
        );

        order.setStatus("Processing");

        return orderRepository.save(order);
    }


    // GET ALL ORDERS - ADMIN
    @GetMapping
    public List<Order> getAllOrders() {

        return orderRepository.findAll(Sort.by(Sort.Direction.DESC,"subtotal"));
    }


    // GET ONE ORDER
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable String id) {

        return orderRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Order not found"
                        )
                );
    }


    // UPDATE ORDER STATUS - ADMIN
    @PutMapping("/{id}/status")
    public Order updateOrderStatus(
            @PathVariable String id,
            @RequestParam String status
    ) {

        Order order =
                orderRepository
                        .findById(id)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Order not found"
                                )
                        );

        order.setStatus(status);

        return orderRepository.save(order);
    }
}