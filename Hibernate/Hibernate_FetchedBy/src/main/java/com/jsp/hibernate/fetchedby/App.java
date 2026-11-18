package com.jsp.hibernate.fetchedby;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	 public static void main( String[] args )
	    {
	        Person person = new Person();
	        person.setPersonId(101);
	        person.setPersonName("Prashant");
	        
	        Aadhar aadhar = new Aadhar();
	        aadhar.setAadharId(1);
	        aadhar.setAadharNo(486975482);
	        
	        
	        Configuration cfg = new Configuration().configure().addAnnotatedClass(Person.class).addAnnotatedClass(Aadhar.class);
	        SessionFactory sf = cfg.buildSessionFactory();
	        Session session = sf.openSession();
	        Transaction tran = session.beginTransaction();
	        
	        //Adding Aadhar obj to Person
	        person.setAadhar(aadhar);
	        
	        //Adding Person obj to Aadhar
	        //aadhar.setPerson(person);
	        
	        session.save(person);
	        session.save(aadhar);
	        
	        tran.commit();
	        session.close();
	        sf.close();
	    }
}
