package com.nt.tags;

import java.io.IOException;
import java.util.jar.JarException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class LabelTag extends TagSupport {
	
	@Override
	public int doStartTag() {
		System.out.println("LabelTag:: doStartTag()");
	   JspWriter out=null;
	   //get Out object
	   out=pageContext.getOut();
	   try{
	   //print label 
	   out.println("<b> The prime numbers are ");
	   }
	   catch(IOException ioe){
		   ioe.printStackTrace();
	   }
	   return SKIP_BODY;
	}
	
	@Override
	public int doEndTag()  {
		JspWriter out=null;
		System.out.println("LabelTag:: doEndTag()");
		//get Out object
		out=pageContext.getOut();
		try{
			out.println("</b>");
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		return EVAL_PAGE;
	}//method
}//class
