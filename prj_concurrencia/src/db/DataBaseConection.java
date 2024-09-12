
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConection {
    
    private static final String URL="jdbc:mysql://localhost:3306/taller1";
    private static final String USER="root";
    private static final String PASSWORD="";
    
    public static Connection getConnection(){
        Connection connection=null;
        try{
             Class.forName("com.mysql.jdbc.Driver");
             connection=DriverManager.getConnection(URL, USER, PASSWORD);
             System.out.println("Conexion exitosa");
             
        
        } catch (ClassNotFoundException e){
            System.out.println("Error al cargar drive: " + e.getMessage());
        } catch (SQLException e){
            System.out.println("Error al establecer conexion: " + e.getMessage());
        }
        
        return connection;
    }
    
    public static void main(String[] args){
        Connection conn= DataBaseConection.getConnection();
        
        if (conn== null){
            try{
                conn.close();
            } catch (SQLException e){
                System.out.println("Erros al cerrar la conexion: " + e.getMessage());
            }
        }
    }
    
}
