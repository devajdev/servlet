<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- create or locate Bean class object -->
<jsp:useBean id="st"  class="com.nt.beans.StudentBean" scope="session"/>

<!-- set values to bean properties -->
<%-- <jsp:setProperty name="st"  property="sno"  value="1001"/>
<jsp:setProperty name="st"  property="sname"  value="raja"/>
<jsp:setProperty name="st"  property="result"  value="pass"/> --%>

<%-- <jsp:setProperty name="st"  property="sno"  param="stno"/>
<jsp:setProperty name="st"  property="sname"  param="stname"/>
<jsp:setProperty name="st"  property="result"  param="stresult"/>
 --%>
 
 <jsp:setProperty name="st"  property="*"/>


<h1> values are set to bean properties</h1>
