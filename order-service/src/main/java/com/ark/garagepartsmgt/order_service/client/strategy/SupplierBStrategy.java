package com.ark.garagepartsmgt.order_service.client.strategy;

import com.ark.garagepartsmgt.order_service.client.SupplierStrategy;
import com.ark.garagepartsmgt.order_service.model.Order;
import org.springframework.stereotype.Component;

@Component
public class SupplierBStrategy implements SupplierStrategy {
    @Override
    public void placeOrder(Order order) {
        //TODO here we actually call the endpoints for the supplier B to place the order
        System.out.println("Placing Order to Supplier B");
    }
}
