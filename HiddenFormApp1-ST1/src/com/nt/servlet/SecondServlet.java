package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="second",value="/secondurl")
public class SecondServlet extends HttpServlet {
	private static final String INSERT_QUERY="INSERT INTO HID_DETAILS VALUES(?,?,?,?,?,?)";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String f2val1=null,f2val2=null;
		String name=null,fname=null,ms=null;
		int age=0;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form2/req2 data
		f2val1=req.getParameter("f2t1");
		f2val2=req.getParameter("f2t2");
		//read form1/req1 data  from hidden boxes (session tracking)
		ms=req.getParameter("hms");
		name=req.getParameter("hname");
		fname=req.getParameter("hfname");
		age=Integer.parseInt(req.getParameter("hage"));
		//write jdbc code to insert form1/req1 data as record in DB table
		try{
			//Load driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create PreparedStatement obj
			ps=con.prepareStatement(INSERT_QUERY);
			//set values to Query params
			ps.setString(1,name);
			ps.setString(2,fname);
			ps.setInt(3,age);
			ps.setString(4,ms);
			ps.setString(5,f2val1);
			ps.setString(6,f2val2);
			//execute Query
			result=ps.executeUpdate();
			//process the result
			if(result==0){
				pw.println("<h1 style='color:red;text-align:center'> Registration Failed </h1>");
				}
			else{
				pw.println("<h1 style='color:red;text-align:center'> Registration Succeded </h1>");
			}
			
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
		}
		
		//dispaly form1/req1 data
		pw.println("<br><b> form1/req1 data:::"+name+"...."+fname+"...."+age+"...."+ms+"</b>");
		pw.println("<br><b> form2/req2  data:::"+f2val1+"..."+f2val2+"</b>");
		//add hyperlink
		pw.println("<br><a href='details.html'>home </a>");
		//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)

}//class
