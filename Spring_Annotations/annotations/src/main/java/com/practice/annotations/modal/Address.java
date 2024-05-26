package com.practice.annotations.modal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {

	@Autowired(required = true)
	@Value(value = "\"3-253/1\"")
	private String doorNumber;
	private String city = "Rajamundry";
	private String district;
	private int pinCode;
	
	public String getDoorNumber() {
		return doorNumber;
	}
	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		System.out.println("City Intialized");
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		System.out.println("District Intialized");
		this.district = district;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
	@Override
	public String toString() {
		return "Address [doorNumber=" + doorNumber + ", city=" + city + ", district=" + district + ", pinCode="
				+ pinCode + "]";
	}
	
}
