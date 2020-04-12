package org.selflearning.msa.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.selflearning.msa.dto.OrderDTO;
import org.selflearning.msa.dto.OrderDetailsDTO;
import org.selflearning.msa.dto.ResultDTO;
import org.selflearning.msa.dto.UserDTO;
import org.selflearning.msa.service.AggregatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AggregatorServiceImpl implements AggregatorService{
	
	private static Logger LOG = LoggerFactory.getLogger(AggregatorServiceImpl.class);
	
	@Resource(name = "restTemp")
	private RestTemplate restTemplate;

	@Override
	public OrderDetailsDTO getOrderDetails(String userId) {
		String userSource = System.getenv().getOrDefault("USER_URL", "http://localhost:8080");
		String orderSource = System.getenv().getOrDefault("ORDER_URL", "http://localhost:8085");
		userSource = userSource + "/user/" + userId;
		orderSource = orderSource + "/orders/" + userId;
		LOG.info("User service url {}", userSource);
		LOG.info("Order service url {}", orderSource);
		UserDTO user = restTemplate.getForObject(userSource, UserDTO.class);
		OrderDetailsDTO result = new OrderDetailsDTO();
		if (null != user) {
			ResultDTO orders = restTemplate.getForObject(orderSource, ResultDTO.class);
			result.setUserDetails(user);
			if (null != orders) {
				result.setOrders(orders.getOrders());
			}
		}
		return result;
	}
}
