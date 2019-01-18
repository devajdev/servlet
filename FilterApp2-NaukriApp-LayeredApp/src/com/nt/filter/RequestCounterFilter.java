package com.nt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RequestCounterFilter extends GenericFilter {
	private int counter=0;

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		ServletContext sc=null;
		//count  the requests
		counter++;
		//make count as ServletContext attribute
		//get Access to ServletContext obj
		sc=getServletContext();
		sc.setAttribute("reqCount",counter);
		//send request to next Filter/Dest comp
		System.out.println("RequestCounterFilter.doFilter(-,-,-)-->before chain.doFilter(-,-,-)");
		chain.doFilter(req,res);
		System.out.println("RequestCounterFilter.doFilter(-,-,-)-->after chain.doFilter(-,-,-)");
	}//doFilter(-,-)

}
