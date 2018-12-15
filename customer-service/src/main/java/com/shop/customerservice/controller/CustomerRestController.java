/**
 * 
 */
package com.shop.customerservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shop.customerservice.domain.Customer;
import com.shop.customerservice.domain.DataCategory;
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
	
	// All Get
	
	@GetMapping("/product/{productId}/customer/{customerId}")
	public DataProduct requestProductByProductId(@PathVariable String productId, 
			@PathVariable String customerId) {
		
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
				response.getName(),
				response.getDescription(),
				response.getUnitPrice(),
				response.getCategory());
	}
	
	@GetMapping("/product/products/customer/{customerId}")
	public List<DataProduct> requestAllProducts(@PathVariable String customerId) {
		ResponseEntity<List<DataProduct>> responseEnties = null;
		List<DataProduct> response;
		
		Customer customer = customerServiceService.getCustomerByCustomerId(customerId);
		
		if (customer != null) {
			responseEnties = new RestTemplate().exchange(
					"http://localhost:8000/producer/product/products",
					HttpMethod.GET,
					null,
					new ParameterizedTypeReference<List<DataProduct>>(){});
		}
		response = responseEnties.getBody();	
		return response;
	}
	
	// All Post
	
	@PostMapping("/add/customer/{customerId}")
	public void requestAddProduct(@RequestBody DataProduct daProduct, 
			@PathVariable String customerId) {
		
		Customer customer = customerServiceService.getCustomerByCustomerId(customerId);
		if (customer != null) {		
			 new RestTemplate().postForEntity(
					"http://localhost:8000/producer/add",
					daProduct,
					DataProduct.class);
		}
	}
	
	@PostMapping("/add") 
	public void addCustomer(@RequestBody Customer customer) {
		customerServiceService.addCustomer(customer);
	}
	
	
	// All Put
	
	@PutMapping("/update/product/{productId}/customer/{customerId}")
	public void requestUpdateProduct(@PathVariable("productId") String productId, 
			@PathVariable("customerId") String customerId, 
			@RequestBody DataProduct daProduct) {

		Customer customer = customerServiceService.getCustomerByCustomerId(customerId);
		if (customer != null) {	
			Map<String, String> uriVariables = new HashMap<>();
			uriVariables.put("productId", productId);
			
			new RestTemplate().put(
					"http://localhost:8000/producer/product/{productId}", 
					daProduct, 
					uriVariables);
		}
	}
	
	@PutMapping("/update/product/category/{categoryId}/customer/{customerId}")
	public void requestUpdateCategory(@PathVariable("categoryId") String categoryId, 
			@PathVariable("customerId") String customerId, 
			@RequestBody DataCategory dataCategory) {
		
		Customer customer = customerServiceService.getCustomerByCustomerId(customerId);
		if (customer != null) {	
			Map<String, String> uriVariables = new HashMap<>();
			uriVariables.put("categoryId", categoryId);
			
			new RestTemplate().put(
					"http://localhost:8000/producer/product/category/{categoryId}", 
					dataCategory, 
					uriVariables);
		}
	}
	
}
