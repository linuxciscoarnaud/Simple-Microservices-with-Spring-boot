/**
 * 
 */
package com.shop.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.productservice.domain.Category;
import com.shop.productservice.domain.Product;
import com.shop.productservice.service.ProductService;

/**
 * @author Arnaud
 *
 */

@RestController
@RequestMapping("producer")
public class ProductRestController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/product/{productId}")
	public Product getProductByProductId(@PathVariable("productId") String productId) {
		return productService.getProductByProductId(productId);
	}
	
	@GetMapping("/product/products")
	List<Product> getAllArticles() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/category/categories")
	List<Category> getAllCategories() {
		return productService.getAllCategories();
	}
}
