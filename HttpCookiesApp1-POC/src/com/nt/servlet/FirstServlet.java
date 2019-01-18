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
		  Cookie ck1=null,ck2=null,ck3=null,ck4=null;
		  //general settings
		  pw=res.getWriter();
		  res.setContentType("text/html");
		  //Create cookies
		  ck1=new Cookie("AP","Amaravathi");
		  ck2=new Cookie("TS","hyderabad");
		  res.addCookie(ck1); //InMemory Cookie
		  res.addCookie(ck2); //InMemory Cookie
		  ck3=new Cookie("MH","mumbai");
		  ck4=new Cookie("MP","Bhopal");
		  ck3.setMaxAge(60);
		  ck4.setMaxAge(60);
		  res.addCookie(ck3);  //persistent cookie
		  res.addCookie(ck4);  //persistent cookie
		  
		  pw.println("<h1 style='color:red;text-align:center'>Cookies are successfully added </h1>");
		  
		  //close stream
		  pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	     doGet(req,res);
	}

}
