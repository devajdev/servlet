package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 PrintWriter pw=null;
		 String skill=null;
		 int exp=0;
		 HttpSession ses=null;
	      //general settings
		 pw=res.getWriter();
		 res.setContentType("text/html");
		 //read form2/req2 data
		 skill=req.getParameter("skill");
		 exp=Integer.parseInt(req.getParameter("exp"));
		 //Locate HttpSession
		 ses=req.getSession(false);
		 //keep form1/req1 data in Session attributes
		 ses.setAttribute("skill", skill);
		 ses.setAttribute("exp",exp);
		 //Generate form3 dynamically
		 pw.println("<h1 style='color:blue'>Provide CTC and Preffered Location Info </h1>");
		 pw.println("<body bgcolor='pink'>");
		 pw.println("<form action='thirdurl' method='POST'>");
		 pw.println("CTC:: <input type='text' name='ctc'><br>");
		 pw.println("Preffered Location :: <input type='text' name='location'>");
		 pw.println(" <input type='submit' value='submit'><br>");
		 pw.println("</form>");
		 pw.println("<br><b> Session Id::</b>"+ses.getId());
		 pw.println("</body>");
		//close stream
		 pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	     doGet(req,res);
	}

}
