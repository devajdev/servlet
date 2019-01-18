package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet{
	
	public DateServlet() {
		System.out.println("DateServlet:: 0-param constuctor");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("DateServlet::init()");
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("DateServlet::doGet(-,-)");
		PrintWriter pw=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//Write b.logic
		pw.println("<h1 style='color:red;text-align:center'>Date and time :: "+new Date()+"</h1>");
		
		//add hyperlink
		pw.println(" <a href='index.html'>home</a>");
		//close stream
		pw.close();
		
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("DateServlet::doPost(-,-)");
	  doGet(req,res);
	}

}
