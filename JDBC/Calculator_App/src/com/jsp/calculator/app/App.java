package com.jsp.calculator.app;

import com.jsp.calculator.logic.Calculator;

public class App {
	public static void main(String[] args) {
		Calculator c= new Calculator();
		System.out.println(c.add(5, 6));
		System.out.println(c.sub(8, 4));
		System.out.println(c.mul(8, 2));
		System.out.println(c.div(42, 2));
		System.out.println(c.mod(100, 2));
	}
}
