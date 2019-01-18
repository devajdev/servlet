package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	private static final String INSERT_QUERY="INSERT INTO INCOMETAX VALUES(?,?,?,?,?)";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    PrintWriter pw=null;
	    int income=0,tax=0;
	    Cookie cookies[]=null;
	    String name=null,fname=null;
	    Connection con=null;
	    PreparedStatement ps=null;
	    int age=0;
	    int result=0;
	    pw=res.getWriter();
	    res.setContentType("text/html");
	    //read form2/req2 data
	    income=Integer.parseInt(req.getParameter("income"));
	    tax=Integer.parseInt(req.getParameter("tax"));
	    //read form1/req1 data from cookies (Session tracking)
	    cookies=req.getCookies();
	    if(cookies!=null){
	    	name=cookies[0].getValue();
	    	fname=cookies[1].getValue();
	    	age=Integer.parseInt(cookies[2].getValue());
	    }
	    //writer jdbc code to insert form1/req1 and form2/req2 data as record
	    try{
	    	//register JDBC driver
	    	Class.forName("oracle.jdbc.driver.OracleDriver");
	    	//establish the connection
	    	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
	    	//create PreparedStatement object
	    	ps=con.prepareStatement(INSERT_QUERY);
	    	//set values to query params
	    	ps.setString(1,name);
	    	ps.setString(2,fname);
	    	ps.setInt(3,age);
	    	ps.setInt(4,income);
	    	ps.setInt(5,tax);
	    	//execute the query
	    	result=ps.executeUpdate();
	    	//process the result
	    	if(result==0)
	    		pw.println("<h1 style='color:red;text-align:center'>Registration failed</h1>");
	    	else
	    		pw.println("<h1 style='color:red;text-align:center'>Registration succeded</h1>");
	      }//try
	    catch(SQLException se){
	    	 se.printStackTrace();
	    }
	    catch(ClassNotFoundException cnf){
	    	cnf.printStackTrace();
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    }
	    finally{
	    	//close jdbc objs
	    	try{
	    		if(ps!=null)
	    			ps.close();
	    	}
	    	catch(SQLException se){
	    		se.printStackTrace();
	    	}
	    	try{
	    		if(con!=null)
	    			con.close();
	    	}
	    	catch(SQLException se){
	    		se.printStackTrace();
	    	}
	    }//finally
	    //dispaly form1/req1 and form2/req2 data as dynamic webpage content
	    pw.println("<b> form1/req1 data:::"+name+"..."+fname+"..."+age+"</b>");
	    pw.println("<b> form2/req2 data:::"+income+"..."+tax+"</b>");
	    //add hyperlink
	    pw.println("<a href='info.html'>home </a>");
	    //close stream
	    pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}

}
