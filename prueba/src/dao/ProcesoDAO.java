
package dao;

import db.DataBaseConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ProcesoDAO {
    public boolean insertaProceso(String nombre, String tiempo){
    String sql="Insert into concurrencia (tiempo, nombre_proceso) values (?,?)";
       try (Connection conn = DataBaseConection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, tiempo);
            pstmt.setString(2, nombre);
            pstmt.executeUpdate();
            System.out.println("Proceso insertado exitosamente!");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar proceso: " + e.getMessage());
            return false;
        }
    }
    
}
