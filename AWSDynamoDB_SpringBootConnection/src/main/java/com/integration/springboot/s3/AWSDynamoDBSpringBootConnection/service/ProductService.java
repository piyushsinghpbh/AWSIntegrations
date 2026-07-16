package com.integration.springboot.s3.AWSDynamoDBSpringBootConnection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integration.springboot.s3.AWSDynamoDBSpringBootConnection.entity.Product;
import com.integration.springboot.s3.AWSDynamoDBSpringBootConnection.repo.ProductRepository;


import java.util.List;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;

    public Product createProduct(Product product) {
        return repository.save(product);
    }

    public Product getProduct(String id) {
        return repository.findById(id);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product updateProduct(Product product) {
        return repository.save(product); // DynamoDB putItem replaces existing
    }

    public void deleteProduct(String id) {
        repository.deleteById(id);
    }
}
