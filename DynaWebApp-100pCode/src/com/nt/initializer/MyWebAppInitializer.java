package com.nt.initializer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.nt.servlet.DateServlet;

public class MyWebAppInitializer implements ServletContainerInitializer {
   static{
	   System.out.println("static block of MWAI");
   }
   public MyWebAppInitializer() {
	System.out.println("MWAI::0-param constructor");
}
	
	@Override
	public void onStartup(Set<Class<?>> set, ServletContext sc) throws ServletException {
		 System.out.println("onStartup(-,-) ");
	  DateServlet servlet=null;
	  ServletRegistration.Dynamic dynamic=null;
		 //create our SErvlet class obj
	  servlet=new DateServlet();
	     //register servlet
	         dynamic=sc.addServlet("ds",servlet);
	      //set url pattern
	         dynamic.addMapping("/dateurl");
	         //enable Load on Servlet
	         dynamic.setLoadOnStartup(1);
	}//ondStatup

}
