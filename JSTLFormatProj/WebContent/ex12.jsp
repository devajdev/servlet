<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:setLocale value="fr-FR"/>
<!-- format the number -->
<fmt:formatNumber  var="fprice"  type="currency" currencySymbol="USD" value="400000"/>
formatted number is :: ${fprice} 

<!--  format the date -->
<jsp:useBean id="dt"  class="java.util.Date"/>
<fmt:formatDate var="fdt" value="${dt}"  pattern="dd-MMM-yyyy"/>
formatted date ::  ${fdt}

<!-- format messages -->
<fmt:setBundle basename="com/nt/commons/App"/>

<fmt:message var="fmsg"  key="wish.msg"/>
Formatted message= ${fmsg}





