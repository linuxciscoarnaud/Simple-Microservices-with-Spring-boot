/**
 * 
 */
package com.shop.productservice.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.shop.productservice.tools.IdGenerator;

/**
 * @author Arnaud
 *
 */

@Entity
public class Product {

	@Id
	@GeneratedValue(generator = IdGenerator.generatorName)
	@GenericGenerator(name = IdGenerator.generatorName, strategy = "com.shop.productservice.tools.IdGenerator")
	@Column(length = 25)
	private String productId;
	private String name;
	private BigDecimal unitPrice;
	private String description;
	private Long unitsInStock;
	@ManyToOne
	@JoinColumn (name = "CATEGORY_CODE")
	private Category category;
	
	public Product() {
		super();
    }

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(Long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
}
