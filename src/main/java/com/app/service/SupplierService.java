package com.app.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.suppliers;

public class SupplierService {

	public void addSupplier(Session session) {
        Scanner sc = new Scanner(System.in);

        suppliers s = new suppliers();

        System.out.print("Enter Supplier Name: ");
        s.setFullname(sc.nextLine());
        
        System.out.print("Enter Supplier Code: ");
        s.setSupplier_code(sc.next());
        sc.nextLine();
        
        System.out.println("Enter Customer Location: ");
        s.setLocation(sc.nextLine());
        
        System.out.print("Enter Phone: ");
        s.setMobile(sc.next());

        Transaction tx = session.beginTransaction();
        session.persist(s);
        tx.commit();

        System.out.println("Supplier added successfully!");
    }
	
	//viewing
	public void viewSuppliers(Session session) {
        List<suppliers> list =
                session.createQuery("from suppliers", suppliers.class).list();

        System.out.println("\n---- SUPPLIER LIST ----");
        for (suppliers s : list) {
            System.out.println(s);
        }
    }
	
	public void updateSupplier(Session session) {
		Scanner sc = new Scanner(System.in);
		
		Transaction tx = session.beginTransaction();

	    System.out.print("Enter Supplier Code: ");
	    String code = sc.next();

	    suppliers s = session.get(suppliers.class, code);

	    if (s == null) {
	        System.out.println("Supplier not found!");
	        tx.rollback();
	        return;
	    }

	    sc.nextLine();
	    
	    System.out.print("New Supplier Name: ");
	    String name = sc.nextLine();
	    s.setFullname(name);

	    System.out.print("New Mobile no.: ");
	    s.setMobile(sc.nextLine());

	    session.merge(s);
	    tx.commit();

	    System.out.println("Supplier updated successfully!");
	}
	
	
	public void deleteSupplier(Session session) {
		Scanner sc = new Scanner(System.in);
		
		Transaction tx = session.beginTransaction();

	    System.out.print("Enter Supplier Code: ");
	    String code = sc.next();

	    suppliers s = session.get(suppliers.class, code);

	    if (s == null) {
	        System.out.println("Supplier not found!");
	        tx.rollback();
	        return;
	    }

	    session.remove(s);
	    tx.commit();

	    System.out.println("Supplier deleted successfully!");
	}
}
