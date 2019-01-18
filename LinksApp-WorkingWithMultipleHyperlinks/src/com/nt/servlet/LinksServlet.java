package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.stest.PrinterUtil;

public class LinksServlet extends HttpServlet {

	
	public  void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	    PrintWriter pw=null;
	    String pval=null;
	    Locale locales[]=null;
		//general settings
	    pw=res.getWriter();
	    res.setContentType("text/html");
	    //read req param value (p1) 
	    pval=req.getParameter("p1");
	    //Differentiate the logics for hyperlinks
	    locales=Locale.getAvailableLocales();
	    if(pval.equalsIgnoreCase("link1")){  //languages
	    	pw.println("<h1> All languages are </h1>");
	    	for(Locale l:locales){
	    		pw.println("<br>"+l.getDisplayLanguage());
	    	}
	    }
	    else if(pval.equalsIgnoreCase("link2")){ //countries
	    	pw.println("<h1> All Countries are </h1>");
	    	for(Locale l:locales){
	    		pw.println("<br>"+l.getDisplayCountry());
	    	}
	    }
	    else{  //system propertes
	    	pw.println("system properties::"+System.getProperties());
	    }
		
	    PrinterUtil pu=PrinterUtil.getInstance();
		  System.out.println("pu hashcode::"+pu.hashCode());
	    
	    //close stream
	    pw.close();
	}//doGet(-,-)
}//class
