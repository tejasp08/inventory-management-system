package com.app.service;

import java.util.List;

import org.hibernate.Session;

import com.app.entity.currentStock;

public class StockService {

	public void viewStock(Session session) {
		
		session.clear();
		
        List<currentStock> list =
                session.createQuery("from currentStock", currentStock.class).list();

        System.out.println("\n---- CURRENT STOCK ----");
        for (currentStock s : list) {
            System.out.println(
                "Product: " + s.getProduct().getProduct_name() + ", Product_Code: " + s.getProduct().getProduct_code() 
                + ", Qty: " + s.getQuantity()
            );
        }
    }
}
