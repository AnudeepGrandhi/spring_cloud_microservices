package com.example.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.springcore.beans.Shape;
import com.example.springcore.beans.Square;

@SpringBootApplication
public class SpringcoreApplication implements CommandLineRunner{
	
	@Autowired(required = false)
	@Qualifier("circle")
	Shape circle;
	
	@Autowired(required = false)
	@Qualifier("triangle")
	Shape triangle;
	
	@Autowired(required = false)
	@Qualifier("rectangleOne")
	Shape rectangleOne;
  
	private Square square;

	@Autowired
	public SpringcoreApplication(Square square) {
		super();
		System.out.println("Square is from Constructor");
		square.setPointB(15);
		this.square = square;
	}
	
	@Autowired
	@Qualifier("square")
	public void setSquare(Square square) {
		System.out.println("Square is from Setter");
		square.setPointB(20);
		this.square = square;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringcoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		try {
			circle.drawShape();
		} catch(NullPointerException e) {
			System.out.println("Circle Can't be instantiated");
		}
		
		try {
			triangle.drawShape();
		} catch(NullPointerException e) {
			System.out.println("Triangle Can't be instantiated");
		}
		
		try {
			rectangleOne.drawShape();
		} catch(NullPointerException e) {
			System.out.println("Rectangle Can't be instantiated");
		}
		
		try {
			square.drawShape();
			System.out.println("PointB is " + square.getPointB());
		} catch(NullPointerException e) {
			System.out.println("Square Can't be instantiated");
		}
		
	}

}
