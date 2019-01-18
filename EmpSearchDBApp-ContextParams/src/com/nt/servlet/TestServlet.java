package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		ServletConfig cg=null;
		ServletContext sc=null;
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
		//get acces  SerlvetContext obj
		sc=getServletContext();
		pw.println("<br>dbuser context param value::"+sc.getInitParameter("dbuser"));
		pw.println(" <br>ServletContext obj class name::"+sc.getClass());
		pw.println("<br>Server info::"+sc.getServerInfo());
		pw.println("<br> Servlet api version::"+sc.getMajorVersion()+"."+sc.getMinorVersion());
		pw.println("<br> Context path::"+sc.getContextPath());
		pw.println("<br> Path of web application::"+sc.getRealPath("/"));
		pw.println("<br> path of input.html"+sc.getRealPath("/input.html"));
		pw.println("<br>MIME type of input.html"+sc.getMimeType("/input.html"));
		//write log message
		sc.log("Todays Date::"+new Date());
		
		//close stream
		pw.close();
		
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}

}
