package com.app.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.products;

public class ProductService {

	public void addProduct(Session session) {
		Scanner sc = new Scanner(System.in);

        products p = new products();
        
        System.out.print("Enter Product Code: ");
        p.setProduct_code(sc.next());
        //sc.nextLine();

        System.out.print("Enter Product Name: ");
        p.setProduct_name(sc.next());
        //sc.nextLine();

        System.out.print("Enter Brand: ");
        p.setBrand(sc.next());

        System.out.print("Enter Cost Price: ");
        p.setCost_price(sc.nextDouble());

        System.out.print("Enter Selling Price: ");
        p.setSell_price(sc.nextDouble());

        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        System.out.println("Product added successfully!");
	}
	
	//for viewing prods
	public void viewProducts(Session session) {
        List<products> list =
                session.createQuery("from products", products.class).list();

        System.out.println("\n---- PRODUCT LIST ----");
        for (products p : list) {
            System.out.println(p);
        }
    }
	
	//updating
	public void updateProduct (Session session) {
		Scanner sc = new Scanner(System.in);
		Transaction txn = null;
		
		System.out.print("Enter Product Code to update: ");
	    String code = sc.next();
	    sc.nextLine();
		
		try {
			txn = session.beginTransaction();

	        products p = session.get(products.class, code);
	        if (p == null) {
	            System.out.println("Product not found!");
	            return;
	        }
	        
	        System.out.print("New Product Name: ");
	        p.setProduct_name(sc.nextLine());

	        System.out.print("New Brand: ");
	        p.setBrand(sc.nextLine());

	        System.out.print("New Cost Price: ");
	        p.setCost_price(sc.nextDouble());
	        sc.nextLine();

	        System.out.print("New Sell Price: ");
	        p.setSell_price(sc.nextDouble());
	        
//	        p.setProduct_name(name);
//	        p.setBrand(brand);
//	        p.setCost_price(costPrice);
//	        p.setSell_price(sellPrice);

	        session.merge(p);
	        txn.commit();
	        System.out.println("Product updated successfully!");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//delete
	public void deleteProduct(Session session) {
		Scanner sc = new Scanner(System.in);
		
		Transaction txn = null;
	    try {
	        txn = session.beginTransaction();
	        
	        System.out.print("Enter Product Code to delete: ");
	        String code = sc.next();

	        products p = session.get(products.class, code);
	        if (p == null) {
	            System.out.println("Product not found!");
	            return;
	        }

	        session.remove(p);
	        txn.commit();
	        System.out.println("Product deleted successfully!");

	    } catch (Exception e) {
	        //if (txn != null) txn.rollback();
	        System.out.println("Cannot delete product. It may be used in sales or purchases.");
	    }
	}
}
