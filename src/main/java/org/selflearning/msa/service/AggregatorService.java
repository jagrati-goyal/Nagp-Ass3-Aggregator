package org.selflearning.msa.service;

import org.selflearning.msa.dto.OrderDetailsDTO;

public interface AggregatorService {

	public OrderDetailsDTO getOrderDetails(String userId);
}
