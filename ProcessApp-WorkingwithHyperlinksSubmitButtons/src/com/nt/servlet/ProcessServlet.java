package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    PrintWriter pw=null;
	    String pval=null;
	    int val1=0;
	    int val2=0;
		//general settings
	    pw=res.getWriter();
	    res.setContentType("text/html");
	    // read form data
	    pval=req.getParameter("s1");
	    //read form data only when submit buttons are clicked
	    if(!pval.equals("link1") && !pval.equals("link2")){
	    	val1=Integer.parseInt(req.getParameter("t1"));
	    	val2=Integer.parseInt(req.getParameter("t2"));
	    }
	    //differentiate the logics for submit buttons and hyperlinks
	    if(pval.equalsIgnoreCase("add")){
	    	pw.println("<h1> Sum is "+(val1+val2)+"</h1>");
	    }
	    else if(pval.equalsIgnoreCase("sub")){
	    	pw.println("<h1> Sub is "+(val1-val2)+"</h1>");
	    }
	    else if(pval.equalsIgnoreCase("mul")){
	    	pw.println("<h1>Mu is "+(val1*val2)+"</h1>");
	    }
	    else if(pval.equalsIgnoreCase("link1")){
	    	pw.println("<h1> System Properties::"+System.getProperties()+"</h1>");
	    }
	    else{
	    	pw.println("<h1> System Date::"+new java.util.Date()+"</h1>");
	    }
	    //add hyperlink
	    pw.println("<br><a href='form.html'>home</a>");
	    //close stream
	    pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)

}
