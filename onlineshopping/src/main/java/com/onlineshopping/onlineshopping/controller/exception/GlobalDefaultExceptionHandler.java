package com.onlineshopping.onlineshopping.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoHandlerFoundException() {

		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "The page is not constructed");
		mv.addObject("errorDescription", "The page you are looking for is not available now");
		mv.addObject("title", "404 error page");
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleProductNoFoundException() {

		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Product not available");
		mv.addObject("errorDescription", "The product you are looking for is not available right now");
		mv.addObject("title", "Product Unvailable");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException( Exception ex) {

		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Contact your administrator!");
		mv.addObject("errorDescription", ex.toString());
		mv.addObject("title", "Error");
		return mv;
	}
}
