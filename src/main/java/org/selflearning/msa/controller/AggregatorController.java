package org.selflearning.msa.controller;

import org.selflearning.msa.dto.OrderDetailsDTO;
import org.selflearning.msa.service.AggregatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AggregatorController {

	@Autowired
	private AggregatorService aggregatorService;
	
	@GetMapping(value = "/orderDetails/{userId}")
	@ResponseBody
	public OrderDetailsDTO getOrderDetails(@PathVariable String userId) {
		return aggregatorService.getOrderDetails(userId);
	}
}
