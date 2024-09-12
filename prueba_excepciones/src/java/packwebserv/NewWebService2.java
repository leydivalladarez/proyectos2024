/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/EjbWebService.java to edit this template
 */
package packwebserv;

import jakarta.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
//import javax.ejb.Stateless;

/**
 *
 * @author gamert
 */
@WebService(serviceName = "NewWebService2")
@Stateless()
public class NewWebService2 {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "hola")
    public String hola(@WebParam(name = "txt") final String txt) {
        //TODO write your implementation code here:
        return null;
    }

}
