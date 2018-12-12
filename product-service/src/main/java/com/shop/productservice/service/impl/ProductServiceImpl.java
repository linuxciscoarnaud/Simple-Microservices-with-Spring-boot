/**
 * 
 */
package com.shop.productservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.productservice.domain.Category;
import com.shop.productservice.domain.Product;
import com.shop.productservice.repository.ProductRepository;
import com.shop.productservice.service.ProductService;

/**
 * @author Arnaud
 *
 */

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	/* (non-Javadoc)
	 * @see com.shop.productservice.service.ProductService#getProductByProductId(java.lang.String)
	 */
	@Override
	public Product getProductByProductId(String productId) {
		// TODO Auto-generated method stub
		return productRepository.getProductByProductId(productId);
	}

	/* (non-Javadoc)
	 * @see com.shop.productservice.service.ProductService#getAllProducts()
	 */
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.getAllProducts();
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return productRepository.getAllCategories();
	}

}
