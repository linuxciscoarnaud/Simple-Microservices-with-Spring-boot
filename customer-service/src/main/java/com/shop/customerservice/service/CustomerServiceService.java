/**
 * 
 */
package com.shop.customerservice.service;

import com.shop.customerservice.domain.Customer;

/**
 * @author Arnaud
 *
 */


public interface CustomerServiceService {

	Customer getCustomerByCustomerId(String customerId);
}
