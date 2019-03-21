package com.onlineshopping.onlineshopping.controller.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlineshopping.onlineshopping.controller.Category;
import com.onlineshopping.onlineshopping.controller.CategoryDAO;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext contex;
	private static CategoryDAO categoryDAO;
	private static Category category;
	
	@BeforeClass
	public static void init() {
		
		contex = new AnnotationConfigApplicationContext();
		contex.scan("com.onlineshopping.onlineshopping.controller");
		contex.refresh();
		
		categoryDAO = (CategoryDAO)contex.getBean("categoryDAO");
		
	}
	
	
//	@Test
//	public void testAddCategory() {
//		
//	    category = new Category();
//		category.setName("House");
//		category.setDescription("Description of House of Birre");
//		category.setImageURL("CAT_4.png");
//		category.setActive(true);
//		
//		assertEquals("Successfully added a category inside the table!", true, categoryDAO.add(category));
//	}
	
//	@Test
//	public void testgetCategory() {
//		
//	    category =  categoryDAO.get(3);
//		
//		assertEquals("Successfully fetched a single category inside the table!", "House", category.getName());
//	}
	
	@Test
	public void testUpateCategory() {
		
	    category =  categoryDAO.get(3);
	    category.setName("Maison");
		
		assertEquals("Successfully updated a single category inside the table!", true, categoryDAO.update(category));
	}
	
//	@Test
//	public void testDeleteCategory() {
//		
//	    category =  categoryDAO.get(3);
//	    
//		
//		assertEquals("Successfully delete = setActive = false a single category inside the table!", true, categoryDAO.delete(category));
//	}
	
//	@Test
//	public void testListCategory() {
//		
//		assertEquals("Successfully fetch the list of category inside the table!", 2, categoryDAO.list().size());
//	}
	
	

}
