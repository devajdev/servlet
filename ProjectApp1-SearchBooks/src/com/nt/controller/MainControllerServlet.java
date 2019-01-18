package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.BookDTO;
import com.nt.service.SearchBooksService;
import com.nt.service.SearchBooksServiceImpl;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
      

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String category=null,source=null;
	    SearchBooksService service=null;   
	    List<BookDTO> listDTO=null;
	    RequestDispatcher rd=null;
	    String destPage=null;
	    
		//read form data (select box, hidden Box)
		category=req.getParameter("category");
		source=req.getParameter("source");
		//create Service class obj
		service=new SearchBooksServiceImpl();
		try{
		//use service
		listDTO=service.searchBooks(category);
		//keep result in request scope
		req.setAttribute("searchResults",listDTO);
		//forward req to either html_screen.jsp or excel_screen.jsp
		  if(source.equalsIgnoreCase("html"))
			  destPage="html_screen.jsp";
		  else
			  destPage="excel_screen.jsp";
		  //forward request
		  rd=req.getRequestDispatcher(destPage);
		  rd.forward(req,res);
		  
		  
		}
		catch(Exception e){
			rd=req.getRequestDispatcher("/error.jsp");
			rd.forward(req,res);
		}
		
		
		
		
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}

}
