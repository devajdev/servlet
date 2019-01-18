package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;

@WebServlet("/uploadurl")
public class FileUploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		MultipartFormDataRequest nreq=null;
		UploadBean bean=null;
		Hashtable< String,UploadFile> files=null;
		Enumeration <UploadFile>e=null;
		UploadFile file=null;
		//general settings
		pw=res.getWriter();
		//response downloading code
		res.setContentType("application/msword");
		res.setHeader("Content-Disposition","inline");
		
		try{
		//create Special Request object
		nreq=new MultipartFormDataRequest(req);
		//create UploadBean class obj
		bean=new UploadBean();
		bean.setFolderstore("c:/store");
		bean.setFilesizelimit(10*1024);
		bean.setOverwrite(false);
		//comple fileuploading
		bean.store(nreq);
		pw.println("<h1 style='color:red'>Files are uploaded </h1> ");
		pw.println("<h1 style='color:red'>The uploaded file names are</h1> ");
		files=nreq.getFiles();
		e=files.elements();
		while(e.hasMoreElements()){
			file=e.nextElement();
			pw.println("<br><b>"+file.getFileName()+","+file.getFileSize()+"</b>");
		}
		}
		catch(Exception ex){
			pw.println("<br><b> file size must be <= 5kb</b>");
			ex.printStackTrace();
		}
	
		//add home hyperlink
		pw.println("<br><a href='form.html'>home</a>");
    //close stream
		pw.close();
	
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  doGet(req,res);
	}

}//class
