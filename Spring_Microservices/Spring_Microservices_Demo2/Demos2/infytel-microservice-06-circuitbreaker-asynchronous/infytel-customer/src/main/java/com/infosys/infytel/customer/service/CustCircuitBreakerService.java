package com.infosys.infytel.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infosys.infytel.customer.dto.PlanDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.vavr.concurrent.Future;

@Service
public class CustCircuitBreakerService {

	@Autowired
	RestTemplate template;
	
	@CircuitBreaker(name = "customerService")
	public Future<PlanDTO> getSpecificPlan(Integer planId){
		return Future.of(() -> template.getForObject("http://PlanMS"+"/plans/"+planId, PlanDTO.class));
	}

	
	@SuppressWarnings("unchecked")
	@CircuitBreaker(name = "customerService")
	public Future<List<Long>> getSpecificFriends(Long phoneNo){
		return Future.of(() -> template.getForObject("http://FriendFamilyMS/customers/"+phoneNo+"/friends", List.class));
	}
}
