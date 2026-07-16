package com.integration.springboot.s3.AWSDynamoDBSpringBootConnection.entity;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
	
    private String id;
    private String name;
    private double price;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setId(String id) {
		this.id = id;
	}   
}
