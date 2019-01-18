<%@ page language="java" import="java.util.*" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:catch var="e">
	<jsp:scriptlet>
  
    java.util.Date d=null;
    d=new java.util.Date();
      out.println(d.getYear());
  
     
 </jsp:scriptlet>
 </c:catch>
	<c:if test="${!empty e}">
          Internal problem
     </c:if>


