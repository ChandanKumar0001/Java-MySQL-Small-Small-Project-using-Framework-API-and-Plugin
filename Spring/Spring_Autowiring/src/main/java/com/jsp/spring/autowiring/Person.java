package com.jsp.spring.autowiring;

public class Person {

private Address address;
	
	public Address getAddress() {
		return address;
	}
	
	//DI(Setter) - Object Creation for Person in case of Setter Injection
//	
//	public Person() {
//		
//	}
	
	//used for autowiring-byName and by-Type only comment below set method for Constructor Injection
	// DI(Setter) - For Injection of the Address object into the Person
	
//	public void setAddress(Address address) {
//		this.address = address;
//	}
	
	//DI(Constructor) :- 
	//Object creating for Person as well as injection of the Address
	//object into the Person
	
	public Person(Address address) {
		super();
		this.address = address;
	}
	
}
