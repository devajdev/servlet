package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.service.StudentServiceImpl;
import com.nt.vo.StudentVO;

public class MainControllerServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
	   String sno=null,sname=null,m1=null,m2=null,m3=null;
	   StudentVO vo=null;
	   StudentDTO dto=null;
	   StudentService service=null;
	   String result=null;
		//general settings
		pw=res.getWriter();
		res.setContentType("text/html");
		//read form data
		sname=req.getParameter("sname");
		m1=req.getParameter("m1");
		m2=req.getParameter("m2");
		m3=req.getParameter("m3");
		//create VO class obj
		vo=new StudentVO();
		vo.setSname(sname);
		vo.setM1(m1);
		vo.setM2(m2);
		vo.setM3(m3);
		//convert StudentVO class obj to StudentDTO class obj
		dto=new StudentDTO();
		dto.setSname(vo.getSname());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));
		//create Service class object
		service=new StudentServiceImpl();
		try{
			result=service.generateResult(dto);
			pw.println("<h1> Result :::"+result+"</h1>");
			pw.println("<a href='form.html'>home</a>");
		}
		catch(Exception se){
			pw.println("<h1> Internal problem :::"+se.getMessage()+"</h1>");
			pw.println("<a href='form.html'>Try again </a>");
		}
		
		//close steam
		pw.close();
		
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
}//class
