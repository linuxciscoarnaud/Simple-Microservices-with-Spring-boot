/**
 * 
 */
package com.shop.customerservice.repository;

import com.shop.customerservice.domain.Customer;

/**
 * @author Arnaud
 *
 */


public interface CustomerServiceRepository {

	Customer getCustomerByCustomerId(String customerId);
	void addCustomer(Customer customer);
}
