package com.app.service;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.entity.currentStock;
import com.app.entity.customers;
import com.app.entity.products;
import com.app.entity.salesInfo;

public class SalesService {

	private final SessionFactory sf;

    public SalesService(SessionFactory sf) {
        this.sf = sf;
    }
    
    public void createSale(String customerCode, String productCode, int qty, double revenue) {
    		Transaction txn = null;
    		try {
    			Session session = sf.openSession();
    			txn = session.beginTransaction();
    			
    			customers c = session.get(customers.class, customerCode);
    	        products p = session.get(products.class, productCode);
    	        
    	     // load current stock
         currentStock stock = session.get(currentStock.class, productCode);
         if (stock == null || stock.getQuantity() < qty) {
             throw new RuntimeException("Insufficient stock!");
         }
         
         // creating sale record
         salesInfo sale = new salesInfo();
         sale.setSale_date(LocalDate.now());
         sale.setProduct(p);
         sale.setCustomer(c);
         sale.setQuantity(qty);
         sale.setRevenue(revenue);

         session.persist(sale);
         
         // decrementing stock
         stock.setQuantity(stock.getQuantity() - qty);
         session.merge(stock);

         txn.commit();
         System.out.println("Sale completed & stock updated");

		} catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
		}
    }
}
