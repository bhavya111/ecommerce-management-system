package com.ecommerce.product;

import com.ecommerce.product.model.Product;
import com.ecommerce.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ProductServiceTests {

    @Autowired
    private ProductRepository repo;

    @Test
    public void testCreateProduct() {
        Product product = new Product();
        product.setName("Test");
        product.setCategory("Electronics");
        product.setPrice(100);
        product.setDescription("Test Desc");

        Product saved = repo.save(product);
        assertNotNull(saved.getId());
    }
}
