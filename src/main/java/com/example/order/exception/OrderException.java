package com.example.order.exception;

import org.springframework.util.Assert;

public class OrderException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderException(String message) {
		super(message);		
	}
	
	public static OrderException  checkInfo(Boolean status) throws OrderException  {
		if (!status) {
			throw new OrderException("Validation failed");
		}
		return null;
	}

}
