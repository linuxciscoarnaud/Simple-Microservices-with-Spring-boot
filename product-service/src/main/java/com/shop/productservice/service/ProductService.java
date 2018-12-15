/**
 * 
 */
package com.shop.productservice.service;

import java.util.List;

import com.shop.productservice.domain.Category;
import com.shop.productservice.domain.Product;

/**
 * @author Arnaud
 *
 */

public interface ProductService {

	Product getProductByProductId(String productId);
	List<Product> getAllProducts();
	List<Category> getAllCategories();
	Category getCategory(String categoryId);
	void addProduct(Product product);
	void addCategory(Category category);
	void updateProduct(String productId, Product product);
	void updateCategory(String categoryId, Category category);
}
