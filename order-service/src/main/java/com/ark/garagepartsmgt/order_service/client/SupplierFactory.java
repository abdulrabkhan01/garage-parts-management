package com.ark.garagepartsmgt.order_service.client;

import com.ark.garagepartsmgt.order_service.client.strategy.InvalidSupplierStrategy;
import com.ark.garagepartsmgt.order_service.client.strategy.SupplierAStrategy;
import com.ark.garagepartsmgt.order_service.client.strategy.SupplierBStrategy;
import com.ark.garagepartsmgt.order_service.model.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SupplierFactory {

    private final SupplierAStrategy supplierAStrategy;
    private final SupplierBStrategy supplierBStrategy;
    private final InvalidSupplierStrategy invalidSupplierStrategy;

    public SupplierStrategy getSupplier(Supplier supplier) {
        switch (supplier.name()) {
            case "SUPPLIER_A":
                return supplierAStrategy;
            case "SUPPLIER_B":
                return supplierBStrategy;
            default:
                return invalidSupplierStrategy;
        }
    }

}
