<%-- 
    Document   : index
    Created on : 04/01/2024, 15:23:56
    Author     : gamert
--%>

<%@page import="java.util.List"%>
<%@page import="webservice.User"%>
<%@page import="Modelo.UserService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container mt-4">
            <div class="card">
                <div class="card-header">
                    <a href="Controlador?accion=add" class="btn btn-primary">Nuevo Usuario</a>                    
                </div>
                <div class="card-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>NOMBRES</th>
                                <th>APELLIDOS</th>
                                <th>ACCIONES</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                UserService user = new UserService();                                
                                List<User> datos=user.listar();
                                for (User u:datos) {
                             %>
                            <tr>
                                <td><%= u.getId() %></td>
                                <td><%= u.getFname() %></td>
                                <td><%= u.getLname() %></td>
                                <td>
                                    <a href="Controlador?accion=editar&id=<%= u.getId() %>" class="btn btn-warning">Edit</a>
                                    <a href="Controlador?accion=eliminar&id=<%= u.getId() %>" class="btn btn-danger">Delete</a>
                                </td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
    </body>
</html>
