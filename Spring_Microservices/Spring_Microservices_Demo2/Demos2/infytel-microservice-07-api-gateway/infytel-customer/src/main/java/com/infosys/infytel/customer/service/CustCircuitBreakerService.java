package com.infosys.infytel.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infosys.infytel.customer.dto.PlanDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CustCircuitBreakerService {

	@Autowired
	RestTemplate template;
	
	@CircuitBreaker(name = "customerService")
	public PlanDTO getSpecificPlan(Integer planId){
		return template.getForObject("http://PlanMS"+"/plans/"+planId, PlanDTO.class);
	}

	
	@SuppressWarnings("unchecked")
	@CircuitBreaker(name = "customerService", fallbackmethod="myfallback")
	public List<Long> getSpecificFriends(Long phoneNo){
		return template.getForObject("http://FriendFamilyMS/customers/"+phoneNo+"/friends", List.class);
	}
	
	public List myfallback(Long phoneNo)
	{
		System.out.println("in fallback");
	}
	
	}
}
