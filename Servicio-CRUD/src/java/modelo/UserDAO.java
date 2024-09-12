/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gamert
 */
public class UserDAO implements CRUD {
    PreparedStatement ps;
        ResultSet rs;
        Connection con;
        Conexion conex = new Conexion();
        int res;
        String msj;
        User user=new User();
        
    @Override
    public List listar() {
        List<User> datos = new ArrayList<>();
        String sql = "select * from user";
        try {
            con = conex.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setFname(rs.getString("fname"));
                u.setLname(rs.getString("lname"));
                datos.add(u);
            }
        } catch (Exception e) {
        }
        return datos;
    }

    @Override
    public User listarID(int id) { 
        String sql="select * from user where id="+id;
        
            try{
                con = conex.getConnection();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    user.setId(rs.getInt("id"));
                    user.setFname(rs.getString("fname"));
                    user.setLname(rs.getString("lname"));
                }
            } catch (Exception e){
            }
            return user;         
    }

    @Override
    public String add(String nombre, String ape) {
        String sql="insert into user(fname,lname) values (?,?)";
        try {
            con=conex.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, ape);
            res=ps.executeUpdate();
            if(res==1){
                msj="Usuario Agregado";
            }else{
                msj = "Error";
            }
            
        } catch (Exception e) {
        }
        return msj;
    }

    @Override
    public String edit(int id, String nombre, String ape) {
        String sql="update user set fname=?, lname=? where id="+id;
        try {
            con=conex.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, ape);
            res=ps.executeUpdate();
            if(res==1){
                msj="Usuario actualizado...";
             }else {
                msj="Error";
            }
        }catch (Exception e) {
        }
        return msj;   
    }

    @Override
    public User delete(int id) {
        String sql="delete from user where id="+id;
            try{
                con=conex.getConnection();
                ps=con.prepareStatement(sql);
                ps.executeUpdate();
            }catch (SQLException e) {
            }
            return user;
    }
    
}
