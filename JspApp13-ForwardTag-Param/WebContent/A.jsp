

<b> From A.jsp (start)</b> <br>
<%float price=900.6f; %>

<jsp:forward page="B.jsp">
    <jsp:param value="CRJ" name="bkName"/>
    <jsp:param value="<%=price %>" name="bkPrice"/>
</jsp:forward>

<b> From A.jsp (end)</b> <br>