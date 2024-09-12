<%-- 
    Document   : jspejemplo
 
   Created on : 18 ene 2024, 18:19:55
    Author     : gamert
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loging</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        hoy es:
        <% 
            string hoy = LocalDate.now() .toString();
         %>
         <%=hoy%>
         <br><!-- comment -->
         El Parametro Nombre es;
         <%=request.getParameter("nombre")%>
         
    </body>
</html>
