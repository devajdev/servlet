package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {
	
	public AddServlet() {
		System.out.println("AddServlet:0-param constructor");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
	     System.out.println("AddServlet:init(-)");
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("AddServlet.doGet(-,-)");
	   int val1=0,val2=0;
	   int sum=0;
	   PrintWriter pw=null;
	   //get PrintWriter
	   pw=res.getWriter();
	   //set response content type
	   res.setContentType("text/html");
	   
		//read form data
	   val1=Integer.parseInt(req.getParameter("t1"));
	   val2=Integer.parseInt(req.getParameter("t2"));
	   //perform addition
	   sum=val1+val2;
	   pw.println("<h1 style='color:red;text-align:center'>Result is ::"+sum +"</h1>" );
	   
	   //add hyperlink
	   pw.println("<a href='form.html'>home </a>");
	   
	   //close stream
	   pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("AddServlet.doPost(-,-)");
		  doGet(req,res);
	}
	
	@Override
	public void destroy() {
	 System.out.println("AddServlet.destroy()");
	}

}//class
