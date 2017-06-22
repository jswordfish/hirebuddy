package com.hirebuddy.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hirebuddy.dao.CategoriesDao;
import com.hirebuddy.dao.JPADAO;
import com.hirebuddy.domain.Categories;
import com.hirebuddy.exceptions.HireBuddyException;
import com.hirebuddy.services.CategoriesService;
@Service("categoriesService")
@Transactional(propagation= Propagation.REQUIRED, rollbackFor=HireBuddyException.class)
public class CategoriesServiceImpl extends HireBuddyServiceImpl<Long, Categories> implements CategoriesService{
	@Autowired
    protected CategoriesDao dao;
	
	 

	@PostConstruct
    public void init() throws Exception {
	 super.setDAO((JPADAO) dao);
    }
    
    @PreDestroy
    public void destroy() {
    }
    
    @Override
    public void setEntityManagerOnDao(EntityManager entityManager){
    	dao.setEntityManager(entityManager);
    }
    
    public void saveOrUpdate(Categories categories) throws HireBuddyException{
    	if(categories.getCategory() == null || categories.getCategory().trim().length() == 0){
    		throw new HireBuddyException("No_Data");
    	}
    	
    	if(categories.getId() != null ){
    		if(categories.getId().longValue() != 0){
    			throw new HireBuddyException("Can_Not_Have_Id");
    		}else{
    			categories.setId(null);
    		}
    	}
    	
    	Categories categories2 = getUniqueCategoryByName(categories.getCategory());
    	if(categories2 != null){
    		throw new HireBuddyException("Can_Not_Update_Category");
    	}
    	
    	dao.persist(categories);
    			
    }
    
    public Categories getUniqueCategoryByName(String name) throws HireBuddyException{
    	Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("category", name);
		
		List<Categories> categories = findByNamedQueryAndNamedParams(
				"Categories.getCategoryByName", queryParams);
		if (categories == null) {
			return null;
		} else if (categories != null && categories.size() == 0) {
			return null;
		}
		return categories.get(0);
    }
 
}
