<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

  <c:set var="msg"  value="hello,how are u?"/>
  
  length :: ${fn:length(msg)} <br>
  Touppercase ::${fn:toUpperCase(msg)} <br>
  To lowercase ::${fn:toLowerCase(msg)}
  
  
  

