 <b> From A.jsp</b>

<%
   //create diff scopes of attributes
    pageContext.setAttribute("attr1","val1");
    pageContext.setAttribute("attr2","val2",pageContext.REQUEST_SCOPE);
    pageContext.setAttribute("attr3","val3",pageContext.SESSION_SCOPE);
    pageContext.setAttribute("attr4","val4",pageContext.APPLICATION_SCOPE);
%>
<!--  forward request to B.jsp -->
  <jsp:forward page="B.jsp"/>
