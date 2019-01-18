package com.nt.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper {
 private HttpServletRequest req=null; 
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.req=request;
		
	}
	
	@Override
	public String getParameter(String name) {
		System.out.println("MyRequest.getParameter(-)");
		String pval=null;
		//read req param value
		pval=req.getParameter(name);
		if(name.equals("uname")){
			 if(!pval.endsWith("@gmail.com"))
				  pval=pval+"@gmail.com";
		}
		return pval;
	}//method
}//class
