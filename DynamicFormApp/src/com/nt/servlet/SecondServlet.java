package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="second",value="/secondurl")
public class SecondServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String f2val1=null,f2val2=null;
		String name=null,fname=null,ms=null,age=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form2/req2 data
		f2val1=req.getParameter("f2t1");
		f2val2=req.getParameter("f2t2");
		//read form1/req1 data
		ms=req.getParameter("ms");
		name=req.getParameter("name");
		fname=req.getParameter("fname");
		age=req.getParameter("age");
		//dispaly form1/req1 data
		pw.println("<br><b> form1/req1 data:::"+name+"...."+fname+"...."+age+"...."+ms+"</b>");
		pw.println("<br><b> form2/req2  data:::"+f2val1+"..."+f2val2+"</b>");
		//add hyperlink
		pw.println("<br><a href='details.html'>home </a>");
		//close stream
		pw.close();
		
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
