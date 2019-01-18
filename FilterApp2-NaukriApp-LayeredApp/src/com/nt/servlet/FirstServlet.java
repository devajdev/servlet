package com.nt.servlet;


import java.io.IOException;
import java.io.PrintWriter;

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
		 PrintWriter pw=null;
		 String name=null,addrs=null;
		 int age=0;
		 HttpSession ses=null;
	      //general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 //read form1/req1 data
		 name=req.getParameter("name");
		 age=Integer.parseInt(req.getParameter("age"));
		 addrs=req.getParameter("addrs");
		 //create HttpSession
		 ses=req.getSession();
		 //keep form1/req1 data in Session attributes
		 ses.setAttribute("name", name);
		 ses.setAttribute("age",age);
		 ses.setAttribute("addrs",addrs);
		 //Generate form2 dynamically
		 pw.println("<h1 style='color:blue'>Provide Experience and Skill Info </h1>");
		 pw.println("<body bgcolor='pink'>");
		 pw.println("<form action="+res.encodeURL("secondurl")+" method='POST'>");
		 pw.println("Experience :: <input type='text' name='exp'><br>");
		 pw.println("Skill :: <select name='skill'>");
		 pw.println("<option value='java'>JAVA/J2EE </option>");
		 pw.println("<option value='.net'>.NET </option>");
		 pw.println("<option value='php'>PHP</option>");
		 pw.println("<option value='datascience'>DATA SCIENCE</option>");
		 pw.println("</select>");
		 pw.println(" <input type='submit' value='continue'><br>");
		 pw.println("</form>");
		 pw.println("<br><b> Session Id::</b>"+ses.getId());
		 pw.println("<br> request count::"+getServletContext().getAttribute("reqCount"));
		 pw.println("</body>");
		//close stream
		 pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	     doGet(req,res);
	}

}
