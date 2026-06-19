/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limiclean.Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class Funciones_BD {
    
public static void guardar_cliente_natural(Connection conexion,Natural n)
        
{

    String sqlCliente =
            "INSERT INTO Cliente " +
            "(nombCliente,direcCliente,telefCliente,corrCliente) " +
            "VALUES (?, ?, ?, ?)";

    try {

        // insertar cliente
        PreparedStatement psCliente =
                conexion.prepareStatement(
                        sqlCliente,
                        Statement.RETURN_GENERATED_KEYS
                );

        psCliente.setString(1, n.nombre);
        psCliente.setString(2, n.direccion);
        psCliente.setString(3, n.telefono);
        psCliente.setString(4, n.correo);

        psCliente.executeUpdate();

        //id generado de cliente
        ResultSet rs = psCliente.getGeneratedKeys();

        int idCliente = 0;

        if (rs.next()) {
            idCliente = rs.getInt(1);
        }

        // consulta insertar persona natural
        String sqlNatural =
                "INSERT INTO cNatural " +
                "(ID_Cliente, Apellidos, DNI) " +
                "VALUES (?, ?, ?)";

        PreparedStatement psNatural =
                conexion.prepareStatement(sqlNatural);

        psNatural.setInt(1, idCliente);
        psNatural.setString(2, n.apellido);
        psNatural.setString(3, n.dni);

        psNatural.executeUpdate();

        
        System.out.println("Guardado exitosamente");

    } catch (SQLException e) {

        System.out.println("Error al guardar");
        e.printStackTrace();
    }
}
public static void guardar_cliente_juridico(Connection conexion,Juridico j){
    String sqlCliente =
            "INSERT INTO cliente " +
            "(Nombre,Direccion,Correo,Telefono) " +
            "VALUES (?, ?, ?, ?)";

    try {

        // INSERT CLIENTE
        PreparedStatement psCliente =
                conexion.prepareStatement(
                        sqlCliente,
                        Statement.RETURN_GENERATED_KEYS
                );

        psCliente.setString(1, j.nombre);
        psCliente.setString(2, j.direccion);
        psCliente.setString(3, j.correo);
        psCliente.setString(4, j.telefono);

        psCliente.executeUpdate();

        // id generado de cliente
        ResultSet rs = psCliente.getGeneratedKeys();

        int idCliente = 0;

        if (rs.next()) {
            idCliente = rs.getInt(1);
        }

        // insertar tabla natural
        String sqlJuridico =
                "INSERT INTO juridico " +
                "(ID_Cliente, RUC, Estado,RazonSocial) " +
                "VALUES (?, ?, ?, ?)";

        PreparedStatement psJuridico =
                conexion.prepareStatement(sqlJuridico);

        psJuridico.setInt(1, idCliente);
        psJuridico.setString(2, j.ruc);
        psJuridico.setString(3, null);
        psJuridico.setString(4,j.razonSocial);

        psJuridico.executeUpdate();

        
        System.out.println("Guardado exitosamente");

    } catch (SQLException e) {

        System.out.println("Error al guardar");
        e.printStackTrace();
    }
}
public static String listarClientes_bd(Connection conexion) {

    StringBuilder sb = new StringBuilder();

    String sql =
            "SELECT c.ID_Cliente, c.Nombre, c.Direccion, " +
            "c.Correo, c.Telefono, " +
            "n.DNI, n.Apellidos, j.RazonSocial, j.RUC " +
            "FROM cliente c " +
            "LEFT JOIN p_natural n " +
            "ON c.ID_Cliente = n.ID_Cliente "+
            "LEFT JOIN juridico j "+
            "on c.ID_Cliente = j.ID_Cliente ";

    try {

        PreparedStatement ps =
                conexion.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while(rs.next()) {
            if(rs.getString("DNI") != null) {
                
                sb.append("Tipo: Natural\n");

                sb.append("Nombre: ")
                  .append(rs.getString("Nombre"))
                  .append("\n");

                sb.append("Apellidos: ")
                  .append(rs.getString("Apellidos"))
                  .append("\n");

                sb.append("DNI: ")
                  .append(rs.getString("DNI"))
                   .append("\n");

                sb.append("Direccion: ")
                      .append(rs.getString("Direccion"))
                      .append("\n");

                sb.append("Correo: ")
                      .append(rs.getString("Correo"))
                      .append("\n");

                sb.append("Telefono: ")
                      .append(rs.getString("Telefono"))
                      .append("\n");
            } else {
                sb.append("Tipo: Juridico\n");

                sb.append("Nombre: ")
                  .append(rs.getString("Nombre"))
                  .append("\n");

                sb.append("Direccion: ")
                  .append(rs.getString("Direccion"))
                  .append("\n");

                sb.append("Correo: ")
                  .append(rs.getString("Correo"))
                  .append("\n");

                sb.append("Telefono: ")
                  .append(rs.getString("Telefono"))
                  .append("\n");

                sb.append("RUC: ")
                  .append(rs.getString("RUC"))
                  .append("\n");

                sb.append("Razon Social: ")
                  .append(rs.getString("RazonSocial"))
                  .append("\n");
            }

            sb.append("-------------------\n");
           }
            } catch (Exception e) {

                e.printStackTrace();
            }

            return sb.toString();
}
public static String Buscar(Connection conexion,String dato){
        StringBuilder sb = new StringBuilder();
        
        String sql =
        "SELECT c.ID_Cliente, c.Nombre, c.Direccion, " +
        "c.Correo, c.Telefono, " +
        "n.DNI, n.Apellidos, " +
        "j.RUC, j.RazonSocial " +
        "FROM cliente c " +

        "LEFT JOIN p_natural n " +
        "ON c.ID_Cliente = n.ID_Cliente " +

        "LEFT JOIN juridico j " +
        "ON c.ID_Cliente = j.ID_Cliente " +
        "WHERE n.DNI = ? OR j.RUC = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, dato);
            ps.setString(2, dato);
            
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                if(rs.getString("DNI") != null) {
                sb.append("-------------------\n");
                sb.append("Tipo: Natural\n");

                sb.append("Nombre: ")
                  .append(rs.getString("Nombre"))
                  .append("\n");

                sb.append("Apellidos: ")
                  .append(rs.getString("Apellidos"))
                  .append("\n");

                sb.append("DNI: ")
                  .append(rs.getString("DNI"))
                   .append("\n");

                sb.append("Direccion: ")
                      .append(rs.getString("Direccion"))
                      .append("\n");

                sb.append("Correo: ")
                      .append(rs.getString("Correo"))
                      .append("\n");

                sb.append("Telefono: ")
                      .append(rs.getString("Telefono"))
                      .append("\n");
                sb.append("-------------------\n");
            } else {
                sb.append("-------------------\n");
                sb.append("Tipo: Juridico\n");

                sb.append("Nombre: ")
                  .append(rs.getString("Nombre"))
                  .append("\n");

                sb.append("Direccion: ")
                  .append(rs.getString("Direccion"))
                  .append("\n");

                sb.append("Correo: ")
                  .append(rs.getString("Correo"))
                  .append("\n");

                sb.append("Telefono: ")
                  .append(rs.getString("Telefono"))
                  .append("\n");

                sb.append("RUC: ")
                  .append(rs.getString("RUC"))
                  .append("\n");

                sb.append("Razon Social: ")
                  .append(rs.getString("RazonSocial"))
                  .append("\n");
                sb.append("-------------------\n");
            }
           }
            else{
                sb.append("Cliente no encontrado");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
}
public static void eliminarCliente(Connection conexion,String dato) throws SQLException{
    String sqlBuscar =
                "SELECT c.ID_Cliente, n.DNI, j.RUC " +
                "FROM cliente c " +

                "LEFT JOIN p_natural n " +
                "ON c.ID_Cliente = n.ID_Cliente " +

                "LEFT JOIN juridico j " +
                "ON c.ID_Cliente = j.ID_Cliente " +

                "WHERE n.DNI = ? OR j.RUC = ?";
    PreparedStatement psbuscar = conexion.prepareStatement(sqlBuscar);
    psbuscar.setString(1, dato);
    psbuscar.setString(2, dato);
    
    ResultSet rs = psbuscar.executeQuery();
    
    if(rs.next()){
        //retorna el id
        int Cliente_id=rs.getInt("ID_Cliente");
        System.out.println(Cliente_id);
        //verificacion en base si tiene dni o ruc
        if(rs.getString("DNI")!=null){
            String sqlNatural =
                        "DELETE FROM p_natural " +
                        "WHERE ID_Cliente = ?";
            PreparedStatement psNatural = conexion.prepareStatement(sqlNatural);
            psNatural.setInt(1, Cliente_id);
            
            psNatural.executeUpdate();
        } 
        else {
            //elimina de la tabla juridico 
                String sqlJuridico =
                        "DELETE FROM juridico " +
                        "WHERE ID_Cliente = ?";

                PreparedStatement psJuridico =
                        conexion.prepareStatement(sqlJuridico);

                psJuridico.setInt(1, Cliente_id);

                psJuridico.executeUpdate();
            }
        
        String sqlCliente =
                    "DELETE FROM cliente " +
                    "WHERE ID_Cliente = ?";

            PreparedStatement psCliente =
                    conexion.prepareStatement(sqlCliente);

            psCliente.setInt(1, Cliente_id);

            psCliente.executeUpdate();

            System.out.println(
                    "Cliente eliminado correctamente"
            );

        } else {

            System.out.println(
                    "Cliente no encontrado"
            );
        }
        
    }
}



