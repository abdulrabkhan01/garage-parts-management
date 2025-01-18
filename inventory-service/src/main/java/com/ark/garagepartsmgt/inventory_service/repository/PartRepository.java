package com.ark.garagepartsmgt.inventory_service.repository;


import com.ark.garagepartsmgt.inventory_service.model.Part;
import com.ark.garagepartsmgt.inventory_service.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {

    // Find parts where available quantity is less than their threshold
    @Query("SELECT p FROM Part p WHERE p.availableQty < p.threshold")
    List<Part> findByAvailableQtyLessThanThreshold();

    // Find parts by name (for searching or other purposes)
    Optional<Part> findByName(String name);

    // Find parts by Supplier
    List<Part> findBySupplier(Supplier supplier);

    //Find parts by name containing
    List<Part> findByNameContaining(String name);

    //Find Parts with QTY < quantity
    List<Part> findByAvailableQtyGreaterThan(long quantity);
    //Find Parts with QTY > quantity
    List<Part> findByAvailableQtyLessThan(long quantity);

}