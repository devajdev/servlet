package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		int no=0;
		int cube=0;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read  form data
		no=Integer.parseInt(req.getParameter("no"));
		//calculate cube value
		cube=no*no*no;
	   //display cube value
		pw.println("<h1 style='color:red'>SecondServlet -->Cube Value::"+cube+"</h1>");
		//do not close stream
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		   doGet(req,res);
	}
	

}
