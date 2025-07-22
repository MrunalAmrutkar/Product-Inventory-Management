package com.Practice;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.Practice.Entity.Product;
import com.Practice.Utility.HibernateUtility;

public class UserFunctionality {

	SessionFactory factory = HibernateUtility.getSessionFactory();
	Session session = factory.openSession();
	Transaction transaction = session.beginTransaction();
	Scanner sc = new Scanner(System.in);
	int product = sc.nextInt();
	
	public void Addproduct() {
		System.out.println("Enter Id :");
		int a1 = sc.nextInt();
		System.out.println("Enter name :");
		String a2 = sc.next();
		System.out.println("Enter price :");
		Double a3 = sc.nextDouble();
		System.out.println("Enter quantity :");
		int a4 = sc.nextInt();
		System.out.println("Enter manufacturer :");
		String a5 = sc.next();
		
		List<Object> Product = Arrays.asList(a1,a2,a3,a4,a5);
		Product.stream().forEach(s -> System.out.println(s));
		
		Product p = session.find(Product.class, Product);
		session.persist(p);
	}
	public void Viewallproducts() {
		List<Product> product =session.createQuery("Select p from Product p",Product.class).getResultList();
		product.stream().forEach(s ->System.out.println(s));
		int n = sc.nextInt();
		Product p1 = session.find(Product.class, product);
		System.out.println(p1.toString());
	}
	public void Updatequantity() {
		System.out.println("Enter Quantity :");
		int s = sc.nextInt();
		Product p2 = session.find(Product.class, product);
		p2.setQuantity(s);
	}
	public void DeleteproductbyID() {
		System.out.println("Enter Id :");
		int c = sc.nextInt();
		Product p3 = session.find(Product.class, product);
		session.remove(p3);
		transaction.commit();
		session.clear();
		
	}
}
