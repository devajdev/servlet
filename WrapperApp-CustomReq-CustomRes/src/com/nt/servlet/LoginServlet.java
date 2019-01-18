package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String uname=null,pwd=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		uname=req.getParameter("uname");
		pwd=req.getParameter("pwd");
		System.out.println("uname=="+uname+"pwd=="+pwd);
		//validate username and passord
		if(uname.equalsIgnoreCase("raja@gmail.com") && pwd.equals("rani")){
			pw.println("<h1 style='color:green'>Valid Credentials </h1>");
		}
		else{
			pw.println("<h1 style='color:red'>InValid Credentials </h1>");
		}
		//add hyperlink
		pw.println("<a href='login.html'>home </a>");
		//close stream
		pw.close();
	}//doGet(req,res)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(req,res)
}//class
