package com.expenses.orderservice.exceptions;

public class OutOfStockException extends RuntimeException{

	
	public OutOfStockException(String message) {
		super(message);
	}
}
