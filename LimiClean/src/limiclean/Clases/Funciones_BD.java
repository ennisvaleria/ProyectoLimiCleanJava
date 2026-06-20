/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limiclean.Clases;

import java.security.MessageDigest;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Funciones_BD {
    
    public static String validacion_login(Connection conexion, String usuario) {

        String sql = "SELECT password FROM usuario WHERE email = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, usuario);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("password");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error al validar login: " + e.getMessage());
        }

        return null;
    }

public static int guardar_cliente_natural(Connection conexion, String[] datos) {

    try {

        String nombre = datos[0];
        String apellido = datos[1];

        if (datos[2] == null || datos[2].trim().isEmpty()) {
            throw new IllegalArgumentException("Teléfono vacío");
        }

        if (datos[3] == null || datos[3].trim().isEmpty()) {
            throw new IllegalArgumentException("DNI vacío");
        }

        int telefono = Integer.parseInt(datos[2]);
        String dni = datos[3];

        String correo = datos[4];
        String direccion = datos[5];

        String sqlCliente =
            "INSERT INTO Cliente (nombCliente, direcCliente, telefCliente, corrCliente) VALUES (?, ?, ?, ?)";

        PreparedStatement psCliente =
            conexion.prepareStatement(sqlCliente, Statement.RETURN_GENERATED_KEYS);

        psCliente.setString(1, nombre);
        psCliente.setString(2, direccion);
        psCliente.setInt(3, telefono);
        psCliente.setString(4, correo);

        int filas = psCliente.executeUpdate();

        if (filas == 0) {
            throw new SQLException("No se insertó Cliente");
        }

        ResultSet rs = psCliente.getGeneratedKeys();

        int idCliente = 0;

        if (rs.next()) {
            idCliente = rs.getInt(1);
        } else {
            throw new SQLException("No se generó ID de Cliente");
        }

        String sqlNatural =
            "INSERT INTO cNatural (idCliente, apellido, DNI) VALUES (?, ?, ?)";

        PreparedStatement psNatural =
            conexion.prepareStatement(sqlNatural);

        psNatural.setInt(1, idCliente);
        psNatural.setString(2, apellido);
        psNatural.setString(3, dni);

        psNatural.executeUpdate();

        JOptionPane.showMessageDialog(null, "Guardado exitosamente");

        return idCliente;

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error en número: DNI o teléfono inválido");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error SQL: " + e.getMessage());
        e.printStackTrace();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error general: " + e.getMessage());
        e.printStackTrace();
    }

    return -1;
}
public static int guardar_cliente_juridico(Connection conexion, String[] datos) {

    try {

        String nombre = datos[0];
        String direccion = datos[1];
        String correo = datos[2];

        if (datos[3] == null || datos[3].trim().isEmpty()) {
            throw new IllegalArgumentException("Teléfono vacío");
        }
        int telefono = Integer.parseInt(datos[3]);

        if (datos[4] == null || datos[4].trim().isEmpty()) {
            throw new IllegalArgumentException("RUC vacío");
        }
        String ruc = datos[4];

        String razonSocial = datos[5];

        String estado = datos[6];

        
        String sqlCliente =
            "INSERT INTO cliente (Nombre, Direccion, Correo, Telefono) VALUES (?, ?, ?, ?)";

        PreparedStatement psCliente =
            conexion.prepareStatement(sqlCliente, Statement.RETURN_GENERATED_KEYS);

        psCliente.setString(1, nombre);
        psCliente.setString(2, direccion);
        psCliente.setString(3, correo);
        psCliente.setInt(4, telefono);

        int filas = psCliente.executeUpdate();

        if (filas == 0) {
            throw new SQLException("No se insertó Cliente");
        }

        ResultSet rs = psCliente.getGeneratedKeys();

        int idCliente = 0;

        if (rs.next()) {
            idCliente = rs.getInt(1);
        } else {
            throw new SQLException("No se generó ID de Cliente");
        }

        
        String sqlJuridico =
            "INSERT INTO cJuridico (idCliente, ruc, estado, razonSocial) VALUES (?, ?, ?, ?)";

        PreparedStatement psJuridico =
            conexion.prepareStatement(sqlJuridico);

        psJuridico.setInt(1, idCliente);
        psJuridico.setString(2, ruc);
        psJuridico.setString(3, estado);
        psJuridico.setString(4, razonSocial);

        psJuridico.executeUpdate();

        JOptionPane.showMessageDialog(null, "Guardado exitosamente");

        return idCliente;

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error en número: Teléfono inválido");

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error SQL: " + e.getMessage());
        e.printStackTrace();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error general: " + e.getMessage());
        e.printStackTrace();
    }

    return -1;
}
public static boolean guardarOrdenLavado(
        Connection conexion,
        Timestamp fechOrdenLavado,
        double costLavado,
        Timestamp fechEntregaEstimada,
        double descOrdenLavado,
        Timestamp fechEntregaReal,
        String notasOrdenLavado,
        char estadoPago,
        int idCliente
) {

    String sql = "INSERT INTO ordenLavado " +
            "(fechOrdenLavado, costLavado, fechEntregaEstimada, descOrdenLavado, " +
            "fechEntregaReal, notasOrdenLavado, estadoPago, idCliente) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement ps = conexion.prepareStatement(sql)) {

        try {
            ps.setTimestamp(1, fechOrdenLavado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en fechOrdenLavado:\n" + e.getMessage());
            return false;
        }

        try {
            ps.setDouble(2, costLavado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en costLavado:\n" + e.getMessage());
            return false;
        }

        try {
            ps.setTimestamp(3, fechEntregaEstimada);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en fechEntregaEstimada:\n" + e.getMessage());
            return false;
        }

        try {
            ps.setDouble(4, descOrdenLavado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en descuento:\n" + e.getMessage());
            return false;
        }

        try {
            if (fechEntregaReal == null) {
                ps.setNull(5, java.sql.Types.TIMESTAMP);
            } else {
                ps.setTimestamp(5, fechEntregaReal);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en fechEntregaReal:\n" + e.getMessage());
            return false;
        }

        try {
            ps.setString(6, notasOrdenLavado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en notas:\n" + e.getMessage());
            return false;
        }

        try {
            ps.setString(7, String.valueOf(estadoPago));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en estadoPago:\n" + e.getMessage());
            return false;
        }

        try {
            ps.setInt(8, idCliente);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en idCliente:\n" + e.getMessage());
            return false;
        }

        try {
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "✔ Orden de lavado guardada correctamente");
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR EN INSERT:\n" + e.getMessage());
            return false;
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "ERROR GENERAL:\n" + e.getMessage());
        return false;
    }
}


public static void cargar_combo(
        Connection conexion,
            JComboBox<String> combo,
        String tabla,
        String columna
) {

    String sql = "SELECT " + columna + " FROM " + tabla;

    try {

        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        combo.removeAllItems();

        while (rs.next()) {
            combo.addItem(rs.getString(columna));
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cargar combo: " + e.getMessage());
    }
}

public static String[] obtenerTipoLavado(
        Connection conexion,
        String nombreTipo
) {

    String sql =
        "SELECT nombTipo, tiempoEstimado, precBase, descripcion " +
        "FROM tipoLavado " +
        "WHERE nombTipo = ?";

    try {

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, nombreTipo);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            return new String[] {
                rs.getString("nombTipo"),
                rs.getString("tiempoEstimado"),
                rs.getString("precBase"),
                rs.getString("descripcion")
            };
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
            null,
            "Error al obtener tipo de lavado: " + e.getMessage()
        );

        e.printStackTrace();
    }

    return null;
}
public static List<Object[]> listarOrdenes(Connection conexion) {

    List<Object[]> lista = new ArrayList<>();

    String sql = """
        SELECT 
            ol.idOrdenLavado,
            cn.DNI,
            cj.ruc,
            c.nombCliente,
            ol.notasOrdenLavado,
            ol.fechOrdenLavado,
            ol.fechEntregaEstimada,
            ol.costLavado,
            ol.descOrdenLavado,
            ol.estadoPago
        FROM ordenLavado ol
        INNER JOIN Cliente c
            ON ol.idCliente = c.idCliente
        LEFT JOIN cNatural cn
            ON c.idCliente = cn.idCliente
        LEFT JOIN cJuridico cj
            ON c.idCliente = cj.idCliente
        """;

    try (PreparedStatement ps = conexion.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            Object[] fila = new Object[10];

            fila[0] = rs.getInt("idOrdenLavado");
            fila[1] = rs.getString("DNI");
            fila[2] = rs.getString("ruc");
            fila[3] = rs.getString("nombCliente");
            fila[4] = rs.getString("notasOrdenLavado");
            fila[5] = rs.getTimestamp("fechOrdenLavado");
            fila[6] = rs.getTimestamp("fechEntregaEstimada");
            fila[7] = rs.getDouble("costLavado");
            fila[8] = rs.getObject("descOrdenLavado");
            fila[9] = rs.getString("estadoPago");

            lista.add(fila);
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
                null,
                "Error al listar órdenes: " + e.getMessage()
        );
    }

    return lista;
}
public static List<Object[]> BuscarDni(Connection conexion, String documento) {

    List<Object[]> lista = new ArrayList<>();

    String sql;

    //  decidir si es DNI o RUC
    if (documento.length() <= 8) {

        sql = """
            SELECT 
                ol.idOrdenLavado,
                cn.DNI,
                cj.ruc,
                c.nombCliente,
                ol.notasOrdenLavado,
                ol.fechOrdenLavado,
                ol.fechEntregaEstimada,
                ol.costLavado,
                ol.descOrdenLavado,
                ol.estadoPago
            FROM ordenLavado ol
            INNER JOIN Cliente c
                ON ol.idCliente = c.idCliente
            LEFT JOIN cNatural cn
                ON c.idCliente = cn.idCliente
            LEFT JOIN cJuridico cj
                ON c.idCliente = cj.idCliente
            WHERE cn.DNI = ?
        """;

    } else {

        sql = """
            SELECT 
                ol.idOrdenLavado,
                cn.DNI,
                cj.ruc,
                c.nombCliente,
                ol.notasOrdenLavado,
                ol.fechOrdenLavado,
                ol.fechEntregaEstimada,
                ol.costLavado,
                ol.descOrdenLavado,
                ol.estadoPago
            FROM ordenLavado ol
            INNER JOIN Cliente c
                ON ol.idCliente = c.idCliente
            LEFT JOIN cNatural cn
                ON c.idCliente = cn.idCliente
            LEFT JOIN cJuridico cj
                ON c.idCliente = cj.idCliente
            WHERE cj.ruc = ?
        """;
    }

    try (PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setString(1, documento);

        try (ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Object[] fila = new Object[10];

                fila[0] = rs.getInt("idOrdenLavado");
                fila[1] = rs.getString("DNI");
                fila[2] = rs.getString("ruc");
                fila[3] = rs.getString("nombCliente");
                fila[4] = rs.getString("notasOrdenLavado");
                fila[5] = rs.getTimestamp("fechOrdenLavado");
                fila[6] = rs.getTimestamp("fechEntregaEstimada");
                fila[7] = rs.getDouble("costLavado");
                fila[8] = rs.getObject("descOrdenLavado");
                fila[9] = rs.getString("estadoPago");

                lista.add(fila);
            }
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
                null,
                "Error al buscar órdenes: " + e.getMessage()
        );
    }

    return lista;
}
public static boolean guardarCalzado(
            Connection conexion,
            String nombCalzado,
            String descCalzado,
            double precReferencia,
            int idTipoCalzado,
            int idMaterial,
            int idMarca
    ) {

        String sql = "INSERT INTO Calzado " +
                "(nombCalzado, descCalzado, precReferencia, idTipoCalzado, idMaterial, idMarca) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, nombCalzado);

            if (descCalzado == null || descCalzado.trim().isEmpty()) {
                ps.setNull(2, java.sql.Types.LONGVARCHAR);
            } else {
                ps.setString(2, descCalzado);
            }

            ps.setDouble(3, precReferencia);
            ps.setInt(4, idTipoCalzado);
            ps.setInt(5, idMaterial);
            ps.setInt(6, idMarca);

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al guardar calzado: " + e.getMessage());
            return false;
        }
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

    public static void guardarOrdenLavado(Connection obtenerConexion, jdk.jfr.Timestamp fechOrdenLavado, double parseDouble, jdk.jfr.Timestamp fechEntregaEstimada, double parseDouble0, jdk.jfr.Timestamp fechEntregaReal, String text, char estadoPago, int idcliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


