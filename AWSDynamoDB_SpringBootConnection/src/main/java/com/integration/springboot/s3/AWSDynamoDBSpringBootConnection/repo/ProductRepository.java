package com.integration.springboot.s3.AWSDynamoDBSpringBootConnection.repo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.integration.springboot.s3.AWSDynamoDBSpringBootConnection.entity.Product;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;


import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
	
	@Autowired
    private DynamoDbEnhancedClient dynamoDbEnhancedClient;
	
    private DynamoDbTable<Product> productTable;

    @PostConstruct
    public void init() {
        productTable = dynamoDbEnhancedClient.table("Product", TableSchema.fromBean(Product.class));
    }

    public Product save(Product product) {
        productTable.putItem(product);
        return product;
    }

    public Product findById(String id) {
        return productTable.getItem(r -> r.key(k -> k.partitionValue(id)));
    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        productTable.scan().items().forEach(products::add);
        return products;
    }

    public void deleteById(String id) {
        productTable.deleteItem(r -> r.key(k -> k.partitionValue(id)));
    }
}
