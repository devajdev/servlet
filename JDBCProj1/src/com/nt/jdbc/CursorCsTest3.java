package com.nt.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class CursorCsTest3 {
  private static final String  CALL_PROCEDURE="{call GET_STUDENTS_BY_INITIALS(?,?)}";
	public static void main(String[] args) {
		Scanner sc=null;
		String initChars=null;
		Connection con=null;
		CallableStatement cs=null;
		ResultSet rs=null;
		boolean isRsEmpty=true;
		try{
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("Enter initial chars of student name::");
				initChars=sc.next()+"%";  //gvies sa% 
			}
			//register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create CallableStatement object
			if(con!=null)
				cs=con.prepareCall(CALL_PROCEDURE);
			//register OUT parameter with JDBC type
			if(cs!=null)
				cs.registerOutParameter(2,OracleTypes.CURSOR);
			//set value to IN param
			if(cs!=null)
				cs.setString(1,initChars);
			//call PL/SQL Procedure
			  if(cs!=null)
				  cs.execute();
			  //Gather ResultSet from Out param
			  if(cs!=null)
				  rs=(ResultSet)cs.getObject(2);
			  //process the ResultSEt
			  if(rs!=null){
				  while(rs.next()){
					  isRsEmpty=false;
					  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				  }//while
				  if(isRsEmpty==true)
					  System.out.println("Students not found");
					  
			  }//if
		}//try
		catch(SQLException  | ClassNotFoundException e){
			e.printStackTrace();
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
				if(cs!=null)
					cs.close();
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
			
			try{
				if(sc!=null)
					sc.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
		}//finally
	}//main
}//class
