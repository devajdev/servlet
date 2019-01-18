package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	 private  static final  String  STUDENT_LAYERED_QUERY="INSERT INTO LAYERED_STUDENT(SNAME,TOTAL,AVG,RESULT) VALUES(?,?,?,?)";
	private Connection  getPooledConnection()throws Exception{
		Connection con=null;
		InitialContext ic=null;
		DataSource ds=null;
		//create InitialContext obj
		ic=new InitialContext();
		//get DataSource object
		ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		//get Pooled Connection
		con=ds.getConnection();
		return con;
	}//method

	@Override
	public int insert(StudentBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		//get Pooled Connection
		con=getPooledConnection();
		//create PreparedStatement object
		ps=con.prepareStatement(STUDENT_LAYERED_QUERY);
		//set values to Query params
		ps.setString(1,bo.getSname());
		ps.setInt(2, bo.getTotal());
		ps.setFloat(3,bo.getAvg());
		ps.setString(4,bo.getResult());
		//execute the Query
		result=ps.executeUpdate();
		//close jdbc objs
		ps.close();
		con.close();
		//return the result
		return result;
	}//method
}//class
