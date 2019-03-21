package com.onlineshopping.onlineshopping.controller;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//all these code will be managed by 
//Spring framework, why we are using @Repository and @Transactional 
@Repository("productDAO") 
@Transactional
public class ProducDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	// SINGLE ID
	@Override
	public Products get(int productID) {

			return sessionFactory.getCurrentSession().get(Products.class, Integer.valueOf(productID));
		
	}

	// list of products
	@Override
	public List<Products> list() {

		return sessionFactory.getCurrentSession().createQuery("FROM Products", Products.class).getResultList();

	}

	
	// add product
	@Override
	public Boolean add(Products product) {

		try {
			 sessionFactory.getCurrentSession().persist(product);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return false;
	}

	
	// update product
	@Override
	public boolean update(Products product) {
		try {
			 sessionFactory.getCurrentSession().update(product);
			return true;

		} catch (Exception ex) {
			 ex.printStackTrace() ;
		}

		return false;
	}

	
	// delete product
	@Override
	public boolean delete(Products product) {
		try {
			
			product.setActive(false);
			// call the update method
			return this.update(product);
			

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Products>  listActiveProducts() {
		
		String selectActiveProducts = "FROM Products WHERE active =:active";
		return sessionFactory
				.getCurrentSession()
				.createQuery(selectActiveProducts, Products.class)
				.setParameter("active", true)
				.getResultList();
	}

	@Override
	public List<Products>  listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Products WHERE active =:active AND categoryId = :categoryId";
		return sessionFactory
				.getCurrentSession()
				.createQuery(selectActiveProductsByCategory, Products.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId)
				.getResultList();
	}

	@Override
	public List<Products>  getLatestActiveProduct(int count) {
		String selectActiveProductsByCategory = "FROM Products WHERE active =:active ORDER BY id ";
		return sessionFactory
				.getCurrentSession()
				.createQuery(selectActiveProductsByCategory, Products.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}
