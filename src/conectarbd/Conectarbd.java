/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conectarbd;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian Sanchez
 */
public class Conectarbd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        base();
    }

    public static void base() {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            // Establecemos la conexión con la base de datos.
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "root", "");
            
            // Preparamos la consulta
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("select * from persona");
            
            // Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla.
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDate(3));
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conectarbd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
