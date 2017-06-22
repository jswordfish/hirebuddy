package com.hirebuddy.services.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hirebuddy.domain.Categories;
import com.hirebuddy.services.CategoriesService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appContext.xml"})
@Transactional
public class CategoriesServiceTest {
	@Autowired
	CategoriesService  categoriesService;
	
	@Test
	@Rollback(value=false)
	public void testCategories(){
		Categories categories = new Categories();
		categories.setCategory("Physical");
		categoriesService.saveOrUpdate(categories);
	}
	

}
