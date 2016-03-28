package com.spring.ex.vo;

import com.spring.ex.common.BaseObject;

public class ProductVO extends BaseObject {
	private static final long serialVersionUID = -1550133109731872322L;
	
	private String name;
	private double price;
	
	public ProductVO(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
