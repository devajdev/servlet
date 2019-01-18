package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {

	
	public void  process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet:process(-,-) method");
		PrintWriter pw=null;
		String name=null;
		int age=0;
		String gender=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		name=req.getParameter("pname");
		age=Integer.parseInt(req.getParameter("page"));
		gender=req.getParameter("gen");
		//process the request
		if(gender.equalsIgnoreCase("M")){
			if(age<21){
				pw.println("<h1 style='color:red;text-align:center'>Mr. "+name+" u  r not eglible for marriage, Enjoy  u r life");
			}
			else{
				pw.println("<h1 style='color:blue;text-align:center'>Mr. "+name+" u  r  eglible for marriage, But Think Thrice");
			}
		}
		else{
			if(age<18){
				pw.println("<h1 style='color:red;text-align:center'>Miss. "+name+" u  r not eglible for marriage, Take a breathe");
			}
			else{
				pw.println("<h1 style='color:blue;text-align:center'>Miss. "+name+" u  r  eglible for marriage , Let others to live");
			}
		}
		pw.println("<br><h4 style='color:red;text-align:center'>req obj class name::"+req.getClass()+" </h4>");
		pw.println("<br><h4 style='color:red;text-align:center'>res obj class name::"+res.getClass()+" </h4>");
				
		
		//add hyperlink
		  pw.println("<a href='input.html'>home</a>");
		
		//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet:doGet(-,-)");
		process(req,res);
	
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("MarriageServlet:doPost(-,-)");
		process(req,res);
	
	}
	
}//class
