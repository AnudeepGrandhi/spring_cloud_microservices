package com.example.springcore.beans;

import org.springframework.stereotype.Component;

public class Triangle implements Shape {
	
	public Triangle() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Triangle Instantiated");
	}

	public void drawShape() {
		// TODO Auto-generated method stub
		System.out.println("Triangle Drawn");
	}

}
