
<%
    //read form data
    String ss=request.getParameter("ss");
    //prepare url for google search engine
    String url="https://www.google.com/search?q="+ss;
    //perform sendRedirection
    response.sendRedirect(url);
    %>
   