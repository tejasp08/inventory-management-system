package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class products {
	
	@Id
	@Column(name = "product_code")
	private String product_code;
	
	private String product_name;
	private String brand;
	private double cost_price;
	private double sell_price;
	
	
	
	public String getProduct_code() {
		return product_code;
	}


	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getCost_price() {
		return cost_price;
	}

	public void setCost_price(double cost_price) {
		this.cost_price = cost_price;
	}

	public double getSell_price() {
		return sell_price;
	}

	public void setSell_price(double sell_price) {
		this.sell_price = sell_price;
	}



	@Override
	public String toString() {
		return "product_code: " + product_code + ", product_name: " + product_name + ", brand: " + brand
				+ ", cost_price: " + cost_price + ", sell_price: " + sell_price;
	}

}
