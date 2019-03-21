package com.onlineshopping.onlineshopping.controller;

import java.util.List;

public interface ProductDAO {
	
	Products get(int productID);
	List<Products> list();
	Boolean add(Products product);
	boolean update(Products product);
	boolean delete(Products product);
	
	// business methods
	List <Products> listActiveProducts();
	List <Products> listActiveProductsByCategory(int categoryId);
	List <Products> getLatestActiveProduct(int count);
	

}
