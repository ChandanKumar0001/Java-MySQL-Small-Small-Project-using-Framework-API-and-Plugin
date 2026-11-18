package com.jsp.hibernate.onetomany;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Company c = new Company();
		c.setCompanyId(1);
		c.setCompanyName("Amazon");

		Employee e1 = new Employee();
		e1.seteId(101);
		e1.seteName("tejas");
		e1.setSalary(8000);

		Employee e2 = new Employee();
		e2.seteId(102);
		e2.seteName("nandan");
		e2.setSalary(2000);

		// adding company into the employee
		e1.setCompany(c);
		e2.setCompany(c);

		Configuration cfg = new Configuration().configure().addAnnotatedClass(Company.class)
				.addAnnotatedClass(Employee.class);
		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();

		session.save(c);
		session.save(e1);
		session.save(e2);

		tran.commit();
		session.close();
		sf.close();
	}
}
