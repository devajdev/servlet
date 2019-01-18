package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.BookBO;

public class SearchBooksDAOImpl implements SearchBooksDAO {
	 private static final String GET_BOOKS_BY_CATEGORY="SELECT BOOKID,BOOKNAME,AUTHOR,STATUS,PRICE,CATEGORY FROM SELECT_BOOKS WHERE CATEGORY=?";
	private Connection getPooledConnection()throws Exception{
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		//create InitialContext obj
		ic=new InitialContext();
		//get Datasource obj from jndi registry
		ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		//get Pooled jdbc con obj from jdbc con pool
		con=ds.getConnection();
		return con;
	}

	@Override
	public List<BookBO> findBooks(String category) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<BookBO> listBO=null;
		BookBO bo=null;
		//get Pooled Jdbc con object
		con=getPooledConnection();
		//create PreparedStatement obj
		ps=con.prepareStatement(GET_BOOKS_BY_CATEGORY);
		//set values to query params
		ps.setString(1,category);
		//execute the  query
		rs=ps.executeQuery();
		//copy ResultSet obj records to  ListBO collection
		listBO=new ArrayList();
		while(rs.next()){
			//copy each record of RS to BO class object
			bo=new BookBO();
			bo.setBookId(rs.getInt(1));
			bo.setBookName(rs.getString(2));
			bo.setAuthor(rs.getString(3));
			bo.setStatus(rs.getString(4));
			bo.setPrice(rs.getFloat(5));
			bo.setCategory(rs.getString(6));
			//add BO to ListBO
			listBO.add(bo);
		}//while
		//close jdbc objs
		rs.close();
		ps.close();
		con.close();
		return listBO;
	}//method
}//class
