package com.integration.springboot.s3.AWSDynamoDBSpringBootConnection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.integration.springboot.s3.AWSDynamoDBSpringBootConnection.entity.Product;
import com.integration.springboot.s3.AWSDynamoDBSpringBootConnection.service.ProductService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

	@Autowired
    private ProductService service;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return service.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable String id) {
        return service.getProduct(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        service.deleteProduct(id);
    }
}