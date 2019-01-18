<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
   //read form data
   String iname=request.getParameter("iname");
   float price=Float.parseFloat(request.getParameter("iprice"));
   float qty=Float.parseFloat(request.getParameter("iqty"));
  //calc bill Amount
   float billAmt=price*qty;
    if(billAmt<50000){ %>
      <h1 style="color:red;text-align:center">Bill Details (with out discount) </h1>
        item name:: <%=iname %> <br>
        item Price ::  <%=price %>  <br>
        item qty ::  <%=qty %> <br>
        Bill Amount :: <%=billAmt%> <br>
        <a href="input.html">home</a>
        <%}
        else{ %>
           <!-- forward request discount.jsp -->
           <jsp:forward page="discount.jsp">
               <jsp:param name="bAmt" value="<%=billAmt%>"/>
           </jsp:forward>
           <%} %>
        