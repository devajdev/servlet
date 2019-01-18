<%@ page language="java" import="java.util.*" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="wishMessage"  value="hello dear ,how are u?any how u will be fine?" scope="application"/>

<c:forTokens var="word" items="${wishMessage}"  delims="a">
          ${word} <br>
</c:forTokens>


