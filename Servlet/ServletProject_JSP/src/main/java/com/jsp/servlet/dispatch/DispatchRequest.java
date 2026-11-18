package com.jsp.servlet.dispatch;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DispatchRequest extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int recivedId = Integer.parseInt(req.getParameter("Id"));
		String recivedName = req.getParameter("name");
		
		req.setAttribute("key1", recivedId);
		req.setAttribute("key2", recivedName);
		
		RequestDispatcher rd = req.getRequestDispatcher("output.jsp");
		rd.forward(req, res);
	}
}
