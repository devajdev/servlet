package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlainServlet extends HttpServlet {
	
	static{
		System.out.println("PlainServlet:static block");
	}
	
	 public PlainServlet() {
		System.out.println("PlainServlet:0-param constructor");
	}
	 
	 public void init(){
		 System.out.println("PlainServlet: init() method");
	 }
	 

	 @Override
	public void init(ServletConfig cg) throws ServletException {
		// super.init(cg);
		System.out.println("PlainServlet:init(-) method");
		System.out.println("dbuser init param value::"+cg.getInitParameter("dbuser"));
		System.out.println("dbpwd init param vlaue::"+cg.getInitParameter("dbpwd"));
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("PlainServlet:doPost(-,-)");
		//destroy();
		PrintWriter pw=null;
		//get PrintWriter
		pw=res.getWriter();
		res.setContentType("text/plain");
		//displays IPL Details
		pw.println("<table border='1' align='center' >");
		pw.println("<tr><th>Team </th> <th>Captain</th></tr>");
		pw.println("<tr><td>SRH</td><td>Willamson</td></tr>");
		pw.println("<tr><td>CSK</td><td>MsDhoni</td></tr>");
		pw.println("<tr><td>MI</td><td>Rohit Sharma</td></tr>");
		pw.println("<tr><td>RCB</td><td>Virat Kohli</td></tr>");
		pw.println("<tr><td>KKR</td><td>Dinesh Karthik</td></tr>");
		pw.println("</table>");
		
		
		//close stream
		pw.close();
	}
	
	
	
	@Override
	public void destroy() {
	   System.out.println("Plain Servet: destroy()");
	}
	
	public static void main(String args[]){
		System.out.println("main(-) method");
	}

}
