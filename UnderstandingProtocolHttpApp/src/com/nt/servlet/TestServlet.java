package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/testurl")
public class TestServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		Enumeration<String> e=null,e1=null;
		String name=null;
		String value=null;
		Map<String, String[]>map=null;
		Set<String> keys=null;
		//set response content type
		pw=res.getWriter();
		res.setContentType("text/html");
	/*	//reading req param values
		pw.println("pname req param value:"+req.getParameter("pname"));
		pw.println("<br>paddrs req param value:"+req.getParameter("paddrs"));
		pw.println("<br>..........................................");
		pw.println("<bR> all req param names and values");
		e=req.getParameterNames();
		while(e.hasMoreElements()){
			 name=e.nextElement();
			 value=req.getParameter(name);
			 pw.println("<br>"+name+"  "+value);
		}//while
		pw.println("<br>.............................................");
		pw.println("<br>paddrs req param values::"+Arrays.toString(req.getParameterValues("paddrs")));
		pw.println("<br>paddrs req param second value:: "+req.getParameterValues("paddrs")[1]);
		pw.println("<br>..........................................");
		pw.println("<br> all req param names and values using req.getPameterMap()<br>");
		map=req.getParameterMap();
		keys=map.keySet();
		for(String key:keys){
			pw.println("<br>key=="+key+"<br>");
			pw.println("values=="+Arrays.toString(map.get(key)));
		}//for
*/		pw.println("<br>...................................");
		pw.println("<br> user-agent req header value::"+req.getHeader("user-agent"));
		pw.println("<br> accept req header value::"+req.getHeader("accept"));
		pw.println("<br>...................................");
		pw.println("<br> all req header names and values");
		e1=req.getHeaderNames();
		while(e1.hasMoreElements()){
			 name=e1.nextElement(); //gives each header value
			 value=req.getHeader(name); //gives each header value
			 pw.println("<br>"+name+"  "+value);
		}
		//Gathering misc /Request line info
		
		pw.println("<br><b> Misc info  using ServletRequest object</b>");
		pw.println("<br> request protocol::"+req.getProtocol());
		pw.println("<br> request scheme::"+req.getScheme());
		pw.println("<br> Browser Host name::"+req.getRemoteHost());
		pw.println("<br> browser machine ip adress::"+req.getRemoteAddr());
		pw.println("<br> browser machine port number::"+req.getRemotePort());
		pw.println("<br> rquest content type"+req.getContentType());
		pw.println("<br> request content length"+req.getContentLength());
		pw.println("<br> is Secure::"+req.isSecure());
		pw.println("<br> server name::"+req.getServerName());
		pw.println("<br> server port::"+req.getServerPort());

		pw.println("<br><b> Misc info  using HttpServletRequest object</b>");
		pw.println("<br>req method:: "+req.getMethod());
		pw.println("<br>request uri:: "+req.getRequestURI());
		pw.println("<br>request url:: "+req.getRequestURL());
		pw.println("<br> request query String::"+req.getQueryString());
		pw.println("<br> servlet path"+req.getServletPath());
		pw.println("<br> Context path"+req.getContextPath());
		
		pw.println("<br> <h1 style='color:red'> Date and time :: "+new Date()+"</b>");
        res.setHeader("refresh","10");

		
		
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}

}
