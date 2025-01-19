package com.ark.garagepartsmgt.order_service.client;

import com.ark.garagepartsmgt.order_service.model.Order;

public interface SupplierStrategy {
    void placeOrder(Order order);

}
