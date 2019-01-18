<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.nt.dto.BookDTO" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    


<h1 style="color:red;text-align:center"> Books results</h1>
<b> Books beloging to category::</b> ${param.category} <br>
<c:choose>
  <c:when test="${!empty searchResults}">
      <table border="1"  bgcolor="cyan">
        <tr><th>Sno</th><th>BookId</th><th>BookName</th><th>Author</th><th>status</th><th>price </th> <th>category </th></tr>
    <c:forEach var="dto" items="${searchResults }">        
           <tr>
              <td>${dto.sno} </td>
              <td>${dto.bookId} </td>
              <td>${dto.bookName} </td>
              <td>${dto.author} </td>
              <td>${dto.status} </td>
              <td>${dto.price} </td>
              <td>${dto.category}</td>
             </tr>
      </c:forEach>          
      </table>
     </c:when>
      <c:otherwise>
            <h1 style="color:red">Books not found </h1>
      </c:otherwise>
</c:choose>     
   <br> <br>
   <h4><a href="search.html">home</a>&nbsp;&nbsp;&nbsp; <a href="JavaScript:doPrint()">print</a> </h4>
   <script language="JavaScript">
      function doPrint(){
         frames.focus();
         frames.print();
      }
   
   </script>
   
   
        
   



