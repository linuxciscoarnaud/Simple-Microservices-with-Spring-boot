/**
 * 
 */
package com.shop.productservice.repository;

import java.util.List;

import com.shop.productservice.domain.Category;
import com.shop.productservice.domain.Product;

/**
 * @author Arnaud
 *
 */

public interface ProductRepository {

	Product getProductByProductId(String productId);
	List<Product> getAllProducts();
	List<Category> getAllCategories();
}
