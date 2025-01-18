package com.ark.garagepartsmgt.inventory_service.client;

import com.ark.garagepartsmgt.inventory_service.model.OrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "order-service") // Name of the order service (as registered in service discovery or configured directly)
public interface OrderServiceProxy {

    @PostMapping("/api/orders") // Path to the order creation endpoint in the order service
    void createOrder(@RequestBody OrderRequest orderRequest);
}