package com.example.springcore.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Rhombus {

	private Square square;

	public Rhombus() {
		// TODO Auto-generated constructor stub
	}

	public Square getSquare() {
		return square;
	}

	@Autowired
	public void setSquare(Square square) {
		this.square = square;
	}
	
	
	
}
