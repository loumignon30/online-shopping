package com.onlineshopping.onlineshopping.controller;

import java.util.List;

public interface CategoryDAO {
	
	
	Category get(int id);  // to fetch a sigle category based on its id. This became our abstract method
	// we need to implement id on CategoryDAOImpl
	List<Category> list(); // List all categories
	boolean add(Category category); // added after creating hibernate and putting all the entities
	
	// we are adding a method to update and delete a category
	boolean update(Category category);
	boolean delete(Category category);   // attention -> these methods will be imolemented in CategoryDAOImpl
	
	
	
	
	

}
