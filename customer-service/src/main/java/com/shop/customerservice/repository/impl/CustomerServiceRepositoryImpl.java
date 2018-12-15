/**
 * 
 */
package com.shop.customerservice.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.shop.customerservice.domain.Customer;
import com.shop.customerservice.repository.CustomerServiceRepository;

/**
 * @author Arnaud
 *
 */
@Repository
public class CustomerServiceRepositoryImpl implements CustomerServiceRepository {

	@PersistenceContext
	public EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see com.shop.customerservice.repository.CustomerServiceRepository#getCustomerByCustomerId(java.lang.String)
	 */
	@Override
	public Customer getCustomerByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		Customer customer = entityManager.find(Customer.class, customerId);
		return customer ;
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		entityManager.persist(customer);
	}
}
