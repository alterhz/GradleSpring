package com.simpleTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
	
	@Autowired
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public OrderService() {
		System.out.println("construct OrderService");
	}
}
