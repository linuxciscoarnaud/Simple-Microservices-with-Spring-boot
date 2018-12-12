/**
 * 
 */
package com.shop.productservice.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.productservice.domain.Category;
import com.shop.productservice.domain.Product;
import com.shop.productservice.repository.ProductRepository;

/**
 * @author Arnaud
 *
 */

@Transactional
@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@PersistenceContext	
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.shop.productservice.repository.ProductRepository#getProductByProductId(java.lang.String)
	 */
	@Override
	public Product getProductByProductId(String productId) {
		// TODO Auto-generated method stub
		Product product = entityManager.find(Product.class, productId);
		return product;
	}

	/* (non-Javadoc)
	 * @see com.shop.productservice.repository.ProductRepository#getAllProducts()
	 */
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		Query req = entityManager.createQuery("from Product pr");
		return req.getResultList();
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		Query req = entityManager.createQuery("from Category ct");
		return req.getResultList();
	}
}
