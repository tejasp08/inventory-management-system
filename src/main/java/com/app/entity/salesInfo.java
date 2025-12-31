package com.app.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class salesInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int salesid;
	
	 @Temporal(TemporalType.DATE)
	private LocalDate sale_date;
	
	@ManyToOne
	@JoinColumn(name = "product_code", referencedColumnName = "product_code")
	private products product;
	
	@ManyToOne
	@JoinColumn(name = "customer_code", referencedColumnName = "customer_code")
	private customers customer;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(nullable = false)
	private double revenue;

	
	public int getSalesid() {
		return salesid;
	}

	public void setSalesid(int salesid) {
		this.salesid = salesid;
	}

	public LocalDate getSale_date() {
		return sale_date;
	}

	public void setSale_date(LocalDate sale_date) {
		this.sale_date = sale_date;
	}

	public products getProduct() {
		return product;
	}

	public void setProduct(products product) {
		this.product = product;
	}

	public customers getCustomer() {
		return customer;
	}

	public void setCustomer(customers customer) {
		this.customer = customer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
	}

	
	
	
	
	
}
