package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParameterMetaDataTest {
	private static final String  INSERT_QUERY="INSERT INTO STUDENT VALUES(?,?,?)";
	
	public static void main(String[] args) {
		
		ParameterMetaData pmd=null;
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		try{
			//establish the connection
			//con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","manager");
			con=DriverManager.getConnection("jdbc:odbc:oradsn", "system","manager");
			//create PreparedStatement onject
			if(con!=null)
				ps=con.prepareStatement(INSERT_QUERY);
			//create ParameterMetaData
			if(ps!=null)
				pmd=ps.getParameterMetaData();
			
			//get Parameters info
			if(pmd!=null){
				count=pmd.getParameterCount();
				for(int i=1;i<=count;++i){
					System.out.println("Parameter index::"+i);
					System.out.println("parameter mode::"+pmd.getParameterMode(i));
					System.out.println("pamaeter type name::"+pmd.getParameterTypeName(i));
					System.out.println("is nullable::"+pmd.isNullable(i));
					System.out.println("scale ::"+pmd.getScale(i));
					System.out.println("Precision::"+pmd.getPrecision(i));
				}//for
			}//if
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
	}//main
}//class
