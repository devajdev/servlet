package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HtmlServlet extends HttpServlet {
	static{
		System.out.println("HtmlServlet:static block");
	}
	
	 public HtmlServlet() {
		System.out.println("HtmlServlet:0-param constructor");
	}
	 
	 @Override
	public void init(ServletConfig cg) throws ServletException {
		System.out.println("HtmlServlet:init(-) method");
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("HtmlServlet:doGet(-,-) method");
		PrintWriter pw=null;
		//get PrintWriter
		pw=res.getWriter();
		res.setContentType("text/html");
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
