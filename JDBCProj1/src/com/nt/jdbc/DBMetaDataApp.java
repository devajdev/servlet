package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBMetaDataApp {

	public static void main(String[] args) {
		Connection con=null;
		DatabaseMetaData dbmd=null;
		try{
			//register jdbc driver
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//establish the connection
			//con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			 con=DriverManager.getConnection("jdbc:odbc:oradsn","system","manager");
			//create DatabaseMetaData object
			dbmd=con.getMetaData();
			System.out.println("dbmd obj class name::"+dbmd.getClass());
			System.out.println("DB name::"+dbmd.getDatabaseProductName());
			System.out.println("DB Version::"+dbmd.getDatabaseProductVersion());
			System.out.println("SQL KeyWords::"+dbmd.getSQLKeywords());
			System.out.println("Numeric Functions::"+dbmd.getNumericFunctions());
			System.out.println("System Functions::"+dbmd.getSystemFunctions());
			System.out.println("String functions::"+dbmd.getStringFunctions());
			System.out.println("MaxChars in Db table name::"+dbmd.getMaxTableNameLength());
			System.out.println("Max Chars in Column name::"+dbmd.getMaxColumnNameLength());
			System.out.println("Max Chars in username::"+dbmd.getMaxUserNameLength());
			System.out.println("Max Row size::"+dbmd.getMaxRowSize());
			System.out.println("Max Connections::"+dbmd.getMaxConnections());
			System.out.println("Max Cols in DB table::"+dbmd.getMaxColumnsInTable());
			System.out.println("supports PL/SQL Procedudres:::"+dbmd.supportsStoredProcedures());
			
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}//main
}//class
