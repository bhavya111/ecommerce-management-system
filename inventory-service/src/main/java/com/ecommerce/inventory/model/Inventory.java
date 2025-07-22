package com.ecommerce.inventory.model;

import jakarta.persistence.*;

@Entity
public class Inventory {
    @Id
    private Long productId;
    private int quantity;

    // Getters and Setters
}
