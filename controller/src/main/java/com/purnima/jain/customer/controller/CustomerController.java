package com.purnima.jain.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.purnima.jain.customer.domain.aggregate.Customer;
import com.purnima.jain.customer.domain.service.CustomerService;

@RestController
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Value("${siteName}")
	private String siteName;

	@Autowired
	private CustomerService customerService;

	/**
	 * use this URL to test
	 * http://localhost:8080/controller_war_exploded/customer/1
	 *
	 * @param customerId
	 * @return
	 */
	@GetMapping("customer/{customerId}")
	public Customer getCustomer(@PathVariable Integer customerId) {
		logger.info("Inside CustomerController........ siteName " + siteName);
		return customerService.getCustomerById(customerId);
	}

}
