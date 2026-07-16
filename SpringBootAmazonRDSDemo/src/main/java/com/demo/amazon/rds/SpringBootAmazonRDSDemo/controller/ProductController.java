package com.demo.amazon.rds.SpringBootAmazonRDSDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.amazon.rds.SpringBootAmazonRDSDemo.entity.Product;
import com.demo.amazon.rds.SpringBootAmazonRDSDemo.repo.ProductRepository;

@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository repo;
	
	@PostMapping("product")
	public Product save(@RequestBody Product product) {
		return repo.save(product);		
	}
	
	
	@GetMapping("/products")
	public List<Product> getAll(){
		return repo.findAll();				
	}
}
