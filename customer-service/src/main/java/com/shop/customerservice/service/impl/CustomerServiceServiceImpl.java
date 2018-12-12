/**
 * 
 */
package com.shop.customerservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.customerservice.domain.Customer;
import com.shop.customerservice.repository.CustomerServiceRepository;
import com.shop.customerservice.service.CustomerServiceService;

/**
 * @author Arnaud
 *
 */

@Service
@Transactional
public class CustomerServiceServiceImpl implements CustomerServiceService {

	@Autowired
	private CustomerServiceRepository customerServiceRepository;
	
	/* (non-Javadoc)
	 * @see com.shop.customerservice.service.CustomerServiceService#getCustomerByCustomerId(java.lang.String)
	 */
	@Override
	public Customer getCustomerByCustomerId(String customerId) {
		// TODO Auto-generated method stub
		return customerServiceRepository.getCustomerByCustomerId(customerId);
	}

}
