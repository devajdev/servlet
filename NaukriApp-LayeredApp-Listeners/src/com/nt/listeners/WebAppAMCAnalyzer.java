package com.nt.listeners;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebAppAMCAnalyzer implements ServletContextListener {
    private long start,end;
  
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    	ServletContext sc=null;
        start=System.currentTimeMillis();
        sc=sce.getServletContext();
        sc.log(sc.getContextPath()+" is deployed at:::"+new Date());
        		
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    	ServletContext sc=null;
        end=System.currentTimeMillis();
        sc=sce.getServletContext();
        sc.log(sc.getContextPath()+" is undeployed/stopped/reloaded at:::"+new Date());
        sc.log(sc.getContextPath()+" is running mode for "+(end-start)+"ms");
        		
    
    }
  
}
