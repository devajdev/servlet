package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLAppTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		boolean isRSEmpty=true;
	  try{
		  //register JDBC driver
		  //Class.forName("org.postgresql.Driver");
		  //establish the connection
		  //con=DriverManager.getConnection("jdbc:postgresql:NTAJ99DB","postgres","tiger");
		  con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/NTAJ99DB","postgres","tiger");
		  //create Statement object
		  if(con!=null)
			  st=con.createStatement();
		  //send and execute SQL Query in DB s/w
		  if(st!=null)
			  rs=st.executeQuery("SELECT  PID,PNAME,PRICE FROM \"Product\" ");
		  //gather and process the results
		  if(rs!=null){
			  while(rs.next()){
				  isRSEmpty=false;
				  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getFloat(3));
			  }
		  }
		  
		  if(isRSEmpty==true)
			  System.out.println("No records found");
	  }//try
	  catch(SQLException se){
		  se.printStackTrace();
	  }
	/*  catch(ClassNotFoundException cnf){
		  cnf.printStackTrace();
	  }*/
	  catch(Exception e){
		  e.printStackTrace();
	  }
	  finally{
		  //close jdbc  objs
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

	}//main
}//class
