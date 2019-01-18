package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TextTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
	try{
		//register Driver
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		//establish the connection
		con=DriverManager.getConnection("jdbc:odbc:txtdsn");
		//create Statement object
		if(con!=null)
			st=con.createStatement();
		//send and execute SQL Query
		 if(st!=null)
			 rs=st.executeQuery("SELECT * FROM file1.csv");
		 //process the ResultSet
		 if(rs!=null){
			 while(rs.next()){
				 System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			 }
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
