package com.nt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String ss=null;
		String engine=null;
		String url=null;
		//read form data
		ss=req.getParameter("ss");
		engine=req.getParameter("engg");
		//frame url for send redirection
		if(engine.equalsIgnoreCase("google")){
			url="https://www.google.com/search?q="+ss;
		}
		else if(engine.equalsIgnoreCase("bing")){
			url="https://www.bing.com/search?q="+ss;
		}
		else{
			url="https://in.search.yahoo.com/search?p="+ss;
		}
		
		//perform sendRedirection
		System.out.println("SearchServlet:before res.sendRedirect(-)");
		res.sendRedirect(url);
		RequestDispatcher rd=req.getRequestDispatcher("/test.html");
		rd.include(req,res);
		
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
}//class
