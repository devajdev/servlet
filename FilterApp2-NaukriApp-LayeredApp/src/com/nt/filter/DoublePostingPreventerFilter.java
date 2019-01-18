package com.nt.filter;

import java.io.IOException;
import java.util.Random;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class DoublePostingPreventerFilter extends GenericFilter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest hreq=null;
		HttpSession ses=null;
		int cToken=0,sToken=0;
		RequestDispatcher rd=null;
		//type casting
		hreq=(HttpServletRequest)req;
		//create/access  HttpSession obj
		ses=hreq.getSession();
		//generate session token if request has come to launch third form
		if(hreq.getServletPath().equalsIgnoreCase("/secondurl")){
			//generate ServerToke as as random number and make it ses attribute
			ses.setAttribute("sToken",new Random().nextInt(10000));
			chain.doFilter(req,res);
		}
		else if(hreq.getServletPath().equalsIgnoreCase("/thirdurl")){
			//read both ClientToken ,ServerToken values
			cToken=Integer.parseInt(req.getParameter("cToken"));
			sToken=(Integer)ses.getAttribute("sToken");
			System.out.println(cToken +"   "+sToken);
			if(cToken==sToken){
				ses.setAttribute("sToken",new Random().nextInt(10000));
				chain.doFilter(req,res);
			}
			else{
				rd=req.getRequestDispatcher("/dbl_post.jsp");
				rd.forward(req,res);
			}
			
		}
		else{
			chain.doFilter(req, res);
		}
	}//doFilter(-,-)
}//class
