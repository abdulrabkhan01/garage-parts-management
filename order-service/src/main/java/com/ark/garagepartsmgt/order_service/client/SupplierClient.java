package com.ark.garagepartsmgt.order_service.client;

import com.ark.garagepartsmgt.order_service.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SupplierClient {

    private final SupplierFactory supplierFactory;
    public void placeOrder(Order order) {
        supplierFactory.getSupplier(order.getSupplier()).placeOrder(order);
    }
}
