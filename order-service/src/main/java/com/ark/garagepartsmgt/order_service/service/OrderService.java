package com.ark.garagepartsmgt.order_service.service;

import com.ark.garagepartsmgt.order_service.model.Order;
import com.ark.garagepartsmgt.order_service.model.OrderRequest;
import com.ark.garagepartsmgt.order_service.model.Supplier;
import com.ark.garagepartsmgt.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order createOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setPartId(orderRequest.getPartId());
        order.setQuantity(orderRequest.getQuantity());
        order.setOrderDate(LocalDateTime.now());
        order.setSupplier(orderRequest.getSupplier()); // Set the supplier from the request

        if (orderRequest.getSupplier() == Supplier.SUPPLIER_B) { // Use enum comparison
            LocalTime currentTime = LocalTime.now();
            LocalTime startTime = LocalTime.of(0, 0); //12 pm
            LocalTime endTime = LocalTime.of(1, 0); //1 pm

            if (currentTime.isAfter(startTime) && currentTime.isBefore(endTime)) {
                System.out.println("Discount applied for Supplier B");
                // Apply discount logic here (e.g., update order price)
            } else {
                System.out.println("No discount available for Supplier B");
            }
        }

        return orderRepository.save(order);
    }
}
