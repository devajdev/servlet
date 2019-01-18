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
<sql:update var="count" dataSource="${ds}" sql="UPDATE STUDENT SET SNAME=?,SADD=? WHERE SNO=?">
          <sql:param>rupesh</sql:param>
          <sql:param value="delhi"/>
          <sql:param value="801"/>
</sql:update>

<!-- process the result -->
no.of records that are effected:: ${count}.

                                     

