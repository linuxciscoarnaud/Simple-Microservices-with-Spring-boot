/**
 * 
 */
package com.shop.productservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.shop.productservice.tools.IdGenerator;

/**
 * @author Arnaud
 *
 */

@Entity
public class Category {

	@Id
	@GeneratedValue(generator = IdGenerator.generatorName)
	@GenericGenerator(name = IdGenerator.generatorName, strategy = "com.shop.productservice.tools.IdGenerator")
	@Column(length = 25)
	private String categoryId;
	private String name;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
