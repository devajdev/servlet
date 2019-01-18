package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefaultServlet extends HttpServlet {
	
	
	 

	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("PlainServlet:doGet(-,-)");
		//destroy();
		PrintWriter pw=null;
		//get PrintWriter
		pw=res.getWriter();
		res.setContentType("text/html");
		
		pw.println("<h1 style='color:red'> OOPs Something went  wrong .. Please try other url wrost fellow </h1>");
		
		//close stream
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}
	
}
