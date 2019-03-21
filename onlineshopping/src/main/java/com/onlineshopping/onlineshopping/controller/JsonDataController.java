package com.onlineshopping.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// to display the data we need postman for Chrome and RestClient for Muzila fire Fox web store: 
// https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop
@Controller
@Transactional
@RequestMapping("/json/data")
public class JsonDataController {
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@RequestMapping("/all/products")
	@ResponseBody   // this will return the data on Json format
	// the return type will be list of product as ststd below
	
	public List<Products> getAllProducts(){
		
		// we are going to get all the product from the productDAO
		
		return productDAO.listActiveProducts();
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody   // this will return the data on Json format
	// the return type will be list of product as ststd below
	
	public List<Products> getProductByCategory(@PathVariable int id){
		
		// we are going to get all the product from the productDAO
		
		return productDAO.listActiveProductsByCategory(id);
	}

}
