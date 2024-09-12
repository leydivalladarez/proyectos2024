/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_servlet_n_capas;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.math.BigDecimal;
import javax.persistence.Query;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servlet_n_capas", urlPatterns = {"/servlet_n_capas"})
public class servlet_n_capas extends HttpServlet {

    String ls_mensaje = "";
    negocio_articulo ncli = new negocio_articulo();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String is_pantalla = "";
        ls_mensaje = "";
        String is_boton = "";
        Integer ls_codigo = 0;
        String ls_nombre = "";
        String ls_descripcion = "";
        BigDecimal ls_precio = new BigDecimal(0);
        is_boton = request.getParameter("boton");
        if(!request.getParameter("codigo").equals("")){
            ls_codigo = new Integer(request.getParameter("codigo"));
        } 
        ls_nombre = request.getParameter("nombre");
        ls_descripcion = request.getParameter("descripcion");
        if(!request.getParameter("precio").equals("")){
            ls_precio = new BigDecimal(request.getParameter("precio"));
        }        
        if (is_boton == null || is_boton == "") {
            is_pantalla = desplegar_pantalla("", "", "", new BigDecimal(0));
        }
        if (is_boton != null && is_boton != "") {
            if (is_boton.equals("Insertar")) {
                if (ncli.insertar(ls_codigo, ls_nombre, ls_descripcion, ls_precio) == 1) {
                    ls_mensaje = "Se insertó";
                } else {
                    ls_mensaje = "No se pudo insertar";
                }
                is_pantalla = desplegar_pantalla("", "", "", new BigDecimal(0));
                is_pantalla += ls_mensaje;
            }
            if (is_boton.equals("Eliminar")) {
                if (ncli.eliminar(ls_codigo) == 1) {
                    ls_mensaje = "Se eliminó";
                } else {
                    ls_mensaje = "No se pudo eliminar";
                }
                is_pantalla = desplegar_pantalla("", "", "", new BigDecimal(0));
                is_pantalla += ls_mensaje;
            }
            if (is_boton.equals("Modificar")) {
                if (ncli.modificar(ls_codigo, ls_nombre, ls_descripcion, ls_precio) == 1) {
                    ls_mensaje = "Se modificó";
                } else {
                    ls_mensaje = "No se pudo modificar";
                }
                is_pantalla = desplegar_pantalla("", "", "", new BigDecimal(0));
                is_pantalla += ls_mensaje;
            }
            if (is_boton.equals("Buscar")) {
                ls_nombre = ncli.buscar(ls_codigo);
                if (ls_nombre != null) {
                    ls_mensaje = "Se encontró";
                } else {
                    ls_mensaje = "No se encontró";
                }
                is_pantalla = desplegar_pantalla(ls_codigo.toString(), ls_nombre, ls_descripcion, ls_precio);
                is_pantalla += ls_mensaje;
            }
        }
        out.println(is_pantalla);
    }

    public String desplegar_pantalla(String as_codigo, String as_nombre, String as_descripcion, BigDecimal as_precio) {
        String ls_pantalla = "";
        ls_pantalla += "<html>";
        ls_pantalla += "<head>";
        ls_pantalla += "</head>";
        ls_pantalla += "<body>";
        ls_pantalla += "<h2>SERVLETS - Leydi Valladarez </h2>";
        ls_pantalla += "<form action='servlet_n_capas' method='post'>";
        ls_pantalla += "Codigo:<input type='text' name='codigo'" + " value='" + as_codigo
                + "'></input>";
        ls_pantalla += "<br>";
        ls_pantalla += "Nombre:<input type='text' name='nombre'" +
        "value ='"+as_nombre+"' > </input>";
        ls_pantalla += "<br>";
        ls_pantalla += "Descripcion:<input type='text' name='descripcion'" +
        "value ='"+as_descripcion+"' > </input>";
        ls_pantalla += "<br>";
        ls_pantalla += "Precio:<input type='text' name='precio'" +
        "value ='"+as_precio+"' > </input>";
        ls_pantalla += "<br>";
        ls_pantalla += "<input type='submit' value='Insertar' name='boton'></input>";
        ls_pantalla += "<input type='submit' value='Eliminar' name='boton' ></input>";
        ls_pantalla += "<input type='submit' value='Modificar' name='boton'></input>";
        ls_pantalla += "<input type='submit' value='Buscar' name='boton'></input>";
        ls_pantalla += "</form>";
        ls_pantalla += "</body>";
        ls_pantalla += "</html>";
        return ls_pantalla;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
