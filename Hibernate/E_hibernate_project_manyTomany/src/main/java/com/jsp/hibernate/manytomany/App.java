package com.jsp.hibernate.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Customer customer1 = new Customer();
		customer1.setCustomerId(101);
		customer1.setCustomerName("mahesh");

		Customer customer2 = new Customer();
		customer2.setCustomerId(102);
		customer2.setCustomerName("ravi");

		Product product1 = new Product();
		product1.setProductId(1);
		product1.setProductName("laptop");
		product1.setProductPrice(800000);

		Product product2 = new Product();
		product2.setProductId(2);
		product2.setProductName("mobile");
		product2.setProductPrice(6000);

		// adding customer into product
		List<Product> pList = new ArrayList<Product>();
		pList.add(product1);
		pList.add(product2);
		customer1.setProduct(pList);
		customer2.setProduct(pList);

		// adding cust into prod
		List<Customer> cList1 = new ArrayList<Customer>();
		cList1.add(customer1);
		cList1.add(customer2);
		product1.setCustomer(cList1);
		product2.setCustomer(cList1);

		Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class)
				.addAnnotatedClass(Customer.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();

		session.save(customer1);
		session.save(customer2);
		session.save(product1);
		session.save(product2);

		tran.commit();
		session.close();
		sf.close();

	}
}
