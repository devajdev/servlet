

<%!  public  String generateWishMessage(String uname){
            java.util.Calendar cal=null;
           int hour=0;
          //get System Date
          cal=java.util.Calendar.getInstance();
          //get current month 
          hour=cal.get(java.util.Calendar.HOUR_OF_DAY);
          //generate wish message
          if(hour<12)
            return "Good Morning:::"+uname;
           else if(hour<16)
              return "Good AfterNoon:::"+uname;
           else if(hour<20)
              return "Good Evening :::"+uname;
            else
               return  "Good Night ::"+uname;              
   }//method
   %>
     <!-- <h1 style='color:red;text-align:center'>Welcome to jsp pages</h1>  <br> -->
     <h4>System date and Time :: <%=new java.util.Date() %> </h4><br>
     <%
         String user="raja";
      %>
      <b> Wish Message is ::</b>  <%-- <%=generateWishMessage(user) %> --%> 
      
      <br>
      <h2  style="color:red;text-align:center">End of jsp page</h2>
      
     