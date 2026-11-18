package com.jsp.spring.annotations.tiger;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Tiger {
	
	public void sound() {
		System.out.println("Roar");
	}
}
