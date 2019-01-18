package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  PrintWriter pw=null;
		  Cookie cookies[]=null;
		  //general settings
		  pw=res.getWriter();
		  res.setContentType("text/html");
		  ///read all cookies
		  cookies=req.getCookies();
		  //process and display cookies
		  pw.println("<h1 style='color:red;text-align:center'> The cookies are </h1>");
		  pw.println("<table align='center'>");
		  for(Cookie ck:cookies){
			  pw.println("<tr>");
			  pw.println("<td>"+ck.getName()+"</td><td>"+ck.getValue()+"</td>");
			  pw.println("</tr>");
		  }
		  pw.println("</table>");
		
		  
		  pw.println("<h1 style='color:red;text-align:center'>Cookies are successfully displayed</h1>");
		  
		  //close stream
		  pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	     doGet(req,res);
	}

}
