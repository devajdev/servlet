<%@ page language="java" import="java.util.*" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <b> from ex7.jsp</b> <br>
<c:url  var="googleUrl"  value="https://www.google.co.in/search?q=ameerpet" />

<a href="${googleUrl}"> go to Google</a>

 