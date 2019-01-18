
<%
  //read request params(form data)  and also read additional params (<jsp:param>)
   String iname=request.getParameter("iname");
    float price=Float.parseFloat(request.getParameter("iprice"));
    float qty=Float.parseFloat(request.getParameter("iqty"));
    float billAmt=Float.parseFloat(request.getParameter("bAmt"));
    //calculate discount amount
    float discount=billAmt*0.2f;
    float finalAmount=billAmt-discount;
 %>

<h1 style="color:red;text-align:center"> Bill Details (With Discount) </h1>
 Item name :: <%=iname %> <br>
 Item price :: <%=price %> <br>
 Item quantity :: <%=qty %> <br>
 Bill Amount :: <%=billAmt %> <br>
 Discount Amount:: <%=discount %> <br>
 Final Amount ::  <%=finalAmount %> <br>
 <a href="input.html">home</a>
 
