package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatableTest {

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
				//read operation
			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3));
			}
		/*	//insert operation
			if(rs!=null){
				rs.moveToInsertRow();
				rs.updateInt(1,4567);
				rs.updateString(2,"rajesh");
				rs.updateString(3,"hyd");
				rs.insertRow();
				System.out.println("Record inserted");
			}*/
/*			//update operation
			if(rs!=null){
				rs.absolute(4);
				rs.updateString(3,"new hyd");
				rs.updateRow();
			}
*/
			  //delete operation
			if(rs!=null){
				rs.absolute(2);
				rs.deleteRow();
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
