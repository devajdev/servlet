package com.nt.jdbc;

import java.io.FileWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.SQLException;

import oracle.jdbc.rowset.OracleWebRowSet;

public class OracleWebRowSetTest {

	public static void main(String[] args) {
		OracleWebRowSet wrowset=null;
		StringWriter sw=null;
		Writer writer=null;
		try{
			wrowset=new OracleWebRowSet();
			wrowset.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			wrowset.setUsername("system");
			wrowset.setPassword("manager");
			wrowset.setCommand("select * from student");
			wrowset.execute();
			//write to the file...
			writer=new FileWriter("d:/student.xml");
		   wrowset.writeXml(writer);
		   //write to console
		   sw=new StringWriter();
		   wrowset.writeXml(sw);
		   System.out.println(sw);
		   
		}//try
		catch(SQLException se){
			se.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
			  if(wrowset!=null)
				  wrowset.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
		}//finally

	}//main
}//class
