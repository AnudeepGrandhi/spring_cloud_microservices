package com.infosys.infytel.customer.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infosys.infytel.customer.dto.CustomerDTO;
import com.infosys.infytel.customer.dto.LoginDTO;
import com.infosys.infytel.customer.dto.PlanDTO;
import com.infosys.infytel.customer.service.CustomerService;

@RestController
public class CustomerController {

	Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	CustomerService custService;
	
	@Autowired
	RestTemplate template;
	
	
	// Create a new customer
	@PostMapping(value = "/customers",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createCustomer(@RequestBody CustomerDTO custDTO) {
		logger.info("Creation request for customer "+ custDTO);
		custService.createCustomer(custDTO);
	}

	// Login
	@PostMapping(value = "/login",consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean login(@RequestBody LoginDTO loginDTO) {
		logger.info("Login request for customer "+loginDTO.getPhoneNo()+" with password "+loginDTO.getPassword());
		return custService.login(loginDTO);
	}

	// Fetches full profile of a specific customer
	@GetMapping(value = "/customers/{phoneNo}",  produces = MediaType.APPLICATION_JSON_VALUE)
	public CustomerDTO getCustomerProfile(@PathVariable Long phoneNo) {
		
		logger.info("Profile request for customer " +phoneNo);
		CustomerDTO custDTO=custService.getCustomerProfile(phoneNo);
		
		PlanDTO planDTO=new RestTemplate().getForObject("http://localhost:9400"+"/plans/"+custDTO.getCurrentPlan().getPlanId(), PlanDTO.class);
		custDTO.setCurrentPlan(planDTO);
		
				
		@SuppressWarnings("unchecked")
		List<Long> friends=template.getForObject("http://FriendFamilyMS/customers/"+phoneNo+"/friends", List.class);		
		custDTO.setFriendAndFamily(friends);
		
		return custDTO;
	}



}
