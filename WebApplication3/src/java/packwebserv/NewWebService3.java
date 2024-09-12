/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packwebserv;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author gamert
 */
@WebService(serviceName = "NewWebService3")
public class NewWebService3 {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) throws Excepcion_nueva {
        if (txt == null) {
            throw new Excepcion_nueva();
        } else {
            return "Sin error " + txt + " !";
        }
    }
}
