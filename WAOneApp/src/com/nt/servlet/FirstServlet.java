package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.stest.PrinterUtil;

public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		int no=0;
		int square=0;
		ServletContext localContext=null,foriegnContext=null;
		RequestDispatcher rd=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		no=Integer.parseInt(req.getParameter("no"));
		//calculate square value
		square=no*no;
		pw.println("<h1 style='color:blue'>FirstServlet-->Square Value ::: "+square+"</h1>");
		//get Access to localContext
		localContext=getServletContext();
		try{
		//get Access to ForiegnContext
		foriegnContext=localContext.getContext("/WATwoApp");
		//create RequestDispatcher obj pointing Dest comp
		rd=foriegnContext.getRequestDispatcher("/secondurl");
		//include the response
		rd.include(req, res);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//add hyperlink
		pw.println("<a href='form.html'>home </a>");
		//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)
}//class
