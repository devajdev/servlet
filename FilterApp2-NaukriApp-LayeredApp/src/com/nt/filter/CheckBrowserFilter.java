package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CheckBrowserFilter extends GenericFilter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter pw=null;
		String brName=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//get the browser s/w name 
		brName=((HttpServletRequest)req).getHeader("user-agent");
		System.out.println(brName);
		//allow only the requests coming from Chrome browser
		if(brName.indexOf("Chrome")==-1){
			pw.println("<h1 style='color:red;text-align:center'>Request must be given only from Chrome browser</h1>");
			return ;
		}
		else{
			System.out.println("CheckBrowserFilter.doFilter(-,-,-) before chain.doFilter(-,-)");
			chain.doFilter(req,res);
			System.out.println("CheckBrowserFilter.doFilter(-,-,-) after chain.doFilter(-,-)");
		}
		//close stream
		pw.close();
	}//doFilter(-,-)

}
