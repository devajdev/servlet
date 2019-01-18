package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null,addrs=null,gender=null,ms=null,qlfy=null;
		String courses[]=null,hb[]=null;
		int age=0;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		name=req.getParameter("pname");
		addrs=req.getParameter("addrs");
		age=Integer.parseInt(req.getParameter("page"));
		gender=req.getParameter("gender");
		ms=req.getParameter("ms");
		qlfy=req.getParameter("qlfy");
		courses=req.getParameterValues("courses");
		hb=req.getParameterValues("hb");
		
		//place non-selected state for check box ,List box components
		if(ms==null)
			ms="single";
		if(courses==null){
			courses=new String[]{"no courses are selected"};
		}
		if(hb==null){
			hb=new String[]{"no hobies are selected"};
		}
		//write request processing logic
		if(gender.equalsIgnoreCase("M")){
			if(age<5)
				pw.println("<h1>Master."+name+" u  r baby boy</h1>");
			else if(age<13)
				pw.println("<h1>Master."+name+" u  r small boy</h1>");
			else if(age<20)
				pw.println("<h1>Mr."+name+" u  r teenage boy</h1>");
			else if(age<40)
				pw.println("<h1>Mr."+name+" u  r young man</h1>");
			else if(age<60)
				pw.println("<h1>Mr."+name+" u  r middle-aged man</h1>");
			else
				pw.println("<h1>Mr."+name+" u  r Budda</h1>");
		}
		else{
			if(age<5)
				pw.println("Master."+name+" u  r baby girl");
			else if(age<13)
				pw.println("<h1>Master."+name+" u  r small girl</h1>");
			else if(age<20){
				 if(ms.equals("single"))
				    pw.println("<h1>Miss."+name+" u  r teenage girl</h1>");
				 else
					 pw.println("<h1>Mrs."+name+" u  r married woman</h1>");
			}
			else if(age<40){
				if(ms.equals("single"))
				    pw.println("<h1>Miss."+name+" u  r young woman</h1>");
				 else
					 pw.println("<h1>Mrs."+name+" u  r young woman</h1>");
			}
			else if(age<60){
			   if(ms.equals("single"))
     		       pw.println("<h1>Miss."+name+" u  r middle-aged woman</h1>");
	     		 else
				 pw.println("<h1>Mrs."+name+" u  r middle-aged woman</h1>");
			   }
			else{
				   if(ms.equals("single"))
	     		       pw.println("<h1>Miss."+name+" u  r old woman</h1>");
		     		 else
					 pw.println("<h1>Mrs."+name+" u  r old woman</h1>");
			}
		}//else
		
		//dispaly form data
		pw.println("<br> name::"+name+"<br>");
		pw.println("<br> age::"+age+"<br>");
		pw.println("<br> address::"+addrs+"<br>");
		pw.println("<br> gender::"+gender+"<br>");
		pw.println("<br> marital status:"+ms+"<br>");
		pw.println("Qualification::"+qlfy);
		pw.println("Courses::"+Arrays.toString(courses));
		pw.println("Hobies ::"+Arrays.toString(hb));
		
		//add hyperlink
		pw.println("<a href='form.html'> home</a> ");
		
		//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
		
}//class
