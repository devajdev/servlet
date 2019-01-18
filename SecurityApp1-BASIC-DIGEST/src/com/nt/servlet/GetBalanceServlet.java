package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/balurl")
public class GetBalanceServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		//general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 //write messages
		 pw.println("<h1> balance is ::"+new Random().nextInt(100000));
		 //add hyperlink
		 pw.println("<br><a href='index.html'>home</a>");
		 //close stream
		 pw.close();
		
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}

}
