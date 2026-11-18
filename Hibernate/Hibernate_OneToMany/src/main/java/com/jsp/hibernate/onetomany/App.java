package com.jsp.hibernate.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
       Company company = new Company();
       company.setCompanyId(1);
       company.setCompanyName("Google");
       
       Employee employee1 = new Employee();
       employee1.setEmployeeId(101);
       employee1.setEmployeeName("Smith");
       employee1.setSalary(100000);
       
       Employee employee2 = new Employee();
       employee2.setEmployeeId(102);
       employee2.setEmployeeName("John");
       employee2.setSalary(200000);
       
       //Adding Employees into the Company
       List<Employee> eList = new ArrayList<Employee>();
       eList.add(employee1);
       eList.add(employee2);
       
       company.setEmployees(eList);
       
       Configuration cfg = new Configuration().configure().addAnnotatedClass(Company.class).addAnnotatedClass(Employee.class);
       SessionFactory sf = cfg.buildSessionFactory();
       Session session = sf.openSession();
       Transaction tran = session.beginTransaction();
       
       session.save(company);
       session.save(employee1);
       session.save(employee2);
       
       tran.commit();
       session.close();
       sf.close();
    }
}
