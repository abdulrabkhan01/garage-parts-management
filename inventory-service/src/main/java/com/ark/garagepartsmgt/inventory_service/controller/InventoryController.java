package com.ark.garagepartsmgt.inventory_service.controller;

import com.ark.garagepartsmgt.inventory_service.model.Part;
import com.ark.garagepartsmgt.inventory_service.repository.PartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final PartRepository partRepository; // Inject the PartRepository

    @GetMapping
    public List<Part> getAllParts() {
        return partRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Part> getPartById(@PathVariable Long id) {
        Optional<Part> part = partRepository.findById(id);
        return part.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Part createPart(@Valid @RequestBody Part part) {
        return partRepository.save(part);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Part> updatePart(@PathVariable Long id, @Valid @RequestBody Part updatedPart) {
        return partRepository.findById(id)
                .map(part -> {
                    part.setName(updatedPart.getName());
                    part.setThreshold(updatedPart.getThreshold());
                    part.setSupplier(updatedPart.getSupplier());
                    part.setAvailableQty(updatedPart.getAvailableQty());
                    part.setMinOrderQty(updatedPart.getMinOrderQty());
                    return ResponseEntity.ok(partRepository.save(part));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/quantity")
    public ResponseEntity<Part> updatePartQuantity(@PathVariable Long id, @RequestBody int quantity) {
        return partRepository.findById(id)
                .map(part -> {
                    part.setAvailableQty(quantity);
                    return ResponseEntity.ok(partRepository.save(part));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}