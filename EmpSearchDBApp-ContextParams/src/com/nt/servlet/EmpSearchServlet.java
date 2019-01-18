//EmpSearchServlet.java
package com.nt.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;

public class   EmpSearchServlet extends  HttpServlet{
   private static final String  GET_EMPS_BY_NO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";

	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
             PrintWriter pw=null;
			 int no=0;
			 Connection con=null;
			 PreparedStatement ps=null;
			 ResultSet rs=null;
			 String driver=null,url=null,user=null,pwd=null;
			 ServletConfig cg=null;
			 ServletContext sc=null;
			 
			//general settings
			pw=res.getWriter();
			res.setContentType("text/html");
			//read form data
			no=Integer.parseInt(req.getParameter("eno"));
			//get Access to ServletContext obj
			sc=getServletContext();
			driver=sc.getInitParameter("driverClass");
			url=sc.getInitParameter("url");
			user=sc.getInitParameter("dbuser");
			pwd=sc.getInitParameter("dbpwd");
			pw.println("<b> hello </b>");
			//write jdbc code
			try{
             //register jdbc driver by Loading Driver class
			        Class.forName(driver);
                //establish the conneciton
                  con=DriverManager.getConnection(url,user,pwd);
				  //create Statement object
				  ps=con.prepareStatement(GET_EMPS_BY_NO);
				  //set query param values
				    ps.setInt(1,no);
					//execute the query
                      rs=ps.executeQuery();
					  //process the ResultSet obj
					  if(rs.next()){
             			  pw.println("<h1 style='color:red'>Employee Details </h1>");
						  pw.println("<b> Employee Number::"+rs.getInt(1)+"</b> <br>");
						  pw.println("<b> Employee Name::"+rs.getString(2)+"</b><br>");
						  pw.println("<b> Employee Job::"+rs.getString(3)+"</b><br>");
                          pw.println("<b> Employee Salary::"+rs.getInt(4)+"</b><br>");
					  }
					  else{
						  pw.println("<b> Record not found </b>");
					  }
                      //add hyperlink
					  pw.println("<a href='input.html'>home </a>");
					  
					  pw.println("ServletConfig obj hashCode::"+cg.hashCode());

			    } //try
				catch(Exception e){
                    e.printStackTrace();
				}
				finally{
					try{
						if(rs!=null)
							 rs.close();
					}
					catch(SQLException se){
						 se.printStackTrace();
					}
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

			}//doGet(-,-)

          public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
             doGet(req,res);
		  }

}//class