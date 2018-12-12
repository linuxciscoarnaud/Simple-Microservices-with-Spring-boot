/**
 * 
 */
package com.shop.customerservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shop.customerservice.domain.Customer;
import com.shop.customerservice.domain.DataProduct;
import com.shop.customerservice.service.CustomerServiceService;

/**
 * @author Arnaud
 *
 */

@RestController
@PropertySource({"classpath:application.properties"})
@RequestMapping("consumer")
public class CustomerRestController {

	@Autowired
	private CustomerServiceService customerServiceService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/product/{productId}/customer/{customerId}")
	public DataProduct requestProductInfos(@PathVariable String productId, @PathVariable String customerId) {
		DataProduct response = new DataProduct();
		ResponseEntity<DataProduct> responseEntity;
		
		Customer customer = customerServiceService.getCustomerByCustomerId(customerId);
		
		if (customer != null) {
			Map<String, String> uriVariables = new HashMap<>();
			uriVariables.put("productId", productId);
			
			responseEntity = new RestTemplate().getForEntity(
					"http://localhost:8000/producer/product/{productId}",
					DataProduct.class,
					uriVariables);
			response = responseEntity.getBody();
		}
		
		return new DataProduct(response.getProductId(),
				response.getProductName(),
				response.getDescription(),
				response.getUnitPrice(),
				response.getCategory());
	}
}
