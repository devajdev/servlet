package com.nt.jdbc;

import java.sql.SQLException;

import javax.sql.RowSet;

import oracle.jdbc.rowset.OracleJDBCRowSet;

public class JdbcRowSetDemo {

	public static void main(String[] args) {
		RowSet rowset=null;
		try{
			rowset=new OracleJDBCRowSet();
			//set param values
			rowset.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			rowset.setUsername("system");
			rowset.setPassword("manager");
			rowset.setCommand("select * from student");
			rowset.execute();
			
			while(rowset.next()){
				System.out.println(rowset.getInt(1)+"" +rowset.getString(2)+"  "+rowset.getString(3));
			}//while
			System.out.println("1");
			//Thread.sleep(40000); // during this perioed stop the DB s/w
			rowset.absolute(3);
			rowset.updateString(3,"srilanka");
			rowset.updateRow();
			
			System.out.println(rowset.getInt(1)+"" +rowset.getString(2)+"  "+rowset.getString(3));	

			System.out.println("2");
			//Thread.sleep(40000); // during this perioed stop the DB s/w
			
			while(rowset.next()){
				System.out.println(rowset.getInt(1)+"" +rowset.getString(2)+"  "+rowset.getString(3));
			}//while

			
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e ){
			e.printStackTrace();
		}
		finally{
			//close jdbc objs
			try{
				if(rowset!=null){
					rowset.close();
				}
			}//try
				catch(Exception e){
					e.printStackTrace();
				}
		}//finally
	}//method
}//class
