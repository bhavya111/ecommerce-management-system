package com.ecommerce.inventory.controller;

import com.ecommerce.inventory.model.Inventory;
import com.ecommerce.inventory.repository.InventoryRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryRepository repo;

    public InventoryController(InventoryRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/{productId}")
    public Inventory check(@PathVariable Long productId) {
        return repo.findById(productId).orElse(null);
    }

    @PostMapping
    public Inventory createOrUpdate(@RequestBody Inventory inventory) {
        return repo.save(inventory);
    }

    @PutMapping("/mark-out-of-stock/{productId}")
    public Inventory markOutOfStock(@PathVariable Long productId) {
        Inventory inv = repo.findById(productId).orElse(null);
        if (inv != null) {
            inv.setQuantity(0);
            return repo.save(inv);
        }
        return null;
    }
}
