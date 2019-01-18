<%@ page language="java" import="java.util.*" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="color:red;text-align:center">Traditional For loop </h1>
<c:forEach var="i" begin="1" end="10" step="1">
            2 *  ${i} = ${2*i} <br>
</c:forEach>    
 <hr>
<h1 style="color:red;text-align:center">Enhanced  For loop </h1>
<jsp:scriptlet>
    String courses[]=new String[]{"java",".net","php","phyton"};
    request.setAttribute("crsList",courses);
</jsp:scriptlet>
 <c:forEach var="course"  items="${crsList}">
        ${course}
 </c:forEach>
 
 <h1 style="color:red;text-align:center">Enhanced  For loop </h1>
<jsp:scriptlet>
  <![CDATA[
    List<String> names=new ArrayList();
    names.add("raja");names.add("rani");names.add("jani");names.add("phani");
    request.setAttribute("namesList",names);
    ]]>
</jsp:scriptlet>
 <c:forEach var="nam"  items="${namesList}">
        ${nam}
 </c:forEach>
 

