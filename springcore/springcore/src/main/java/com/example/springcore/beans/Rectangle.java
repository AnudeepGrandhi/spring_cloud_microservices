package com.example.springcore.beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//@Profile("test")
@Component("rectangleOne")
public class Rectangle implements Shape {

	public Rectangle() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Rectangle Instantiated");
	}

	@Override
	public void drawShape() {
		// TODO Auto-generated method stub
		System.out.println("Rectangle Drawn");
	}

}
