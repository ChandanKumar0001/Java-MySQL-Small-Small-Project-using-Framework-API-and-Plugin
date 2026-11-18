package com.jsp.spring.ac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App_Scope {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring_ac.xml");
		Mobile mobile = ac.getBean(Mobile.class);
		System.out.println(mobile);

		Mobile mobile2 = ac.getBean(Mobile.class);
		System.out.println(mobile2);
		
		Mobile mobile3 = ac.getBean(Mobile.class);
		System.out.println(mobile3);
	}
}
