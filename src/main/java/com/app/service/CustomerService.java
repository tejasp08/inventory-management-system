package com.app.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.customers;

public class CustomerService {

	public void addCustomer(Session session) {
        Scanner sc = new Scanner(System.in);

        customers c = new customers();

        System.out.print("Enter Customer Code: ");
        c.setCustomer_code(sc.next());
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        c.setFullname(sc.nextLine());

        System.out.println("Enter Customer Location: ");
        c.setLocation(sc.nextLine());
        
        System.out.print("Enter Phone: ");
        c.setMobile(sc.next());

        Transaction tx = session.beginTransaction();
        session.persist(c);
        tx.commit();

        System.out.println("Customer added successfully!");
        
	}
        
    
	public void viewCustomers(Session session) {
            List<customers> list =
                    session.createQuery("from customers", customers.class).list();

            System.out.println("\n---- CUSTOMER LIST ----");
            for (customers c : list) {
                System.out.println(c);
            }
    }
        
    
	public void updateCustomer(Session session) {
		Scanner sc = new Scanner(System.in);		
		Transaction tx = session.beginTransaction();

	    System.out.print("Enter Customer Code: ");
	    String code = sc.next();
	    sc.nextLine();

	    customers c = session.get(customers.class, code);

	    if (c == null) {
	        System.out.println("Customer not found!");
	        tx.rollback();
	        return;
	    }
	    
	    
	    System.out.print("New Customer Name: ");
	    c.setFullname(sc.nextLine());

	    System.out.print("New Mobile no.: ");
	    c.setMobile(sc.nextLine());

	    session.merge(c);
	    tx.commit();

	    System.out.println("Customer updated successfully!");
	}
	
	public void deleteCustomer(Session session) {
		Scanner sc = new Scanner(System.in);		
		Transaction tx = session.beginTransaction();

	    System.out.print("Enter Customer Code: ");
	    String code = sc.next();

	    customers c = session.get(customers.class, code);

	    if (c == null) {
	        System.out.println("Customer not found!");
	        tx.rollback();
	        return;
	    }
	    
	    session.remove(c);
	    tx.commit();

	    System.out.println("Customer deleted successfully!");
	}
}
