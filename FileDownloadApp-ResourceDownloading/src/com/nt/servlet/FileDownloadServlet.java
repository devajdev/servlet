package com.nt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/downloadurl")
public class FileDownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		File file=null;
		ServletContext sc=null;
		long length=0;
		String mimeType=null;
		String name=null;
		InputStream is=null;
		ServletOutputStream sos=null;
		byte[] buffer=null;
		int bytesRead=0;
		//get file name to be downloaded
		name=req.getParameter("name");
		//get Access to ServletContext obj
		sc=getServletContext();
		//Locate the file to be downloaded
		file=new File(sc.getRealPath("/")+"/"+name);
		System.out.println(file.getAbsolutePath());
		//get File length
		length=file.length();
		//set file length as response content  length
		res.setContentLengthLong(length);
		//get file MIME type
		mimeType=sc.getMimeType(name);
		//set file mime type as response content type
		res.setContentType(mimeType);
		//given instruction to broweser to make the recived output  as downloadable file
				res.addHeader("Content-Disposition","attachment;fileName="+name);
		//create InputStream pointing to file
		is=new FileInputStream(file);
		//create OutputStream pointing response object
		sos=res.getOutputStream();
		//write stream based logic using buffer to copy file content to response object
		buffer=new byte[1024];
		while((bytesRead=is.read(buffer))!=-1){
			sos.write(buffer, 0,bytesRead);
		}
		
		
		//close streams
		is.close();
		sos.close();

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}

}
