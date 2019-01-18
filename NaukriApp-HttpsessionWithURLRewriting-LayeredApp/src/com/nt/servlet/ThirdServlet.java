package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.dto.JobSeekerDTO;
import com.nt.service.JobSeekerService;
import com.nt.service.JobSeekerServiceImpl;

@WebServlet("/thirdurl")
public class ThirdServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 String skill=null,name=null,addrs=null,loc=null;
		 int exp=0,ctc=0,age=0;
		 HttpSession ses=null;
		 JobSeekerDTO dto=null;
		 JobSeekerService service=null;
		 String result=null;
		 RequestDispatcher rd=null;
	      //general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 //read form3/req3 data
		 loc=req.getParameter("location");
		 ctc=Integer.parseInt(req.getParameter("ctc"));
		 //Locate HttpSession
		 ses=req.getSession(false);
		 //read form1/req1, form2/req2  data from  Session obj as sesssion attribute values
		 name=(String)ses.getAttribute("name");
		 age=(Integer)ses.getAttribute("age");
		 addrs=(String)ses.getAttribute("addrs");
		 exp=(Integer)ses.getAttribute("exp");
		 skill=(String)ses.getAttribute("skill");
		 //prepare DTO class having 3 forms data
		 dto=new JobSeekerDTO();
		 dto.setName(name);
		 dto.setAge(age);
		 dto.setAddress(addrs);
		 dto.setExp(exp);
		 dto.setSkill(skill);
		 dto.setCtc(ctc);
		 dto.setLocation(loc);
		 //create Service classs obj
		 service=new JobSeekerServiceImpl();
		 //use Service
		 try{
			 result=service.registerJobSeeker(dto);
			 pw.println("<h1 style='color:green'>"+result+"</h1>");
			 pw.println("<a href='form.html'>home </a>");
			 pw.println("<br><b> Session Id::</b>"+ses.getId());
			 //invalidate the session
			 ses.invalidate();
		 }//try
		 catch(Exception e){
			 e.printStackTrace();
			rd=req.getRequestDispatcher("/err.html");
			rd.forward(req,res);
			ses.invalidate();
		 }
		 
		//close stream
		 pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	     doGet(req,res);
	}

}
