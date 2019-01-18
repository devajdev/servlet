package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingTest {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		int result[]=null;
		int sum=0;
		try{
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			//create Statement object
			if(con!=null)
			    st=con.createStatement();
			//add queries to the batch
			if(st!=null){
				st.addBatch("insert into student values(1023,'ramesh','hyd')");
				st.addBatch("update student set sadd='vizag223' where sno>=2000");
				st.addBatch("delete from student where sadd='vizag'");
			}
			//execute the Batch
			if(st!=null)
				result=st.executeBatch();
			//process the result
			for(int i=0;i<result.length;++i)
				sum=sum+result[i];
			
			System.out.println("No.of records effected::"+sum);
			
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
