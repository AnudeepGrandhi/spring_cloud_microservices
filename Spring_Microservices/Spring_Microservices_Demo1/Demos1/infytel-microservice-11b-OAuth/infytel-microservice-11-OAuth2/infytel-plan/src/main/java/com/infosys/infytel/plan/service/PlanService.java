package com.infosys.infytel.plan.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.infytel.plan.dto.PlanDTO;
import com.infosys.infytel.plan.entity.Plan;
import com.infosys.infytel.plan.repository.PlanRepository;

@Service
public class PlanService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PlanRepository planRepo;

	// Fetches all plan details
	public List<PlanDTO> getAllPlans() {

		List<Plan> plans = planRepo.findAll();
		List<PlanDTO> planDTOs = new ArrayList<PlanDTO>();

		for (Plan plan : plans) {
			PlanDTO planDTO = PlanDTO.valueOf(plan);
			planDTOs.add(planDTO);
		}

		logger.info("Plan details : {}", planDTOs);
		return planDTOs;
	}

	// Fetch specific plan details
	public PlanDTO getSpecificPlan(int planId) {
		logger.info("Plan details : {}", planId);
		return PlanDTO.valueOf(planRepo.findOne(planId));
	}

}
