package com.hirebuddy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

@Entity
@NamedQueries({
	@NamedQuery(name="Categories.getCategoryByName", 
			query="SELECT u FROM Categories u WHERE u.category=:category")
})
public class Categories extends Base {
	@Transient
	private static final long serialVersionUID = 1L;
	@Column(length=1500, nullable=false)
	String category;
	/**
	 * optional as of now
	 */
	//String description;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
