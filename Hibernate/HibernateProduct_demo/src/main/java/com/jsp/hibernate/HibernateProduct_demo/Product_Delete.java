package com.jsp.hibernate.HibernateProduct_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Product_Delete {
	public static void main( String[] args )
	{
		//optimized the below 3 lines of configuration code into 1 line of code.
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class);

		SessionFactory sf =cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();

		//Fetching the data from DB
		Product product = session.get(Product.class, 102);
		
		//Deleting the record in the DB
		session.delete(product);

		tran.commit();
		session.close();
		sf.close();

	}
}
