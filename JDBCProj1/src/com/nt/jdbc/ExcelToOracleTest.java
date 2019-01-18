package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExcelToOracleTest {
   private static final String  STUDENT_INSERT_QUERY="INSERT INTO STUDENT VALUES(?,?,?)";
   private static final String  STUDENT_EXCEL_SELECT_QUERY="SELECT SNO,SNAME,SADD FROM Sheet1";
	public static void main(String[] args) {
		Connection oraCon=null,xlsCon=null;
		Statement  st=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int sno=0;
		String sname=null;
		String sadd=null;
		int count=0;
		try{
			//register jdbc drivers
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.hxtt.sql.excel.ExcelDriver");
			//establish the connections
			oraCon=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			xlsCon=DriverManager.getConnection("jdbc:excel:///e:/Excel DBs/Student.xlsx");
			//create Statement objects
			if(oraCon!=null)
				ps=oraCon.prepareStatement(STUDENT_INSERT_QUERY);
			if(xlsCon!=null)
				st=xlsCon.createStatement();
			//send and execute Query on Excel
			if(st!=null){
				rs=st.executeQuery(STUDENT_EXCEL_SELECT_QUERY);
			}
			//process the ResultSet and copy Excel Sheet records oracle Db table
			if(rs!=null && ps!=null){
				while(rs.next()){
					count++;
					//get each record from Excel sheet
					sno=rs.getInt(1);
					sname=rs.getString(2);
					sadd=rs.getString(3);
					//set the above values to insert Query params
					ps.setInt(1,sno);
					ps.setString(2,sname);
					ps.setString(3,sadd);
					//execute Query
					ps.executeUpdate();
				}//while
				System.out.println(count+" no.of records copied sucessfully");
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
				   if(ps!=null)
					   ps.close();
				}
				catch(SQLException se){
					se.printStackTrace();
				}
			try{
				   if(oraCon!=null)
					   oraCon.close();
				}
				catch(SQLException se){
					se.printStackTrace();
				}
			try{
				   if(xlsCon!=null)
					   xlsCon.close();
				}
				catch(SQLException se){
					se.printStackTrace();
				}
		}//finally
	}//main
}//class
