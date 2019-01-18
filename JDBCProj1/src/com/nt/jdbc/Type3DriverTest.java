package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Type3DriverTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			//register jdbc driver
			Class.forName("ids.sql.IDSDriver");
			//establish the conenction
			con=DriverManager.getConnection("jdbc:ids://localhost:12/conn?dsn='accdsn'");
			//create STatement object
			if(con!=null)
			   st=con.createStatement();
			//send and execute SQL query
			if(st!=null)
				rs=st.executeQuery("SELECT * FROM STUDENT");
			//process the ResultSet
			if(rs!=null){
				while(rs.next()){
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				}
			}//if
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!=null)
					rs.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(st!=null)
					st.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(con!=null)
					con.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
			
		}//finally
	}//main
}//calss
