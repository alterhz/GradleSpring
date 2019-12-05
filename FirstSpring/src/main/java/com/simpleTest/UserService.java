package com.simpleTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

	@Autowired
	private OrderService orderService;
	
	public OrderService getOrderService() {
		return orderService;
	}

	public UserService() {
		System.out.println("construct UserService");
	}
}
