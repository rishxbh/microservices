package com.rishabh.orderservice.dto;

import java.util.List;


public class OrderRequest {
	private List<OrderLineItemsDto> orderLineItemsDtoList;

	public OrderRequest(List<OrderLineItemsDto> orderLineItemsDtoList) {
		super();
		this.orderLineItemsDtoList = orderLineItemsDtoList;
	}

	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<OrderLineItemsDto> getOrderLineItemsDtoList() {
		return orderLineItemsDtoList;
	}

	public void setOrderLineItemsDtoList(List<OrderLineItemsDto> orderLineItemsDtoList) {
		this.orderLineItemsDtoList = orderLineItemsDtoList;
	}
	
}
