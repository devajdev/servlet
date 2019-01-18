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

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession ses=null;
		ServletContext sc=null;
		RequestDispatcher rd=null;
		//create attributes having diff scopes
		req.setAttribute("attr1","val1"); //req attr

		ses=req.getSession();
		ses.setAttribute("attr2", "Val2");  //ses attr

		sc=getServletContext();
		sc.setAttribute("attr3","val3");  //sc attr
		//forward request to el_test.jsp
		rd=req.getRequestDispatcher("/el_test.jsp");
		rd.forward(req,res);
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       doGet(req,res);
	}//doPost(-,-)
}//class
