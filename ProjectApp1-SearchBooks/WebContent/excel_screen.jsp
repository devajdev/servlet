<%@ page language="java" contentType="application/vnd.ms-excel"
    pageEncoding="ISO-8859-1" import="java.util.*,com.nt.dto.BookDTO"%>


<h1 style="color:red;text-align:center"> Books results</h1>
<b> Books beloging to category::</b> <%=request.getParameter("category") %> <br>
<%
    //set content-disposition header value
    response.setHeader("Content-Disposition","attachment;fileName=catalog.xls");
 // read request attribute value 
   List<BookDTO> listDTO=(List<BookDTO>)request.getAttribute("searchResults");
   if(!listDTO.isEmpty()){ %>
      <table border="1"  bgcolor="cyan">
        <tr><th>Sno</th><th>BookId</th><th>BookName</th><th>Author</th><th>status</th><th>price </th> <th>category </th></tr>
       <%
           for(BookDTO dto:listDTO){ %>
            <tr>
              <td><%=dto.getSno() %> </td>
              <td><%=dto.getBookId() %> </td>
              <td><%=dto.getBookName() %> </td>
              <td><%=dto.getAuthor() %> </td>
              <td><%=dto.getStatus() %> </td>
              <td><%=dto.getPrice() %> </td>
              <td><%=dto.getCategory() %> </td>
             </tr>
          <% }//for
                   %>
      </table>
<%   
   }//if
   else{  %>
     <h1 style="color:red;text-align:center"> Books Not Found </h1>
  <% }//else
 %>
   
        
   



