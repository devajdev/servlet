package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PsBatchInsert {
 private static final String INSERT_SQL="INSERT INTO STUDENT VALUES(?,?,?)";
	public static void main(String[] args) {
		 Connection con=null;
		 Scanner sc=null;
		 int count=0;
		 PreparedStatement ps=null;
		 int sno=0;
		 String name=null;
		 String sadd=null;
		 int result[]=null;
		try{
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null){
				System.out.println("enter students count::");
				count=sc.nextInt();
			}
		   //register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create PrpearedStatement obj
			if(con!=null)
				ps=con.prepareStatement(INSERT_SQL);
			//read student details and add them to batch
			for(int i=1;i<=count;++i){
				System.out.println("Enter"+i+" number:");
				sno=sc.nextInt();
				System.out.println("Enter "+i+" name:");
				name=sc.next();
				System.out.println("Enter"+i+" adddrs");
				sadd=sc.next();
				//add query param values to batch
				ps.setInt(1,sno);
				ps.setString(2,name);
				ps.setString(3, sadd);
				ps.addBatch();
			}
			//execute batch
			if(ps!=null){
				result=ps.executeBatch();
			}
			
			if(result!=null)
				System.out.println("Batch Records are inserted");
			else
				System.out.println("Batch Records are not inserted");
			
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
