package com.jsp.hibernate.employeedb;

import com.jsp.hibernate.employeedb.dao.EmployeeDao;

public class App 
{
    public static void main( String[] args )
    {
        EmployeeDao dao = new EmployeeDao();
        dao.addEmployee();
    }
}
