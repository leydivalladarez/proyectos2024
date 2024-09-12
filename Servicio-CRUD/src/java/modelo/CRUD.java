/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.List;

/**
 *
 * @author gamert
 */
public interface CRUD {
    public List listar();
    public User listarID(int id);
    public String add(String nombre, String ape);
    public String edit(int id, String nombre, String ape);
    public User delete(int id);
}
