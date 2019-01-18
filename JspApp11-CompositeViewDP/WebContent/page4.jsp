
<table border="1"  width="100%"  height="100%" rows="3" cols="3">
  <tr height="20%">
     <td colspan="3"> <jsp:include page="/headurl"/></td>
 </tr>     

<tr height="70%">
  <td width="25%"><%@include file="left_content.html" %> </td>
  <td width="60%"><jsp:include page="bollywood.jsp"/>  </td>
  <td width="15%">
      <table rows="2" cols="1">
         <tr>
           <td><jsp:include page="weather.jsp"/></td>
         </tr>
         <tr>
            <td><jsp:include page="horoscope.jsp"/></td>
         </tr>
      
      </table>
  </td>
</tr>


<tr height="10%">
     <td colspan="3"> <%@include file="footer.html" %></td>
   </tr>     


</table>