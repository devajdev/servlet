<%@ page import="java.sql.*,java.util.*"%>

<%!
   Connection con=null;
   PreparedStatement ps1=null,ps2=null;
   ResultSet rs=null;
  public  void jspInit(){
   ServletConfig cg=null;
   String driver=null,url=null,user=null,pwd=null;

   
    //get Access to ServletConfig object
    cg=getServletConfig();
    //read jdbc properties as init param values
    driver=cg.getInitParameter("driver");
    url=cg.getInitParameter("url");
    user=cg.getInitParameter("user");
    pwd=cg.getInitParameter("password");
    try{
       //register jdbc driver 
       Class.forName(driver);
       //establish the connection
       con=DriverManager.getConnection(url,user,pwd);
       //create PreparedStatement objs
       ps1=con.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?)");
       ps2=con.prepareStatement("SELECT SNO,SNAME,SADD FROM STUDENT");
       }//try
       catch(SQLException se){
       se.printStackTrace();
       }
       catch(Exception e){
              e.printStackTrace();
         }
    }//jspInit()
 %>
  <%
  //Ensure wheather submit button or hyperlink is clicked
     String  source=request.getParameter("s1");
     if(source.equalsIgnoreCase("register")) { //for submit
        //read form data
        int sno=Integer.parseInt(request.getParameter("sno"));
        String sname=request.getParameter("sname");
        String addrs=request.getParameter("sadd");
        //set form data to  SQL query param values
         ps1.setInt(1,sno);
         ps1.setString(2,sname);
         ps1.setString(3,addrs);
         //execute the Query
         int result=ps1.executeUpdate();
         //process the result
         if(result==0){ %>
              <h1 style="color:red;text-align:center"> Registration Failed </h1>
           <%}//if
           else{ %>
               <h1 style="color:red;text-align:center"> Registration Succeded </h1>
               <% }//else
             }//if
             else  {  //for hyperlink
               //execute Query
               rs=ps2.executeQuery(); %>
               <h1 style="color:red;text-align:center"> Student Details ares </h1>
                <table border="1">
              <%  
               //process the ResultSet
               while(rs.next()){ %>
                  <tr>
                  <td><%=rs.getInt(1) %></td>
                  <td> <%=rs.getString(2) %> </td>
                  <td> <%=rs.getString(3)%> </td>
                  </tr> 
           <%    } //while %>  
              </table>
          <%    }//else
              %>
              <a href="register.html">home</a>
      <%! public void jspDestroy(){
              //close jdbc objs
               try{
                 if(rs!=null)
                   rs.close();
               }
               catch(SQLException se){
                 se.printStackTrace();
               }
               
               try{
                 if(ps2!=null)
                   ps2.close();
               }
               catch(SQLException se){
                 se.printStackTrace();
               }
               
                  try{
                 if(ps1!=null)
                   ps1.close();
               }
               catch(SQLException se){
                 se.printStackTrace();
               }
               
              try{
                 if(con!=null)
                   con.close();
               }
               catch(SQLException se){
                 se.printStackTrace();
               }
       }//jspDestroy()
       %>              


