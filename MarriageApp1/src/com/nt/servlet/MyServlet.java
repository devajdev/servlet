package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   PrintWriter pw=null;
		//general settings
	   pw=res.getWriter();
	   res.setContentType("text/html");
	   pw.println("<h1 style='color:red;text-align:center'>Some thing went wrong</h1>");
	   
		//close stream
	   pw.close();
		
	}//doGet(-,-)
}
