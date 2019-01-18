package com.nt.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestPerformanceAnalyzer implements ServletRequestListener {
    private long start,end;
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		start=System.currentTimeMillis();
		
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		HttpServletRequest req=null;
		ServletContext sc=null;
		end=System.currentTimeMillis();
		req=(HttpServletRequest)sre.getServletRequest();
		sc=req.getServletContext();
		sc.log(req.getRequestURI()+" has taken "+(end-start)+" ms time to process the request");
	}
}
