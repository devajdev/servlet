package com.nt.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class ConnPoolTest {

	public static void main(String[] args) {
		OracleConnectionPoolDataSource ds=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		  try{
			  ds=new OracleConnectionPoolDataSource();
			  ds.setDriverType("thin");
			  ds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			  ds.setUser("system");
			  ds.setPassword("manager");
			  //get pooled con obj
			  con=ds.getConnection();
			  //create STatement 
			  st=con.createStatement();
			  //execute the Query
			  rs=st.executeQuery("select * from student");
			  //process the ResultSEt
			  while(rs.next()){
				  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+" "+rs.getString(3));
			  }//while
			  
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
		  }

	}

}
