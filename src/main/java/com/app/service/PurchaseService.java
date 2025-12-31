package com.app.service;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.app.entity.currentStock;
import com.app.entity.products;
import com.app.entity.purchaseInfo;
import com.app.entity.suppliers;

public class PurchaseService {

	 private final SessionFactory sf;

	    public PurchaseService(SessionFactory sf) {
	        this.sf = sf;
	    }
	    
	    public void createPurchase(Session session) {
	    
	    	Scanner sc = new Scanner(System.in);
	    	Transaction txn = null;
	    	
	    	try {
	    		//Session session = sf.openSession();
	    		txn = session.beginTransaction();
	    		
	    		System.out.println("Enter supplier code: ");
			String supp_code = sc.next();
			System.out.println("Enter product code: ");
			String prod_code = sc.next();
			System.out.println("Enter quantity: ");
			int quantity = sc.nextInt();
			System.out.println("Enter total cost: ");
			double totalcost = sc.nextDouble();
	    		
	    		suppliers s = session.get(suppliers.class, supp_code);
	        products p = session.get(products.class, prod_code);
	        
	        // creating purchase record
            purchaseInfo pi = new purchaseInfo();
            pi.setPurchase_date(LocalDate.now());
            pi.setSupplier(s);
            pi.setProduct(p);
            pi.setQuantity(quantity);
            pi.setTotalcost(totalcost);

            session.persist(pi);

            // updating current stock
            currentStock stock = session.get(currentStock.class, prod_code);
            if (stock == null) {
                stock = new currentStock();
                stock.setProduct(p);
                stock.setQuantity(quantity);
                session.persist(stock);
            } else {
                stock.setQuantity(stock.getQuantity() + quantity);
                session.merge(stock);
            }

            txn.commit();
            System.out.println("Purchase added & stock updated");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	    }
	    
}
