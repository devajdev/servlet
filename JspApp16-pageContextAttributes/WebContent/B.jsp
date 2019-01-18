
<b> From B.jsp</b>
<br>
attr1(page) value ::  <%=pageContext.findAttribute("attr1") %>  <br>
attr2(req) value ::  <%=pageContext.findAttribute("attr2") %>  <br>
attr3(ses) value ::  <%=pageContext.findAttribute("attr3") %>  <br>
attr4(application) value ::  <%=pageContext.findAttribute("attr4") %>  <br>

<!-- forward request to C.jsp -->
<jsp:forward page="C.jsp"/>
 
