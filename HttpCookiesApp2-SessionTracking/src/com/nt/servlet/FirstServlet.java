package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,fname=null;
		int		age=0;
		Cookie ck1=null,ck2=null,ck3=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		name=req.getParameter("name");
		fname=req.getParameter("fname");
		age=Integer.parseInt(req.getParameter("age"));
		//keep form1/req1 data in cookies (InMemory Cookies)
		ck1=new Cookie("name",name);
		ck2=new Cookie("fname",fname);
		ck3=new Cookie("age",String.valueOf(age));
		// add cookies to response
		res.addCookie(ck1); res.addCookie(ck2); res.addCookie(ck3);
		//generate form2 dynamically
		pw.println("<h1 style='color:red;text-align:center'>Provide InCome Details </h1>");
		pw.println("<form action='secondurl' method='POST'>");
		pw.println("income :: <input type='text' name='income'><br>");
		pw.println("tax:: <input type='text' name='tax'><br>");
		pw.println("<input type='submit' value='submit'>");
		pw.println("</form>");
		//close stream
		pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}
}//class
