package com.ark.garagepartsmgt.inventory_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    private long partId;
    private long quantity;
    private Supplier supplier;

}
