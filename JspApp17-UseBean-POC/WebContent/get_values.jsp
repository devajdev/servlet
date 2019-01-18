<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- create or locate Bean class object -->
<jsp:useBean id="st"  class="com.nt.beans.StudentBean" scope="session"/>

<!-- read and display bean properties values -->
sno == <jsp:getProperty name="st"  property="sno"/> <br>
sname == <jsp:getProperty name="st"  property="sname"/> <br>
result == <jsp:getProperty name="st"  property="result"/> <br>
