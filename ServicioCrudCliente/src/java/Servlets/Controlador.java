/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelo.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gamert
 */
public class Controlador extends HttpServlet {

    String add = "add.jsp";
    String edit = "edit.jsp";
    String index = "index.jsp";
    String acceso="";
    UserService user = new UserService();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion=request.getParameter("accion");
        if(accion.equals("add")){
            acceso=add;
        }else if(accion.equals("Guardar")){
            String nom=request.getParameter("txtnom");
            String ape=request.getParameter("txtape");
            user.agregar(nom, ape);
            acceso=index;
        }
        else if(accion.equals("editar")){
            acceso=edit;
            request.setAttribute("iduser", request.getParameter("id"));
        }else if(accion.equals("Actualizar")){
            String nom=request.getParameter("txtnom");
            String ape=request.getParameter("txtape");
            int id = Integer.parseInt(request.getParameter("txtid"));
            user.actualizar(id, nom, ape);
            acceso=index;
        }else if(accion.equals("eliminar")){
            int id = Integer.parseInt(request.getParameter("id"));
            user.eliminar(id);
            acceso=index;
        }else{
            acceso=index;
        }
        RequestDispatcher dispatcher=request.getRequestDispatcher(acceso);
        dispatcher.forward(request, response);
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

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
