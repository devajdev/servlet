package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		//general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 
		 System.out.println("ErrorServlet:doGet(-,-) method");
		 
		 pw.println("<h1 style='color:red;text-align:center'>Internal problem </h1>");
		 pw.println("<a href='input.html'>home </a>");
		 
		 //close stream
		 pw.close();
	
	}//method
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//method

}//class
