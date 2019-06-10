package com.atguigu.bean;

public class Car {

	private String carName;
	private Integer price;
	private String colour;
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	@Override
	public String toString() {
		return "Car [carName=" + carName + ", price=" + price + ", colour=" + colour + "]";
	}
	
	
}
