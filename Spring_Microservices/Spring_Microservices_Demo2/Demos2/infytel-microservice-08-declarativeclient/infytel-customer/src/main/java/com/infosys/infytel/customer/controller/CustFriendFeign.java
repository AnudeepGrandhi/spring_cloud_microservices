package com.infosys.infytel.customer.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "FriendFamilyMS", url="http://localhost:7300/")
public interface CustFriendFeign {
	
	@RequestMapping("/customers/{phoneNo}/friends")
	List<Long> getSpecificFriends(@PathVariable("phoneNo") Long phoneNo);

}
