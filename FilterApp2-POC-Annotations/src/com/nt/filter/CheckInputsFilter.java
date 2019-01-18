package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(value="/addurl",initParams=@WebInitParam(name="dbuser",value="system"))
public class CheckInputsFilter implements Filter {
	public CheckInputsFilter() {
		System.out.println("CheckInputsFilter:0-param constructor");
	}
	
	@Override
	public void init(FilterConfig fg) throws ServletException {
	  System.out.println("CheckInputsFilter.init(-)");
	  System.out.println("dbuser filer init param ::"+fg.getInitParameter("dbuser"));
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
	int val1=0,val2=0;
	PrintWriter pw=null;
		System.out.println("CheckInputsFilter.doFilter(-,-,-)");
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		val1=Integer.parseInt(req.getParameter("t1"));
		val2=Integer.parseInt(req.getParameter("t2"));
		//check inputs
		if(val1<=0 ||val2<=0){
			pw.println("<h1 style='color:red;text-align:center'>Allows only positive Inputs!!!! </h1>");
			pw.println("<a href='form.html'>Try Again </a>");
			return;
		}
		else{
			System.out.println("CheckInputsFilter.doFilter(-,-,-), before calling chain.doFilter(-,-)");
			chain.doFilter(req,res);
			System.out.println("CheckInputsFilter.doFilter(-,-,-), after calling chain.doFilter(-,-)");
			
		}
		
		//close stream
		pw.close();
	}//doFilter(-,-,-)
	
	@Override
	public void destroy() {
	  System.out.println("CheckInputsFilter:destroy() method");
	}

}//class
