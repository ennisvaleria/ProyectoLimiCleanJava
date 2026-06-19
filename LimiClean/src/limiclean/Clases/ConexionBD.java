/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limiclean.Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class ConexionBD {
    private static final String url = "jdbc:mysql://38.250.116.88:3306/LimiClean";
    private static final String user = "system";
    private static final String pass = "LimiClean123";
    
    public static Connection obtenerConexion() throws ClassNotFoundException{
        Connection conexion=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url,user,pass);
            System.out.println("Conexion exitosa");
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return conexion;
    }
    
}
