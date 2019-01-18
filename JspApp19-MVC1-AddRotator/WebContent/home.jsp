<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h1 style="color:red;text-align:center"> Add Roator app</h1>

<!--  create or locate bean class object-->
<jsp:useBean scope="application" id="rotator" class="com.nt.service.RotatorService"/>

<%
    rotator.nextAdd();
    response.setHeader("refresh","2");
 %>

<!-- Display add -->
<a href="<jsp:getProperty name="rotator"  property="link"/>">
          <img  src="<jsp:getProperty name="rotator"  property="image"/>">
</a>
