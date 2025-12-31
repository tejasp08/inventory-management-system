package com.app.entity;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchaseinfo")
public class purchaseInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int purchaseid;
	
	@Column(nullable = false)
	private LocalDate purchase_date;

	@ManyToOne
	@JoinColumn(name = "supplier_code", referencedColumnName = "supplier_code")
	private suppliers supplier;
	
	@ManyToOne
	@JoinColumn(name = "product_code", referencedColumnName = "product_code")
	private products product;
	
	@Column(nullable = false)
	private int quantity;
	@Column(nullable = false)
	private double totalcost;
	
	
	public int getPurchaseid() {
		return purchaseid;
	}
	public void setPurchaseid(int purchaseid) {
		this.purchaseid = purchaseid;
	}
	public LocalDate getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(LocalDate purchase_date) {
		this.purchase_date = purchase_date;
	}
	public suppliers getSupplier() {
		return supplier;
	}
	public void setSupplier(suppliers supplier) {
		this.supplier = supplier;
	}
	public products getProduct() {
		return product;
	}
	public void setProduct(products product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}
	
	
}
