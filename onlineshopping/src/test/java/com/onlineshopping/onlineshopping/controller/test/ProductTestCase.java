package com.onlineshopping.onlineshopping.controller.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlineshopping.onlineshopping.controller.Products;
import com.onlineshopping.onlineshopping.controller.ProductDAO;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext contex;
	private static ProductDAO productDAO;
	private static Products product;
	
	@BeforeClass
	public static void init() {
		
		contex = new AnnotationConfigApplicationContext();
		contex.scan("com.onlineshopping.onlineshopping.controller");
		contex.refresh();
		
		productDAO = (ProductDAO)contex.getBean("productDAO");
		
	}
	
	/*
	
	@Test
	public void testAddProduct() {		
	
		product = new Products();
		product.setName("Nokia 3067");
		product.setBrand("Nokia");
		product.setDescription("This is some description for Nokia 3067Telephone");
		product.setUnit_price(450);
		product.setQuantity(60);
		product.setActive(true);
		product.setCategoryId(4);
		product.setSupplierId(3);
		product.setViews(1);
		
		assertEquals("Error while adding Product inside the table!", true, productDAO.add(product));
	}
	
	*/
	
//	@Test
//	public void testgetCategory() {
//		
//	    category =  categoryDAO.get(3);
//		
//		assertEquals("Error fetched a single category inside the table!", "House", category.getName());
//	}
	
//	@Test
//	public void testUpateCategory() {
//		
//	    category =  categoryDAO.get(3);
//	    category.setName("Maison");
//		
//		assertEquals("Error updated a single category inside the table!", true, categoryDAO.update(category));
//	}
	
//	@Test
//	public void testDeleteProduct() {
//		
//	    product =  productDAO.geti(4);
//	    
//		
//		assertEquals("Error delete = setActive = false a single category inside the table!", true, productDAO.delete(product));
//	}
	
//	@Test
//	public void testListProducts() {
//		
//		assertEquals("Error fetch the list of products inside the table!", 4, productDAO.list().size());
//	}
	
// @Test
	//public void testListProductsActiveProducts() {
		
	//	assertEquals("Error fetch the list of active products inside the table!", 3, productDAO.listActiveProducts().size());
//	}
	
	//@Test
//	public void testListProductsActiveProductsByCategory() {
//		
//		assertEquals("Error fetch the list of active products by category inside the table!", 3, productDAO.listActiveProductsByCategory(1).size());
//	}
//	
//	@Test
//	public void testListProductsActiveLastesProduct() {
//		
//		assertEquals("Error fetch the list of lastest active products by category inside the table!", 3, productDAO.getLatestActiveProduct(3).size());
//	}
	
	
	
	@Test
	public void testgetProduct() {
		product =  productDAO.get(5);
		
		assertEquals("Error fetched a single product inside the table!", "IPhone 10 Max",  product.getName());
	}

}

