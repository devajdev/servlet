package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		ServletConfig cg=null;
		//get PrintWriter
		pw=res.getWriter();
		res.setContentType("text/html");
		//get Access to ServletConfig obj
		cg=getServletConfig();
		pw.println("dbuser init param value:::"+cg.getInitParameter("dbuser"));
		
		pw.println("<br>ServletConfig obj hashCode::"+cg.hashCode());
		pw.println("<br> p1 init param value::"+cg.getInitParameter("p1"));
		pw.println("<br> Servlet logical  name::"+cg.getServletName());
		pw.println("<br> ServletConfig obj class name::"+cg.getClass());
		//close stream
		pw.close();
		
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}

}
