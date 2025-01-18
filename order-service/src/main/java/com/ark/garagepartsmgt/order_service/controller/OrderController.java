package com.ark.garagepartsmgt.order_service.controller;

import com.ark.garagepartsmgt.order_service.model.Order;
import com.ark.garagepartsmgt.order_service.model.OrderRequest;
import com.ark.garagepartsmgt.order_service.repository.OrderRepository;
import com.ark.garagepartsmgt.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    private final OrderRepository orderRepository;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) { // Receive OrderRequest
        Order order = orderService.createOrder(orderRequest);
        if(order == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}