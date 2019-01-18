package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/thirdurl")
public class ThirdServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  PrintWriter pw=null;
		  RequestDispatcher rd=null;
		  HttpSession ses=null;
		  ServletContext sc=null;
		 //general settings
		  pw=res.getWriter();
		  res.setContentType("text/html");
		  //read and display request attribute values
		  pw.println("<br> ThirdServlet --->attr1(req) value::"+req.getAttribute("attr1"));
		  //read and display session attribute value
		  ses=req.getSession();
		  pw.println("<br> ThirdServlet --->attr2(ses) value::"+ses.getAttribute("attr2"));
		  
		  //read and display ServletContext attribute values
		  sc=getServletContext();
		  pw.println("<br> ThirdServlet----->attr3(sc) value::"+sc.getAttribute("attr3"));

		  
		  
	}

}
