package com.jsp.hibernate.HibernateProduct_demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Product_Insert 
{
	public static void main( String[] args )
	{
		Product product = new Product();
		product.setProductId(102);
		product.setProductName("Chocklet");
		product.setProductPrice(99);

		//configuration 
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Product.class);

		//SessionFactory and Transaction 
		SessionFactory sf =cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();
		
		//Insert the data in the DB
		session.save(product);

		tran.commit();
		session.close();
		sf.close();

	}
}
