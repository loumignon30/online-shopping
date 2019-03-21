package com.onlineshopping.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.onlineshopping.onlineshopping.controller.exception.ProductNotFoundException;

@Controller

public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private CategoryDAO categoryDAO; // adding category from onlineshoppingbackend -- dependency injection
	
	@Autowired
	private ProductDAO productDAO;
	// autowired = spring will manage obects for us

	@RequestMapping(value = { "/", "/home", "/index", })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		logger.info("Inside pageController index method - INFO");
		logger.debug("Inside pageController index method - DEBUG");

		// passing list of categories
		mv.addObject("categories", categoryDAO.list());

		// end passing
		mv.addObject("userClickHome", true);

		return mv;

	}

//	
	@RequestMapping(value = { "/about" })
	public ModelAndView about() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About us");
		mv.addObject("userClickAbout", true);

		return mv;
	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact us");
		mv.addObject("userClickContact", true);

		return mv;
	}

	/*
	 * method to load all the products and based on catgory see sidebar.jsp and
	 * navbar.jsp
	 */

	@RequestMapping(value = "/show_all_products")
	public ModelAndView showAllProducts() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All products");
		// passing list of categories
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true); // see listProduct.jsp for testing. we made a test for user

		return mv;
	}

	@RequestMapping(value = "/showcategory_{id}_products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		/* categoryDAO to fetch a sigle category */
		Category category = null;
		category = categoryDAO.get(id);
		
		mv.addObject("title", category.getName()); // name of category to display
		// passing list of categories 
		mv.addObject("categories", categoryDAO.list());

		// passing a single category object
		mv.addObject("category", category);

		mv.addObject("userClickCategoryProducts", true); // see listProduct.jsp for testing. we made a test for user

		return mv;
	}
	
	
	/* 
	 * Viewing a singleproduct
	 * 1. need need to add the resquest mapping
	 **/
	
	@RequestMapping(value = "/show_{id}_product")
	public ModelAndView showingSingleProduct(@PathVariable int id) throws ProductNotFoundException { //ProductNotFoundException= voir dans la class ProductNoFound 
		ModelAndView mv = new ModelAndView("page");
		
		Products product = productDAO.get(id);	
		
		// test if product if available  
			if(product == null) throw new ProductNotFoundException();
		// end test product available
		
		// update the view count
	    product.setViews(product.getViews() + 1);   // we are changin the view 
		productDAO.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct", true); // see listProduct.jsp for testing. we made a test for user
		
		return mv;
	}
	
}
