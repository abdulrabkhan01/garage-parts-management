package com.ark.garagepartsmgt.order_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private Long partId;
    private long quantity;
    private Supplier supplier;
}