package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcelServlet extends HttpServlet {
	
	static{
		System.out.println("ExcelServlet:static block");
	}
	
	 public ExcelServlet() {
		System.out.println("ExcelServlet:0-param constructor");
	}
	 
	 @Override
	public void init(ServletConfig cg) throws ServletException {
		System.out.println("ExcelServlet:init(-) method");
	}
	
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("ExcelServlet:doGet(-,-)");
		PrintWriter pw=null;
		//get PrintWriter
		pw=res.getWriter();
		res.setContentType("application/vnd.ms-excel");
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
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   doGet(req,resp);
	}

}
