package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.JobSeekerBO;

public class JobSeekerDAOImpl implements JobSeekerDAO {
	private static final String  INSERT_QUERY="INSERT INTO NAUKRI_INFO VALUES(?,?,?,?,?,?,?,REGNO_SEQ.NEXTVAL)";
	private  Connection  getPooledConnection()throws Exception{
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		//create Connection to Local Jndi Regsistry
		ic=new  InitialContext();
		//Perform jndi lookup to get DataSource obj
		ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		//get JDBC con obj from jdbc con pool
		con=ds.getConnection();
		return con;
	}//method

	@Override
	public int insert(JobSeekerBO bo)throws Exception {
	    Connection con=null;
		PreparedStatement  ps=null; 
		int count=0;
		//get con object from jdbc con pool
		con=getPooledConnection();
	     //create PreparedStatement object
	     ps=con.prepareStatement(INSERT_QUERY);
	     //set values to query params
	     ps.setString(1,bo.getName());
	     ps.setInt(2,bo.getAge());
	     ps.setString(3,bo.getAddress());
	     ps.setString(4,bo.getSkill());
	     ps.setInt(5,bo.getExp());
	     ps.setInt(6,bo.getCtc());
	     ps.setString(7,bo.getLocation());
	     //execute the query
	     count=ps.executeUpdate();
	     //close connection
	     ps.close();
	     con.close();
		return count;
	}

}
