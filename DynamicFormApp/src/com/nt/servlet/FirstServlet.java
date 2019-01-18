package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="first",urlPatterns="/firsturl")
public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 String name=null,fname=null,ms=null;
		 int age=0;
	   //general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 //read form data
		 name=req.getParameter("name");
		 fname=req.getParameter("fname");
		 age=Integer.parseInt(req.getParameter("age"));
		 ms=req.getParameter("ms");
		 if(ms==null)
			 ms="single";
		 //Generate form2 as dynamic formpage based on given marital status
		 pw.println("<h1 style='color:red;text-align:center'>Form2-Dynamic form page </h1>");
		 if(ms.equalsIgnoreCase("married")){
			 //generate form2 related married person
			 pw.println("<form  action='secondurl'  method='POST'>");
			 pw.println("Spouse name:: <input type='text' name='f2t1'><br>");
			 pw.println("no.of kids:: <input type='text' name='f2t2'><br>");
			 pw.println("<input type='submit'  value='register'>");
			 pw.println("</form>");
		 }
		 else{
			 pw.println("<form  action='secondurl'  method='POST'>");
			 pw.println("when do u want to marry:: <input type='text' name='f2t1'><br>");
			 pw.println("why do u want to marry:: <input type='text' name='f2t2'><br>");
			 pw.println("<input type='submit'  value='register'>");
			 pw.println("</form>");
		 }
		 
		 //close stream
		 pw.close();
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}
	

}
