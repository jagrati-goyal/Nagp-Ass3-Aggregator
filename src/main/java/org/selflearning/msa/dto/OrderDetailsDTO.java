package org.selflearning.msa.dto;

import java.util.List;

public class OrderDetailsDTO {

	private UserDTO userDetails;
	private List<OrderDTO> orders;

	public UserDTO getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDTO userDetails) {
		this.userDetails = userDetails;
	}

	public List<OrderDTO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDTO> orders) {
		this.orders = orders;
	}

}
