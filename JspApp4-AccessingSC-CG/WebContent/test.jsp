
<%!  public void jspInit(){
    ServletConfig cg=null;
    ServletContext sc=null;
     //access ServletConfig obj
     cg=getServletConfig();
     sc=getServletContext();
     
      System.out.println("cg obj class name::"+cg.getClass());
      System.out.println("sc obj class name::"+sc.getClass());
      System.out.println("dbuser context param value::"+sc.getInitParameter("dbuser"));
      System.out.println("email init param value::"+cg.getInitParameter("email"));
 }
  %>
    request obj  class name :: <%=request.getClass() %> <br>
    repsonse obj class name :: <%=response.getClass() %>  <br>
    out obj class name ::  <%=out.getClass() %>
   hello  