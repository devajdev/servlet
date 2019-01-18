package com.nt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class PerformanceTestFilter extends GenericFilter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		ServletContext sc=null;
		long start=0,end=0;
		
		start=System.currentTimeMillis();
		chain.doFilter(req,res);
		end=System.currentTimeMillis();
		//get access to Servletcontext obj
		sc=getServletContext();
		sc.log( ((HttpServletRequest)req).getRequestURI()+" has taken "+(end-start)+" ms to process the request");
	}//doFilter(-,-,-)
}//class
