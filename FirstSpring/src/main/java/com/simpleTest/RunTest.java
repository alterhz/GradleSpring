package com.simpleTest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RunTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);

		UserService userService = context.getBean(UserService.class);
		
		OrderService orderService = context.getBean(OrderService.class);
		
		context.close();
	}
}
