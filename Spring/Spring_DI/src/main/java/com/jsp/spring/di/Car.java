package com.jsp.spring.di;

public class Car {
	
	private Engine engine;
	
	public Engine getEngine() {
		return engine;
	}
	
	// For Constructor Injection(Dependency Injection)
	
	public Car(Engine engine) {
		super();
		this.engine = engine;
	}
	
	// For Setter Injection(Dependency Injection)

//	public void setEngine(Engine engine) {
//		this.engine = engine;
//	}
}
