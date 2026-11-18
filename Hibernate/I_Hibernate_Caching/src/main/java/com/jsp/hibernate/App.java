package com.jsp.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration().configure()
				.addAnnotatedClass(Mobile.class);
		SessionFactory sf = cfg.buildSessionFactory();
		//session1
		Session session1 = sf.openSession();
		Transaction tran1 = session1.beginTransaction();
		
		Mobile mobile1=session1.get(Mobile.class, 101);
		System.out.println(mobile1);
		
		Mobile mobile2=session1.get(Mobile.class, 101);
		System.out.println(mobile2);
		
		tran1.commit();
		session1.close();
		
		//session2
		Session session2 = sf.openSession();
		Transaction tran2 = session2.beginTransaction();
		
		Mobile mobile3=session2.get(Mobile.class, 101);
		System.out.println(mobile3);
		
		Mobile mobile4=session2.get(Mobile.class, 101);
		System.out.println(mobile4);
			

		tran2.commit();
		session2.close();
		
    }
}
