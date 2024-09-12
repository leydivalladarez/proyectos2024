/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package WebService;

import Modelo.User;
import Modelo.UserDAO;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author gamert
 */
@WebService(serviceName = "Servicios")
public class Servicios {

    UserDAO dao = new UserDAO();

    @WebMethod(operationName = "listar")
    public List<User> listar() {
        List datos = dao.listar();
        return datos;
    }

    @WebMethod(operationName = "agregar")
    public String agregar(@WebParam(name = "nombres") String nombres, @WebParam(name = "apellidos") String apellidos) {
        String datos = dao.add(nombres, apellidos);
        return datos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listarID")
    public User listarID(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        User user=dao.listarID(id);
        return user;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Actualizar")
    public String Actualizar(@WebParam(name = "id") int id, @WebParam(name = "nombres") String nombres, @WebParam(name = "apellidos") String apellidos) {
        //TODO write your implementation code here:
        String datos=dao.edit(id, nombres, apellidos);
        return datos;
    }

  
    @WebMethod(operationName = "Eliminar")
    public User Eliminar(@WebParam(name = "id") int id) {
        User u = dao.delete(id);
        return u;
    }
}
