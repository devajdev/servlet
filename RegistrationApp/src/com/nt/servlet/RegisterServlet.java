package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String pVal=null;
		String user=null,pwd=null,rtpwd=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read s1 req param value
		pVal=req.getParameter("s1");
		if(pVal==null){  //when onBlur event is raised
			pwd=req.getParameter("pwd");
			rtpwd=req.getParameter("rtpwd");
			if(pwd.equals(rtpwd)){
				pw.println("<h1 style='color:green'>Both Passwords are matching </h1>");
			}
			else{
				pw.println("<h1 style='color:red'>Both Passwords are not matching </h1>");
			}
		}
		else{ //for submit button
			pw.println("<h1 style='color:green'>The form data is (form submission)</h1>");
			pw.println("<br> name="+req.getParameter("user"));
			pw.println("<br> password="+req.getParameter("pwd"));
			pw.println("<br> Re Type password="+req.getParameter("rtpwd"));
			pw.println("<br> age="+req.getParameter("age"));
			pw.println("<br> address="+req.getParameter("addrs"));
		}
		
		//close stream 
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)
}//class
