<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>    
<!-- declare a variable having scope -->
<c:set var="msg"  value="welcome"  scope="request"/><br>
    
<!-- display variable value -->
value ::<c:out  value="${msg}"/><br>

<!-- remove variable from the scope -->
<c:remove var="msg"  scope="request"/><br>

<!-- display variable value -->
value ::<c:out  value="${msg}"/><br>


    