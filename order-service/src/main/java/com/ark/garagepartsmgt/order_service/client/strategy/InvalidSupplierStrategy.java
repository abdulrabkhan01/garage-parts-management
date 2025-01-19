package com.ark.garagepartsmgt.order_service.client.strategy;

import com.ark.garagepartsmgt.order_service.client.SupplierStrategy;
import com.ark.garagepartsmgt.order_service.model.Order;
import org.springframework.stereotype.Component;

@Component
public class InvalidSupplierStrategy implements SupplierStrategy {
    @Override
    public void placeOrder(Order order) {
        System.out.println("Invalid Supplier, order cannot be placed");
    }
}
