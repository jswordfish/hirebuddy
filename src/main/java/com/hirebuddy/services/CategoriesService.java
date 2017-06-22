package com.hirebuddy.services;

import com.hirebuddy.domain.Categories;
import com.hirebuddy.exceptions.HireBuddyException;

public interface CategoriesService extends HireBuddyService{

	public void saveOrUpdate(Categories categories) throws HireBuddyException;
	
	
	public Categories getUniqueCategoryByName(String name) throws HireBuddyException;
}
