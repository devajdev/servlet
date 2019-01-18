package com.nt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/firsturl")
//@WebServlet(value="/firsturl")
@WebServlet(name="first",urlPatterns="/firsturl",loadOnStartup=1)
public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd=null;
        HttpSession ses=null;
        ServletContext sc=null;
		 //create requst attributes
		req.setAttribute("attr1","val1");
		//create SEssion attribute
		ses=req.getSession();
		ses.setAttribute("attr2","val2" );
		
		//create SErvletContxt/application attribute
		sc=getServletContext();
		sc.setAttribute("attr3","val3");
		
		
		
		//forward the request Dest comp
		rd=req.getRequestDispatcher("/secondurl");
		rd.forward(req,res);
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}

}
