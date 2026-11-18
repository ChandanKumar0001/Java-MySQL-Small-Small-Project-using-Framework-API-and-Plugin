package com.jsp.hibernate.HibernateProduct_demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Product_Fetch {
	public static void main( String[] args )
	{

		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Product.class);
		SessionFactory sf =cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();

		//get()
		Product product = session.get(Product.class, 101);
		System.out.println(product);

		//load()
		Product product1 = session.load(Product.class, 101);
		System.out.println(product1);

		tran.commit();
		session.close();
		sf.close();

	}
}
