package com.onlineshopping.onlineshopping.controller;

import java.util.List;

public interface CategoryDAO {
	
	List<Category> list();
	
	Category get(int id);  // to fetch a sigle category based on its id. This became our abstract method
	// we need to implement id on CategoryDAOImpl
	

}
