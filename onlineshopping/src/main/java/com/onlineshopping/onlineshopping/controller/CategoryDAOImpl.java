package com.onlineshopping.onlineshopping.controller;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository("categoryDAO") // same object name as given in the pageController (private CategoryDAO
							// categoryDAO;)
public class CategoryDAOImpl implements CategoryDAO {

	// 1. this is added after creating database and public boolean add(Category
	// category) { -- on bottom

	@Autowired
	private SessionFactory sessionFactory;
	// fim 1//

	// private static List<Category> categories = new ArrayList<>();

//	static {
//		
//		Category category = new Category();
//		category.setId(1);
//		category.setName("Television");
//		category.setDescription("Description for television");
//		category.setImageURL("CAT_1.png");
//		category.setActive(true);
//		
//		categories.add(category);
//		
//		category = new Category();
//		category.setId(2);
//		category.setName("Mobile");
//		category.setDescription("Description for Mobile");
//		category.setImageURL("CAT_2.png");
//		category.setActive(true);
//		
//		categories.add(category);
//		
//		category = new Category();
//		category.setId(3);
//		category.setName("Laptop");
//		category.setDescription("Description for Laptop");
//		category.setImageURL("CAT_3.png");
//		category.setActive(true);
//		
//		categories.add(category);
//		
//	}

	@Override
	public List<Category> list() {   // return the list of category
		
		String selectActiveCategory = "FROM Category WHERE active =:active";
		Query query  = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();

		
	}

	// getting a single category based on id
	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id)); // if there is not category
																							// for and id itwill return
																							// null
	}

	@Override

	public boolean add(Category category) {

		try {

			// add the category to the database
			sessionFactory.getCurrentSession().persist(category);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	
	// method for updating a single category
	@Override
	public boolean update(Category category) {
		try {

			// add the category to the database
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean delete(Category category) {
		try {
			
			category.setActive(false);

			// add the category to the database
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
