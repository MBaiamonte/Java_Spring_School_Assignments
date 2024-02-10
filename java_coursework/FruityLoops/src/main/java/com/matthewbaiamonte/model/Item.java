package com.matthewbaiamonte.model;

public class Item {
	private String name;
	private Double price;
	public Item(String itemName, Double itemPrice) {
		this.name=itemName;
		this.price=itemPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
}


