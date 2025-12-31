package com.app;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.service.CustomerService;
import com.app.service.ProductService;
import com.app.service.PurchaseService;
import com.app.service.SalesService;
import com.app.service.StockService;
import com.app.service.SupplierService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Connected to IMS!");
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate-cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		
		//performing a purchase
//		PurchaseService ps = new PurchaseService(sf);
//		ps.createPurchase("S5", "P005", 2, 61998);
		
		//making a sale;
//		SalesService ss = new SalesService(sf);
//		ss.createSale("C1", "P004", 5, 9500);
		
//		PurchaseService ps = new PurchaseService(sf);
//		SalesService ss = new SalesService(sf);
//		ps.createPurchase("S4", "P004", 5, 7500);
//		ss.createSale("C4", "P004", 2, 3800);
		
		//System.out.println("Data added successfully!");
		
		//Viweing prods
//		ProductService ps = new ProductService();
//		ps.viewProducts(session);
//		ps.addProduct(session);
		
		//viweing customers
//		CustomerService cs = new CustomerService();
//		cs.viewCustomers(session);
//		cs.addCustomer(session);
		
		//viewing supp
//		SupplierService ss = new SupplierService();
//		ss.viewSuppliers(session);
//		ss.addSupplier(session);
		
		//viweing stock
//		StockService stk = new StockService();
//		stk.viewStock(session);
		
		ProductService ps = new ProductService();
		SupplierService ss = new SupplierService();
		CustomerService cs = new CustomerService();
		PurchaseService purchase = new PurchaseService(sf);
		SalesService sales = new SalesService(sf);
		StockService stock = new StockService();
		
		boolean exit = false;
		
		while (!exit) {
			System.out.println("\n====== INVENTORY MANAGEMENT SYSTEM ======");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update/Delete Products");
            System.out.println("4. Add Supplier");
            System.out.println("5. View Suppliers");
            System.out.println("6. Update/Delete Supplier");
            System.out.println("7. Add Customer");
            System.out.println("8. View Customers");
            System.out.println("9. Update/Delete Customer");
            System.out.println("10. Purchase Product");
            System.out.println("11. Sell Product");
            System.out.println("12. View Current Stock");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();
            
            try {
				
            		switch (choice) {
					case 1:
						ps.addProduct(session);
						break;
					case 2:
						ps.viewProducts(session);
						break;
					case 3:
						System.out.println("Do you want to update or delete product(U/D): ");
						String udp = sc.next();
						if (udp.equalsIgnoreCase("u")) {
							ps.updateProduct(session);
						} else {
							ps.deleteProduct(session);
						}
						break;
					case 4:
						ss.addSupplier(session);
						break;
					case 5:
						ss.viewSuppliers(session);
						break;
					case 6:
						System.out.println("Do you want to update or delete supplier(U/D): ");
						String uds = sc.next();
						if (uds.equalsIgnoreCase("u")) {
							ss.updateSupplier(session);
						} else {
							ss.deleteSupplier(session);
						}
						break;
					case 7:
						cs.addCustomer(session);
						break;
					case 8:
						cs.viewCustomers(session);
						break;
					case 9:
						System.out.println("Do you want to update or delete customer(U/D): ");
						String udc = sc.next();
						if (udc.equalsIgnoreCase("u")) {
							cs.updateCustomer(session);
						} else {
							cs.deleteCustomer(session);
						}
						break;
					case 10:
						purchase.createPurchase(session);
						break;
					case 11:
						System.out.println("Enter customer code: ");
						String customer_code = sc.next();
						System.out.println("Enter product code: ");
						String prodcode = sc.next();
						System.out.println("Enter quantity: ");
						int quant = sc.nextInt();
						System.out.println("Enter total cost: ");
						double revenue = sc.nextDouble();
						sales.createSale(customer_code, prodcode, quant, revenue);
						break;
					case 12:
						stock.viewStock(session);
						break;
					case 0:
						exit = true;
                        System.out.println("Exiting system...");
						break;
					default:
						System.out.println("Invalid Choice!!!");
						break;
					}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error: " + e.getMessage());
			}
		}
		
		System.out.println("IMS closed successfully");
	}

}
