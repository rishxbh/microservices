package com.rishabh.orderservice.service;

import com.rishabh.orderservice.dto.OrderRequest;

public interface OrderService {
	void placeOrder(OrderRequest orderRequest);
}
