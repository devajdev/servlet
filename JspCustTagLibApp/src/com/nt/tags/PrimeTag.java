package com.nt.tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PrimeTag extends TagSupport {
	 private int n=10;
	 
	public void setN(int n) {
		this.n = n;
	}
	
	private boolean isPrime(int n){
		boolean flag=true;
		for(int i=2;i<n;++i){
			if(n%i==0){
				flag=false;
				break;
			}//if
		}//for
		return flag;
	}//method

	@Override
	public int doStartTag()  {
		JspWriter out=null;
		//get out obj
		try{
		out=pageContext.getOut();
		//print prime numbers
		for(int i=1;i<=n;++i){
			if(isPrime(i))
				out.println("<b>"+i+"<br>");
		}
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		return SKIP_BODY;
	}//method
	
	@Override
	public int doEndTag() {
		JspWriter out=null;
		//get out obj
		try{
		out=pageContext.getOut();
		//close style
		out.println("</b>");
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		return EVAL_PAGE;
	}//method
}//class
