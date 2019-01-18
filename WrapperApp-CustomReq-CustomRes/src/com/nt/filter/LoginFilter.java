package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.wrapper.MyRequest;
import com.nt.wrapper.MyResponse;


@WebFilter("/loginurl")
public class LoginFilter extends GenericFilter implements Filter {

	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hreq=null;
		 HttpServletResponse hres=null;
		 MyRequest mreq=null;
		 MyResponse mres=null;
		 String output;
		 PrintWriter pw=null;
		//type casting
		 hreq=(HttpServletRequest)req;
		 hres=(HttpServletResponse)res;
		 //create Custom request obj
		 mreq=new MyRequest(hreq);
		 //create Custom response obj
		 mres=new MyResponse(hres);
		 //delegate to dest comp/next filter
			chain.doFilter(mreq, mres);
			//response filter logic through custom Response obj
		output=mres.toString();
		output=output+"<br>...... <br>from nareshit.com";
		//get PrintWriter pointing original respose obj
		pw=res.getWriter();
		pw.println(output);
	}//doFilter(-,-,-)

}//class
