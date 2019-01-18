<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

uname req param vlaue :: ${param.uname} <br>
hobies req param values ::${paramValues.hobies[0]} ,${paramValues.hobies[1]}<br>

user-agent req header value :: ${header['user-agent'] } <br>
accept req header values :: ${headerValues.accept[0] } <bR>

Cookie name that holds session id ::  ${cookie.JSESSIONID.name} <br>
Cookie value that holds session id ::  ${cookie.JSESSIONID.value} <br>

dbuser context param(global init param value) :: ${initParam.dbuser}


