package com.expenses.orderservice.dto;

import lombok.Data;

@Data
public class OrderDto {

	private Long userId;
	private Long productId;
	private int quantity;
	
}
