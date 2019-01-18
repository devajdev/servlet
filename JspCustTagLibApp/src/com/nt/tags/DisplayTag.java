package com.nt.tags;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class DisplayTag extends TagSupport {
	private String font;
	private int size=20;
	public void setFont(String font) {
		this.font = font;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public int doStartTag(){
		JspWriter out=null;
		ServletRequest req=null;
		String status=null;
		try{
		//get Out object
		out=pageContext.getOut();
		//get request object
		req=pageContext.getRequest();
		//read req param "print" value
		status=req.getParameter("print");
		//display message by applying style
		out.println("<span style='font-family:"+font+";font-size:"+size+"px;'>");
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		if(status==null)
			return SKIP_BODY;
		else if(status.equalsIgnoreCase("yes"))
		    return EVAL_BODY_INCLUDE;
		else
			return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		JspWriter out=null;
		try{
		//get Out object
		out=pageContext.getOut();
		//display message by applying style
		out.println("</span>");
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		return EVAL_PAGE;
	}//doEndTag()

}//class
