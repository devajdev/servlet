<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<!-- establish the connection -->
<sql:setDataSource  var="ds"
                                     driver="oracle.jdbc.driver.OracleDriver"
                                     url="jdbc:oracle:thin:@localhost:1521:xe"
                                     user="system"
                                     password="manager"/>
<!-- Send and execute the SQL query -->
<sql:query var="rs" dataSource="${ds}" sql="SELECT * FROM EMP"/>

<!-- Process the ResultSet -->
<c:forEach var="row"  items="${rs.rows}" >
     ${row.empNo} &nbsp; &nbsp; &nbsp;  ${row.ename} &nbsp; &nbsp; &nbsp;  ${row.sal} <br> 
</c:forEach>
                                     

