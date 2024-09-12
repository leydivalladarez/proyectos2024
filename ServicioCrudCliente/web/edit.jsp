

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
        <div class="container mt-4 col-lg-4">
            <div class="card">
                <div class="card-header">
                    <h5>Actualizar Usuario</h5>                   
                </div>
                <%
                    int id = Integer.parseInt((String) request.getAttribute("iduser"));
                    UserService user = new UserService();
                    User u = user.listarID(id);
                %>
                <div class="card-body">
                    <form>
                        <label>Id</label>
                        <input type="text" name="txtid" readonly="" class="form-control" value="<%= u.getId() %>">
                        <label>Nombres</label>
                        <input type="text" name="txtnom" class="form-control" value="<%= u.getFname() %>">
                        <label>Apellidos</label>
                        <input type="text" name="txtape" class="form-control" value="<%= u.getLname() %>">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                        <a href="Controlador?accion=index">Regresar</a>
                    </form>
                </div>
            </div>
    </body>
</html>
