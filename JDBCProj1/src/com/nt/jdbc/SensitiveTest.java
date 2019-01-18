package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SensitiveTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		int count=0;
		try{
			//estalblish the connection
			//con=DriverManager.getConnection("jdbc:odbc:oradsn","system","manager");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create Statement object
			if(con!=null)
			   st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					                                      ResultSet.CONCUR_UPDATABLE);
			//send and execute the SQL Query
			if(st!=null)
			   rs=st.executeQuery("SELECT SNO,SNAME,SADD FROM STUDENT");
			//process the ResultSet 
			if(rs!=null){
			while(rs.next()){
				
				if(count==0)
					Thread.sleep(30000);
				rs.refreshRow();
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3));
				count++;
			}
			}
		}//try
		catch(SQLException se){
			se.printStackTrace();
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
