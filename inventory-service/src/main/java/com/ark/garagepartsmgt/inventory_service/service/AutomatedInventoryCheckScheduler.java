package com.ark.garagepartsmgt.inventory_service.service;

import com.ark.garagepartsmgt.inventory_service.client.OrderServiceProxy;
import com.ark.garagepartsmgt.inventory_service.model.OrderRequest;
import com.ark.garagepartsmgt.inventory_service.model.Part;
import com.ark.garagepartsmgt.inventory_service.model.Supplier;
import com.ark.garagepartsmgt.inventory_service.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AutomatedInventoryCheckScheduler {

    private final PartRepository partRepository;
    private final OrderServiceProxy orderServiceProxy; // Feign client for order service

    @Value("${inventory.check.interval}")
    private String inventoryCheckInterval;

    @Scheduled(cron = "${inventory.check.interval}")
    public void checkInventoryLevels() {
        List<Part> partsBelowThreshold = partRepository.findByAvailableQtyLessThanThreshold();
        for (Part part : partsBelowThreshold) {
            // Create an order request with the part ID and minimum order quantity
            if (part.getSupplier() == Supplier.SUPPLIER_B) { // Use enum comparison
                LocalTime currentTime = LocalTime.now();
                LocalTime startTime = LocalTime.of(0, 0); //12 pm
                LocalTime endTime = LocalTime.of(1, 0); //1 pm
                if (currentTime.isAfter(startTime) && currentTime.isBefore(endTime)) {
                    System.out.println("Discount applied for Supplier B");
                    OrderRequest orderRequest = new OrderRequest(part.getId(), part.getMinOrderQty(), part.getSupplier());
                    orderServiceProxy.createOrder(orderRequest);
                } else {
                    System.out.println("No discount available for Supplier B, not placing the order");
                }
            } else {
                OrderRequest orderRequest = new OrderRequest(part.getId(), part.getMinOrderQty(), part.getSupplier());
                orderServiceProxy.createOrder(orderRequest);
            }

        }
    }
}