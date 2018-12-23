<%-- 
    Document   : LogOut
    Created on : Dec 18, 2018, 5:31:42 AM
    Author     : gohnem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <%
      session.invalidate();
      RequestDispatcher dispatcher=request.getRequestDispatcher("LogIn.jsp");
      dispatcher.forward(request, response);
      
      
      
      
      
      
      %>
    </body>
</html>
