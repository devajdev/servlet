package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTestRSM {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		String query=null;
		ResultSet rs=null;
		ResultSetMetaData rsmd=null;
		int colCount=0;
		try{
			//register jdbc driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:odbc:oradsn","system","manager");
			//create Statement object
			if(con!=null)
			  st=con.createStatement();
			//prepare Query
			  query="SELECT *  FROM EMP";
			  //send and execute SQL Query
			  if(st!=null){
				  rs=st.executeQuery(query);
			  }
			  //create ResultSetMetAData
			  if(rs!=null){
				  rsmd=rs.getMetaData();
			  }
			  
			  //print col names
			  if(rsmd!=null){
				  colCount=rsmd.getColumnCount();
				  for(int i=1;i<=colCount;++i)
					  System.out.print(rsmd.getColumnLabel(i)+"   ");
			  }
			  System.out.println();
			  
			  //print col data types
			  if(rsmd!=null){
				  colCount=rsmd.getColumnCount();
				  for(int i=1;i<=colCount;++i)
					  System.out.print(rsmd.getColumnTypeName(i)+"   ");
			  }
			  System.out.println();
			  
			  
			  
			  //prcoess the ResultSet object
			  if(rs!=null){
				while(rs.next()){
					for(int i=1;i<=colCount;++i){
					  System.out.print(rs.getString(i)+" ");
					}
					System.out.println();
				}//while
			  }//if
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
