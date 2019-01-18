package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testurl")
public class TestServlet extends HttpServlet implements SingleThreadModel{
	
       
    
    public TestServlet() {
       System.out.println("TestServlet:0-param cosnstuctor");
    }

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		pw=res.getWriter();
		try{
			Thread.sleep(20000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		res.setContentType("text/html");
		pw.println("<h1>hello how are u ? </h1>");
		pw.close();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
