package com.ecommerce.cart.controller;

import com.ecommerce.cart.model.CartItem;
import com.ecommerce.cart.repository.CartItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartItemRepository repo;

    public CartController(CartItemRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/{userId}")
    public List<CartItem> getCart(@PathVariable Long userId) {
        return repo.findByUserId(userId);
    }

    @PostMapping
    public CartItem addToCart(@RequestBody CartItem item) {
        return repo.save(item);
    }
}
