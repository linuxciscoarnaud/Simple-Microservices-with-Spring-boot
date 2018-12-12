/**
 * 
 */
package com.shop.customerservice.domain;

import java.math.BigDecimal;

/**
 * @author Arnaud
 *
 */

public class DataProduct {

	private String productId;
	private String productName;
	private String description;
	private BigDecimal unitPrice;
	private DataCategory category;
	
	public DataProduct() {
		// TODO Auto-generated constructor stub
	}
	
	public DataProduct(String productId, String productName, String description, BigDecimal unitPrice, DataCategory category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.unitPrice = unitPrice;
		this.category = category;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public DataCategory getCategory() {
		return category;
	}

	public void setCategory(DataCategory category) {
		this.category = category;
	}
}
