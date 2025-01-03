package com.expenses.orderservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.expenses.orderservice.dto.OrderDto;

public class OrderController {

	public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDto){
		
		
		return null;
	}
}
