package com.onlineshopping.onlineshopping.controller.exception;
public class ProductNotFoundException  extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private String massage;
	
	public ProductNotFoundException() {
		
		this("Product not available");
	}
	
public ProductNotFoundException(String message) {
		
		message = System.currentTimeMillis() + ": " + message;
	}

public String getMassage() {
	return massage;
}



}
