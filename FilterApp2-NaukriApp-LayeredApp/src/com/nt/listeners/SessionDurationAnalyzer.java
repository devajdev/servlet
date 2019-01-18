package com.nt.listeners;

import java.util.Date;

import javax.servlet.ServletContext;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//@WebListener
public class SessionDurationAnalyzer implements HttpSessionListener {
    private long start,end;
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
    	ServletContext sc=null;
    	start=System.currentTimeMillis();
    	sc=se.getSession().getServletContext();
    	sc.log(sc.getContextPath()+" has started Session at::"+new Date());
    	
    }
    
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    	ServletContext sc=null;
    	end=System.currentTimeMillis();
    	sc=se.getSession().getServletContext();
    	sc.log(sc.getContextPath()+" has  ended session at::"+new Date());
    	sc.log(sc.getContextPath()+" session duration::"+(end-start));
    }
	
    
}
