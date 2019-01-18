package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class ConnPoolServlet extends HttpServlet {
	
	private Connection getPooledConnection()throws Exception{
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		//create InitialContext obj
		ic=new InitialContext();
		//perform lookup operation and get DataSource obj
		ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		//get con object from jdbc con pool
		con=ds.getConnection();
		return con;
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;  
		String tab=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;
		int colCount=0;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		tab=req.getParameter("table");
		try{
		//get jdbc con obj from jdbc con pool
		con=getPooledConnection();
		//create JDBC STatement obj
		st=con.createStatement();
		//send and execute the SQL Query
		rs=st.executeQuery("select  *  from   "+tab);
		//create ResultMetaData 
		rsmd=rs.getMetaData();
		//get column count
		colCount=rsmd.getColumnCount();
		//print col name
		pw.println("<h1 style='color:red;text-align:center'>DB table Records</h1>");
		pw.println("<table  border='1'> <tr>");
		 for(int i=1;i<=colCount;++i){
			 pw.println("<th>"+rsmd.getColumnLabel(i)+"</th>");
		 }
		 pw.println("</tr>");
		 //print col values
		 while(rs.next()){
			 pw.println("<tr>");
			 for(int i=1;i<=colCount;++i){
				 pw.println("<td>"+rs.getString(i)+"</td>");
			 } //for
			 pw.println("</tr>");
		 }//while
		 pw.println("</table>");
		 //add hyperlink
		 pw.println("<br><a href='input.html'>home </a>");
		}//try
		catch(SQLException se){
			pw.println("<b> Internal problem </b>");
			 pw.println("<br><a href='input.html'>Try Again </a>");
			se.printStackTrace();
		}
		catch(Exception e){
			pw.println("<b> Internal problem </b>");
			pw.println("<br><a href='input.html'>Try Again </a>");
			e.printStackTrace();
		}
		finally{
			//close jdbc objs
			try{
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(st!=null)
					st.close();
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
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}
}//class
