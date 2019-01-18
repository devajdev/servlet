<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- create or Locate java bean class object -->
<jsp:useBean id="dto"  class="com.nt.dto.EmployeeDTO" scope="request"/>

<!-- Write form data to bean properties -->
<jsp:setProperty name="dto"  property="*"/>

<!-- create or locate Service class object -->
<jsp:useBean id="empService"  class="com.nt.service.EmployeePayslipServiceImpl" scope="application" type="com.nt.service.EmployeePaySlipService"/>

<!--  invoke the method -->
<%
     empService.generatePayslip(dto);
 %>
 <!-- display PaySlip -->
   <h1 style="color:red;text-align:center"> Pay Slip Details </h1>
   Employee number:: <jsp:getProperty name="dto"  property="eno"/> <br>
   Employee name:: <jsp:getProperty name="dto"  property="ename"/> <br>
   Employee salary:: <jsp:getProperty name="dto"  property="salary"/> <br>
   Employee address:: <jsp:getProperty name="dto"  property="addrs"/> <br>
   Gross salary:: <jsp:getProperty name="dto"  property="grossSalary"/> <br>
   Net salary:: <jsp:getProperty name="dto"  property="netSalary"/> <br>
   
