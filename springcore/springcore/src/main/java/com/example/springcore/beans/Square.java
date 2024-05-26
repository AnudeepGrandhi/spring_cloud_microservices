package com.example.springcore.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("square")
public class Square {
	
	private int pointA;
	@Value("${pointB.val}")
	private int pointB = 5;
	
	private Rhombus rhombus;
	
	public Square() {
		// TODO Auto-generated constructor stub
		System.out.println("Square Instantiated from Constructor");
	}
	
	public int getPointA() {
		return pointA;
	}

	public void setPointA(int pointA) {
		this.pointA = pointA;
	}

	public int getPointB() {
		return pointB;
	}

	public void setPointB(int pointB) {
		this.pointB = pointB;
	}

	public void drawShape() {
		// TODO Auto-generated method stub
		System.out.println("Square Drawn");
	}

	public Rhombus getRhombus() {
		return rhombus;
	}

	@Autowired
	public void setRhombus(Rhombus rhombus) {
		this.rhombus = rhombus;
	}
	
}
