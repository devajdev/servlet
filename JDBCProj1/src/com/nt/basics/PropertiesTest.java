package com.nt.basics;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		Properties props=null;
		InputStream is=null;
		
		try{
			//locate properties
			is=new FileInputStream("src/com/nt/commons/myfile.properties");
			//create Properties obj and load properties into that object
			props=new Properties();
			props.load(is);
			//To get Property vlaues..
			System.out.println(props);
			//To get my.name key value
			System.out.println("my.name key value::"+props.getProperty("my.name"));
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(is!=null)
					is.close();
			   }//try
			catch(IOException ioe){
				 ioe.printStackTrace();
			}
		}//finally
	}//main
}//class
