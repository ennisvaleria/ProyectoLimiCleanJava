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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author user
 */
public class Funciones_BD {
   //Funciones Genericas
public static int obtenerId(
        Connection conexion,
        String columnaId,
        String tabla,
        String columnaCondicion,
        String valor
) {

    String sql = "SELECT " + columnaId +
                 " FROM " + tabla +
                 " WHERE " + columnaCondicion + " = ?";

    try (PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setString(1, valor);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt(columnaId);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return -1;
}
   public static int insertarGenerico(
        Connection conexion,
        String tabla,
        String columnas,
        String valores,
        Object... params
) {

    String sql = "INSERT INTO " + tabla +
                 " (" + columnas + ") VALUES (" + valores + ")";

    try (PreparedStatement ps = conexion.prepareStatement(
            sql,
            Statement.RETURN_GENERATED_KEYS)) {

        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }

        int filas = ps.executeUpdate();

        if (filas > 0) {

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1); // ID generado
            }
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al insertar: " + e.getMessage()
        );

        e.printStackTrace();
    }

    return -1;

}
   public static String obtenerUltimoValorBoletaoFactura(
        Connection conexion,
        String columnaRetorno,
        String tabla,
        String columnaWhere,
        Object valorWhere,
        String columnaOrden
) {

    String sql =
            "SELECT " + columnaRetorno +
            " FROM " + tabla +
            " WHERE " + columnaWhere + " = ?" +
            " ORDER BY " + columnaOrden + " DESC LIMIT 1";

    try (PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setObject(1, valorWhere);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getString(columnaRetorno);
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al obtener último valor: " + e.getMessage()
        );

        e.printStackTrace();
    }

    return "";
}
   public static String obtenerUltimoValor(
        Connection conexion,
        String tabla,
        String columna,
        String columnaOrden
) {

    String sql =
        "SELECT " + columna +
        " FROM " + tabla +
        " ORDER BY " + columnaOrden + " DESC " +
        "LIMIT 1";

    try {

        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getString(columna);
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al obtener el último valor: " + e.getMessage()
        );

        e.printStackTrace();
    }

    return null;
}
//Fin Generico
public static int insertarProveedor(
        Connection conexion,
        String nombre,
        String direccion,
        String telefono,
        String correo
) {

    String sql =
        "INSERT INTO Proveedor " +
        "(nomProveedor, direcProveedor, telefProveedor, corrProveedor) " +
        "VALUES (?, ?, ?, ?)";

    try (PreparedStatement ps = conexion.prepareStatement(
            sql,
            Statement.RETURN_GENERATED_KEYS)) {

        ps.setString(1, nombre);
        ps.setString(2, direccion);
        ps.setString(3, telefono);
        ps.setString(4, correo);

        int filas = ps.executeUpdate();

        if (filas > 0) {

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al registrar proveedor: " + e.getMessage()
        );

        e.printStackTrace();
    }

    return -1;
}
public static boolean guardar_proveedor_natural(
        Connection conexion,
        int idProveedor,
        Natural n
) {

    String sql =
        "INSERT INTO pNatural (idProveedor, DNI, apellido) " +
        "VALUES (?, ?, ?)";

    try (PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setInt(1, idProveedor);
        ps.setString(2, n.dni);
        ps.setString(3, n.apellido);

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al guardar proveedor natural: " + e.getMessage()
        );

        e.printStackTrace();
    }

    return false;
}
public static int guardar_cliente_natural(Connection conexion, Natural n) {
    int idCliente = 0;
    String sqlCliente =
            "INSERT INTO Cliente " +
            "(nombCliente, direcCliente, telefCliente, corrCliente) " +
            "VALUES (?, ?, ?, ?)";

    try {

        // Insertar cliente
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

        // Obtener ID generado
        ResultSet rs = psCliente.getGeneratedKeys();

        

        if (rs.next()) {
            idCliente = rs.getInt(1);
        }

        // Insertar cliente natural
        String sqlNatural =
                "INSERT INTO cNatural " +
                "(idCliente, apellido, DNI) " +
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
    return idCliente;
}
public static void cargarProveedores(
        Connection conexion,
        JComboBox<String> cbo
) {

    String sql =
        "SELECT p.idProveedor, " +
        "pn.apellido AS P, " +
        "pn.DNI AS I " +
        "FROM Proveedor p " +
        "INNER JOIN proveedorNatural pn " +
        "ON p.idProveedor = pn.idProveedor " +

        "UNION " +

        "SELECT p.idProveedor, " +
        "pj.razonSocial AS P, " +
        "pj.RUC AS I " +
        "FROM Proveedor p " +
        "INNER JOIN proveedorJuridico pj " +
        "ON p.idProveedor = pj.idProveedor";

    try {

        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        cbo.removeAllItems();

        while (rs.next()) {

            cbo.addItem(
                rs.getString("P") +
                " - " +
                rs.getString("I")
            );
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al cargar proveedores: " + e.getMessage()
        );

        e.printStackTrace();
    }
    
    
}public static String obtenerUltimoCodProducto(Connection conexion) {

    String sql =
        "SELECT codProducto " +
        "FROM Producto " +
        "ORDER BY idProducto DESC " +
        "LIMIT 1";

    try (PreparedStatement ps = conexion.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        if (rs.next()) {
            return rs.getString("codProducto");
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al obtener último código de producto: " + e.getMessage()
        );

        e.printStackTrace();
    }

    return null;
}
public static String generarNuevoLote(Connection conexion) {

    String sql =
        "SELECT loteCompra " +
        "FROM detalleCompra " +
        "ORDER BY idDetalleCompra DESC " +
        "LIMIT 1";

    try (PreparedStatement ps = conexion.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        if (rs.next()) {

            String ultimo = rs.getString("loteCompra"); // LOTE-2026-001

            String[] partes = ultimo.split("-");

            int numero = Integer.parseInt(partes[2]);

            int nuevo = numero + 1;

            return String.format("LOTE-%s-%03d", partes[1], nuevo);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    // si no hay registros
    return "LOTE-2026-001";
}
public static String obtenerUltimoCodInsumo(Connection conexion) {

    String sql =
        "SELECT codInsumo " +
        "FROM Insumo " +
        "ORDER BY idInsumo DESC " +
        "LIMIT 1";

    try (PreparedStatement ps = conexion.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        if (rs.next()) {
            return rs.getString("codInsumo");
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al obtener último código de insumo: " + e.getMessage()
        );

        e.printStackTrace();
    }

    return null;
}
public static int insertarOrdenLavado(
        Connection conexion,
        String fechOrdenLavado,
        double costLavado,
        String fechEntregaEstimada,
        double descOrdenLavado,
        String fechEntregaReal,
        String notasOrdenLavado,
        String estadoOrden,
        String estadoPago,
        int idCliente
) {

    String sql = "INSERT INTO ordenLavado (" +
            "fechOrdenLavado, costLavado, fechEntregaEstimada, " +
            "descOrdenLavado, fechEntregaReal, notasOrdenLavado, " +
            "estadoOrden, estadoPago, idCliente) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement ps = conexion.prepareStatement(sql,
            Statement.RETURN_GENERATED_KEYS)) {

        ps.setString(1, fechOrdenLavado);
        ps.setDouble(2, costLavado);
        ps.setString(3, fechEntregaEstimada);
        ps.setDouble(4, descOrdenLavado);
        ps.setString(5, fechEntregaReal);
        ps.setString(6, notasOrdenLavado);
        ps.setString(7, estadoOrden);
        ps.setString(8, estadoPago);
        ps.setInt(9, idCliente);

        int affectedRows = ps.executeUpdate();

        if (affectedRows > 0) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // idOrdenLavado generado
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return -1;
}
public static boolean insertarDetalleCompra(
        Connection conexion,
        Integer idProducto,
        Integer idInsumo,
        int idOrdenCompra,
        int cantCompra,
        double precCompra,
        String loteCompra,
        java.sql.Date fechVencimiento,
        String observaciones
) {

    String sql =
        "INSERT INTO detalleCompra (" +
        "idProducto, " +
        "idInsumo, " +
        "idOrdenCompra, " +
        "cantCompra, " +
        "precCompra, " +
        "loteCompra, " +
        "fechVencimiento, " +
        "observaciones" +
        ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (PreparedStatement ps = conexion.prepareStatement(sql)) {

        // Producto
        if (idProducto == null) {
            ps.setNull(1, java.sql.Types.INTEGER);
        } else {
            ps.setInt(1, idProducto);
        }

        // Insumo
        if (idInsumo == null) {
            ps.setNull(2, java.sql.Types.INTEGER);
        } else {
            ps.setInt(2, idInsumo);
        }

        ps.setInt(3, idOrdenCompra);
        ps.setDouble(4, cantCompra);
        ps.setDouble(5, precCompra);
        ps.setString(6, loteCompra);
        ps.setDate(7, fechVencimiento);
        ps.setString(8, observaciones);

        int filas = ps.executeUpdate();

        if (filas > 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "Detalle de compra registrado correctamente."
            );

            return true;
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al registrar detalle de compra: " + e.getMessage()
        );

        e.printStackTrace();
    }

    return false;
}
public static boolean insertarPagoCompra(
        Connection conexion,
        java.sql.Date fechPago,
        double monto,
        char estadoPago,
        String nombreMetodoPago,
        int idOrdenCompra
) {

    String sql =
        "INSERT INTO pagoCompra (" +
        "fechPago, monto, estadoPago, idMetodoPago, idOrdenCompra" +
        ") VALUES (?, ?, ?, (" +
        "SELECT idMetodoPago FROM metodoPago WHERE nombPago = ? LIMIT 1" +
        "), ?)";

    try (PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setDate(1, fechPago);
        ps.setDouble(2, monto);
        ps.setString(3, String.valueOf(estadoPago));
        ps.setString(4, nombreMetodoPago);
        ps.setInt(5, idOrdenCompra);

        int filas = ps.executeUpdate();

        if (filas > 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "Pago registrado correctamente."
            );

            return true;
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al registrar pago: " + e.getMessage()
        );

        e.printStackTrace();
    }

    return false;
}

public static int guardarOrdenCompra(
        Connection conexion,
        java.sql.Date fechOrden,
        java.sql.Date fechEntregaEsperada,
        String observaciones,
        java.sql.Date fechRecepcion,
        char estadOrden,
        int idProveedor
) {

    int idOrdenCompra = 0;

    String sql =
        "INSERT INTO ordenCompra (" +
        "fechOrden, " +
        "fechEntregaEsperada, " +
        "observaciones, " +
        "fechRecepcion, " +
        "estadOrden, " +
        "idProveedor" +
        ") VALUES (?, ?, ?, ?, ?, ?)";

    try (
        PreparedStatement ps = conexion.prepareStatement(
                sql,
                Statement.RETURN_GENERATED_KEYS
        )
    ) {

        ps.setDate(1, fechOrden);
        ps.setDate(2, fechEntregaEsperada);
        ps.setString(3, observaciones);
        ps.setDate(4, fechRecepcion);
        ps.setString(5, String.valueOf(estadOrden));
        ps.setInt(6, idProveedor);

        int filas = ps.executeUpdate();

        if (filas > 0) {

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                idOrdenCompra = rs.getInt(1);
            }

            JOptionPane.showMessageDialog(
                    null,
                    "Orden de compra registrada correctamente."
            );
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al registrar la orden de compra: "
                        + e.getMessage()
        );

        e.printStackTrace();
    }

    return idOrdenCompra;
}
public static int obtenerIdProveedor(
        Connection conexion,
        String documento
) {

    String sql =
        "SELECT p.idProveedor " +
        "FROM Proveedor p " +
        "LEFT JOIN proveedorNatural pn " +
        "ON p.idProveedor = pn.idProveedor " +
        "LEFT JOIN proveedorJuridico pj " +
        "ON p.idProveedor = pj.idProveedor " +
        "WHERE pn.DNI = ? OR pj.RUC = ?";

    try (
        PreparedStatement ps = conexion.prepareStatement(sql)
    ) {

        ps.setString(1, documento);
        ps.setString(2, documento);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt("idProveedor");
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al obtener proveedor: " + e.getMessage()
        );

        e.printStackTrace();
    }

    return -1;
}
public static void cargarProductosInsumos(
        Connection conexion,
        JComboBox<String> cbo
) {

    String sql =
        "SELECT nombProducto AS Nombre, " +
        "codProducto AS Codigo " +
        "FROM Producto " +
        "UNION " +
        "SELECT nombInsumo AS Nombre, " +
        "codInsumo AS Codigo " +
        "FROM Insumo";

    try {

        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        cbo.removeAllItems();

        while (rs.next()) {

            cbo.addItem(
                rs.getString("Nombre") +
                " - " +
                rs.getString("Codigo")
            );
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al cargar datos: " + e.getMessage()
        );

        e.printStackTrace();
    }
}
public static void cargarEmpleados(
        Connection conexion,
        JTable dgvEmpleados,
        String texto,
        String rol
) {

    String sql =
        "SELECT " +
        "rol, " +
        "nombEmpleado, " +
        "apellidoEmpleado, " +
        "usuario, " +
        "correoEmpleado, " +
        "direccionEmpleado " +
        "FROM Empleado " +
        "WHERE 1=1 ";

    boolean buscarTexto = texto != null && !texto.trim().isEmpty();

    boolean filtrarRol = rol != null
            && !rol.trim().isEmpty()
            && !rol.equalsIgnoreCase("Todos");

    if (buscarTexto) {
        sql += "AND (nombEmpleado LIKE ? OR usuario LIKE ?) ";
    }

    if (filtrarRol) {
        sql += "AND rol = ? ";
    }

    try {

        PreparedStatement ps = conexion.prepareStatement(sql);

        int indice = 1;

        if (buscarTexto) {
            ps.setString(indice++, "%" + texto + "%");
            ps.setString(indice++, "%" + texto + "%");
        }

        if (filtrarRol) {
            ps.setString(indice++, rol);
        }

        ResultSet rs = ps.executeQuery();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Rol");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Usuario");
        modelo.addColumn("Correo");
        modelo.addColumn("Dirección");

        while (rs.next()) {

            modelo.addRow(new Object[]{
                rs.getString("rol"),
                rs.getString("nombEmpleado"),
                rs.getString("apellidoEmpleado"),
                rs.getString("usuario"),
                rs.getString("correoEmpleado"),
                rs.getString("direccionEmpleado")
            });
        }

        dgvEmpleados.setModel(modelo);

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al cargar empleados: " + e.getMessage()
        );

        e.printStackTrace();
    }
}
public static void cargarDetalleVentas(
        Connection conexion,
        JTable dgvVentas,
        String documento
) {

    String sql =
        "SELECT " +
        "d.idVenta AS 'N°', " +
        "p.nombProducto AS Nombre, " +
        "p.codProducto AS Codigo, " +
        "d.cantVenta AS Cantidad, " +
        "p.precProducto AS Precio, " +
        "d.cantVenta * p.precProducto AS Total, " +
        "COALESCE(cn.apellido, cj.razonSocial) AS Cliente, " +
        "COALESCE(cn.DNI, cj.RUC) AS Documento, " +
        "v.estadoPago AS EstadoPago " +
        "FROM detalleVenta d " +
        "INNER JOIN Producto p ON d.idProducto = p.idProducto " +
        "INNER JOIN Venta v ON d.idVenta = v.idVenta " +
        "INNER JOIN Cliente c ON v.idCliente = c.idCliente " +
        "LEFT JOIN cNatural cn ON c.idCliente = cn.idCliente " +
        "LEFT JOIN cJuridico cj ON c.idCliente = cj.idCliente ";

    boolean filtrar = documento != null && !documento.trim().isEmpty();

    if (filtrar) {
        sql += " WHERE COALESCE(cn.DNI, cj.RUC) = ?";
    }

    try {

        PreparedStatement ps = conexion.prepareStatement(sql);

        if (filtrar) {
            ps.setString(1, documento);
        }

        ResultSet rs = ps.executeQuery();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("N°");
        modelo.addColumn("Nombre");
        modelo.addColumn("Código");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("Total");
        modelo.addColumn("Cliente");
        modelo.addColumn("Documento");
        modelo.addColumn("EstadoPago");

        while (rs.next()) {

            modelo.addRow(new Object[]{
                rs.getInt("N°"),
                rs.getString("Nombre"),
                rs.getString("Codigo"),
                rs.getInt("Cantidad"),
                rs.getDouble("Precio"),
                rs.getDouble("Total"),
                rs.getString("Cliente"),
                rs.getString("Documento"),
                rs.getString("EstadoPago")
            });
        }

        dgvVentas.setModel(modelo);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null,
                "Error al cargar ventas: " + e.getMessage());
        e.printStackTrace();
    }
}
public static int guardar_cliente_juridico(Connection conexion, Juridico j) {
    int idCliente = 0;
    String sqlCliente =
            "INSERT INTO Cliente " +
            "(nombCliente, direcCliente, telefCliente, corrCliente) " +
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
        psCliente.setString(3, j.telefono);
        psCliente.setString(4, j.correo);

        psCliente.executeUpdate();

        // Obtener ID generado
        ResultSet rs = psCliente.getGeneratedKeys();

        

        if (rs.next()) {
            idCliente = rs.getInt(1);
        }

        // INSERT CLIENTE JURIDICO
        String sqlJuridico =
                "INSERT INTO cJuridico " +
                "(idCliente, ruc, estado, razonSocial) " +
                "VALUES (?, ?, ?, ?)";

        PreparedStatement psJuridico =
                conexion.prepareStatement(sqlJuridico);

        psJuridico.setInt(1, idCliente);
        psJuridico.setString(2, j.ruc);
        psJuridico.setString(3, j.Estado); // o el estado que corresponda
        psJuridico.setString(4, j.razonSocial);

        psJuridico.executeUpdate();

        System.out.println("Guardado exitosamente");

    } catch (SQLException e) {

        System.out.println("Error al guardar");
        e.printStackTrace();
    }
    return idCliente;
}
public static void cargarInsumos(
        Connection conexion,
        JTable dgvInsumos
) {

    String sql =
        "SELECT " +
        "i.codInsumo, " +
        "i.nombInsumo, " +
        "c.nombCategoriaInsumo, " +
        "i.unidadMedida, " +
        "d.cantCompra AS stock, " +
        "i.stockMin, " +
        "i.descInsumo " +
        "FROM detalleCompra d " +
        "INNER JOIN Insumo i " +
        "ON d.idInsumo = i.idInsumo " +
        "INNER JOIN categoriaInsumo c " +
        "ON i.idCategoriaInsumo = c.idCategoriaInsumo";

    try {

        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Código");
        modelo.addColumn("Insumo");
        modelo.addColumn("Categoría");
        modelo.addColumn("Unidad");
        modelo.addColumn("Stock");
        modelo.addColumn("Stock Mínimo");
        modelo.addColumn("Descripción");

        while (rs.next()) {

            modelo.addRow(new Object[]{
                rs.getString("codInsumo"),
                rs.getString("nombInsumo"),
                rs.getString("nombCategoriaInsumo"),
                rs.getString("unidadMedida"),
                rs.getInt("stock"),
                rs.getInt("stockMin"),
                rs.getString("descInsumo")
            });
        }

        dgvInsumos.setModel(modelo);

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al cargar insumos: " + e.getMessage()
        );

        e.printStackTrace();
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

public static boolean insertarDato(
        Connection conexion,
        String tabla,
        String columna,
        String valor
) {

    String sql = "INSERT INTO " + tabla +
                 " (" + columna + ") VALUES (?)";

    try {

        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, valor);

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al insertar dato: " + e.getMessage()
        );

        e.printStackTrace();
        return false;
    }
}
public static void agregarDetalleProducto(
        Connection conexion,
        JTable tabla,
        int idProducto,
        int cantidad
) {

    String sql =
        "SELECT " +
        "p.idProducto, " +
        "p.nombProducto AS Nombre, " +
        "p.codProducto AS Codigo, " +
        "p.precProducto AS Precio " +
        "FROM Producto p " +
        "WHERE p.idProducto = ?";

    try (PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setInt(1, idProducto);

        ResultSet rs = ps.executeQuery();

        DefaultTableModel modelo =
                (DefaultTableModel) tabla.getModel();

        while (rs.next()) {

            modelo.addRow(new Object[]{
                rs.getInt("idProducto"),
                rs.getString("Nombre"),
                rs.getString("Codigo"),
                rs.getDouble("Precio"),
                cantidad
            });
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al agregar producto: " + e.getMessage()
        );

        e.printStackTrace();
    }
}
public static String[] obtenerDatosCalzado(
        Connection conexion,
        String nombreCalzado
) {

    String sql =
        "SELECT c.nombCalzado, " +
        "       c.descCalzado, " +
        "       c.precReferencia, " +
        "       tc.nombTipoCalzado AS Tipo, " +
        "       m.nombMarca AS Marca, " +
        "       mt.nombMaterial AS Material " +
        "FROM Calzado c " +
        "INNER JOIN tipoCalzado tc ON c.idTipoCalzado = tc.idTipoCalzado " +
        "INNER JOIN Marca m ON c.idMarca = m.idMarca " +
        "INNER JOIN Material mt ON c.idMaterial = mt.idMaterial " +
        "WHERE c.nombCalzado = ?";

    try {

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, nombreCalzado);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            return new String[] {
                rs.getString("nombCalzado"),
                rs.getString("descCalzado"),
                rs.getString("precReferencia"),
                rs.getString("Tipo"),
                rs.getString("Marca"),
                rs.getString("Material")
            };
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
            null,
            "Error al obtener datos del calzado: " + e.getMessage()
        );

        e.printStackTrace();
    }

    return null;
}

public static String[] obtenerTipoLavado(
        Connection conexion,
        String nombreTipo
){
    String sql=
    
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
public static void cargarTiposLavado(
        Connection conexion,
        JTable jtTiposLavado
) {

    String sql =
        "SELECT nombTipo, tiempoEstimado, precBase, descripcion " +
        "FROM tipoLavado";

    try {

        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Nombre");
        modelo.addColumn("Tiempo");
        modelo.addColumn("Precio");
        modelo.addColumn("Descripción");

        while (rs.next()) {

            modelo.addRow(new Object[]{
                rs.getString("nombTipo"),
                rs.getString("tiempoEstimado"),
                rs.getString("precBase"),
                rs.getString("descripcion")
            });
        }

        jtTiposLavado.setModel(modelo);

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al cargar tipos de lavado: " + e.getMessage()
        );

        e.printStackTrace();
    }
}
public static String[] buscarOrdenLavado(Connection Conexion ,int idOrdenLavado) {
    
    String[] datos = null;

    try {
        String sql = """
            SELECT 
                o.idOrdenLavado,
                c.nombCliente AS cliente,
                o.fechOrdenLavado,
                o.fechEntregaEstimada,
                o.descOrdenLavado,
                o.costLavado,
                o.estadoOrden,
                o.estadoPago,
                dt.fechInicio,
                dt.fechFinalizacion,
                o.notasOrdenLavado 
            FROM ordenLavado o
            INNER JOIN Cliente c
                ON o.idCliente = c.idCliente
            INNER JOIN detalleLavado dt
                ON o.idOrdenLavado = dt.idOrdenLavado
            WHERE o.idOrdenLavado = ?
            """;

        PreparedStatement ps = Conexion.prepareStatement(sql);
        ps.setInt(1, idOrdenLavado);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            datos = new String[]{
                rs.getString("idOrdenLavado"),
                rs.getString("cliente"),
                rs.getString("fechOrdenLavado"),
                rs.getString("fechEntregaEstimada"),
                rs.getString("descOrdenLavado"),
                rs.getString("costLavado"),
                rs.getString("estadoOrden"),
                rs.getString("estadoPago"),
                rs.getString("fechInicio"),
                rs.getString("fechFinalizacion"),
                rs.getString("notasOrdenLavado")
            };
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return datos;
}
public static int insertarEmpleado(
        Connection conexion,
        String rol,
        String nombre,
        String apellido,
        String usuario,
        String contrasena,
        String correo,
        String direccion,
        String telefono
) {

    String sql =
        "INSERT INTO Empleado (" +
        "rol, " +
        "nombEmpleado, " +
        "apellidoEmpleado, " +
        "usuario, " +
        "contrasena, " +
        "correoEmpleado, " +
        "direccionEmpleado, " +
        "telefonoEmpleado" +
        ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    try (
        PreparedStatement ps = conexion.prepareStatement(
            sql,
            Statement.RETURN_GENERATED_KEYS
        )
    ) {

        ps.setString(1, rol);
        ps.setString(2, nombre);
        ps.setString(3, apellido);
        ps.setString(4, usuario);
        ps.setString(5, contrasena);
        ps.setString(6, correo);
        ps.setString(7, direccion);
        ps.setString(8, telefono);

        int filas = ps.executeUpdate();

        if (filas > 0) {

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1); // idEmpleado generado
            }
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al registrar empleado: " + e.getMessage()
        );

        e.printStackTrace();
    }

    return -1;
}
public static boolean actualizarCampo(
        Connection conexion,
        String tabla,
        String columnaActualizar,
        Object nuevoValor,
        String columnaWhere,
        Object valorWhere
) {

    String sql = "UPDATE " + tabla +
                 " SET " + columnaActualizar + " = ?" +
                 " WHERE " + columnaWhere + " = ?";

    try (PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setObject(1, nuevoValor);
        ps.setObject(2, valorWhere);

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false;
}
public static void cargarCalzadoLavado(
        Connection conexion,
        JTable dgvDetalleLavado,
        int idOrdenLavado
) {
    String sql = "SELECT " +
        "ca.nombCalzado AS 'Nombre Calzado', " +
        "ca.precReferencia AS 'Precio Ref.', " +
        "tc.nombTipoCalzado AS 'Tipo Calzado', " +
        "m.nombMarca AS Marca, " +
        "ma.nombMaterial AS Material " +
        "FROM detalleLavado dl " +
        "INNER JOIN ordenLavado ol ON dl.idOrdenLavado = ol.idOrdenLavado " +
        "INNER JOIN Cliente c ON ol.idCliente = c.idCliente " +
        "INNER JOIN Calzado ca ON dl.idCalzado = ca.idCalzado " +
        "INNER JOIN Marca m ON ca.idMarca = m.idMarca " +
        "INNER JOIN tipoCalzado tc ON ca.idTipoCalzado = tc.idTipoCalzado " +
        "INNER JOIN Material ma ON ca.idMaterial = ma.idMaterial " +
        "WHERE dl.idOrdenLavado = ?"; // <-- filtro agregado

    try {
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idOrdenLavado);
        ResultSet rs = ps.executeQuery();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre Calzado");
        modelo.addColumn("Precio Ref.");
        modelo.addColumn("Tipo Calzado");
        modelo.addColumn("Marca");
        modelo.addColumn("Material");

        while (rs.next()) {
            modelo.addRow(new Object[]{
                rs.getString("Nombre Calzado"),
                rs.getDouble("Precio Ref."),
                rs.getString("Tipo Calzado"),
                rs.getString("Marca"),
                rs.getString("Material")
            });
        }

        dgvDetalleLavado.setModel(modelo);

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(
            null,
            "Error al cargar detalle de lavado: " + e.getMessage()
        );
        e.printStackTrace();
    }
}
public static void cargarOrdenes(
        Connection conexion,
            JTable dgvOrdenes
) {

    String sql =
        "SELECT " +
        "o.idOrdenLavado, " +
        "o.fechOrdenLavado, " +
        "c.nombCliente AS cliente, " +
        "o.fechEntregaEstimada, " +
        "o.costLavado, " +
        "o.estadoOrden, " +
        "o.estadoPago " +
        "FROM ordenLavado o " +
        "INNER JOIN Cliente c " +
        "ON o.idCliente = c.idCliente";

    try {

        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("N°");
        modelo.addColumn("Fecha Orden");
        modelo.addColumn("Cliente");
        modelo.addColumn("Entrega Est.");
        modelo.addColumn("Costo");
        modelo.addColumn("Estado Orden");
        modelo.addColumn("Estado Pago");

        while (rs.next()) {

            modelo.addRow(new Object[] {
                rs.getInt("idOrdenLavado"),
                rs.getString("fechOrdenLavado"),
                rs.getString("cliente"),
                rs.getString("fechEntregaEstimada"),
                rs.getDouble("costLavado"),
                rs.getString("estadoOrden"),
                rs.getString("estadoPago")
            });
        }

        dgvOrdenes.setModel(modelo);

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al cargar órdenes: " + e.getMessage()
        );

        e.printStackTrace();
    }
}

public static boolean insertarTipoLavado(
        Connection conexion,
        String nombTipo,
        String tiempoEstimado,
        double precBase,
        String descripcion
) {

    String sql =
        "INSERT INTO tipoLavado " +
        "(nombTipo, tiempoEstimado, precBase, descripcion) " +
        "VALUES (?, ?, ?, ?)";

    try {

        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, nombTipo);
        ps.setString(2, tiempoEstimado);
        ps.setDouble(3, precBase);
        ps.setString(4, descripcion);

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al registrar tipo de lavado: " + e.getMessage()
        );

        e.printStackTrace();
        return false;
    }
}
public static boolean insertarInsumo(
        Connection conexion,
        String nombInsumo,
        String descInsumo,
        String unidadMedida,
        int stockMin,
        String codInsumo,
        String nombreCategoria
) {

    String sql =
        "INSERT INTO Insumo (" +
        "nombInsumo, descInsumo, unidadMedida, stockMin, codInsumo, idCategoriaInsumo" +
        ") VALUES (?, ?, ?, ?, ?, (" +
        "SELECT idCategoriaInsumo " +
        "FROM categoriaInsumo " +
        "WHERE nombCategoriaInsumo = ?" +
        "))";

    try {

        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, nombInsumo);
        ps.setString(2, descInsumo);
        ps.setString(3, unidadMedida);
        ps.setInt(4, stockMin);
        ps.setString(5, codInsumo);
        ps.setString(6, nombreCategoria);

        int filas = ps.executeUpdate();

        if (filas > 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "Insumo registrado correctamente."
            );

            return true;
        }

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al registrar insumo: " + e.getMessage()
        );

        e.printStackTrace();
    }

    return false;
}
public static void cargarCompras(
        Connection conexion,
        JTable tabla,
        String documento
) {

    String sql =
        "SELECT * FROM (" +

        "SELECT " +
        "oc.idOrdenCompra AS Numero, " +
        "oc.fechOrden AS Fecha, " +
        "p.nombProducto AS Nombre, " +
        "p.codProducto AS Codigo, " +
        "dc.cantCompra AS Cantidad, " +
        "dc.precCompra AS PrecioCompra, " +
        "pc.monto AS Monto, " +
        "pc.estadoPago AS EstadoPago, " +
        "COALESCE(prn.apellido, prj.razonSocial) AS Proveedor, " +
        "COALESCE(prn.DNI, prj.RUC) AS Documento " +
        "FROM detalleCompra dc " +
        "INNER JOIN Producto p ON dc.idProducto = p.idProducto " +
        "INNER JOIN ordenCompra oc ON dc.idOrdenCompra = oc.idOrdenCompra " +
        "INNER JOIN pagoCompra pc ON pc.idOrdenCompra = oc.idOrdenCompra " +
        "INNER JOIN Proveedor pr ON oc.idProveedor = pr.idProveedor " +
        "LEFT JOIN proveedorNatural prn ON prn.idProveedor = pr.idProveedor " +
        "LEFT JOIN proveedorJuridico prj ON prj.idProveedor = pr.idProveedor " +

        "UNION " +

        "SELECT " +
        "oc.idOrdenCompra AS Numero, " +
        "oc.fechOrden AS Fecha, " +
        "i.nombInsumo AS Nombre, " +
        "i.codInsumo AS Codigo, " +
        "dc.cantCompra AS Cantidad, " +
        "dc.precCompra AS PrecioCompra, " +
        "pc.monto AS Monto, " +
        "pc.estadoPago AS EstadoPago, " +
        "COALESCE(prn.apellido, prj.razonSocial) AS Proveedor, " +
        "COALESCE(prn.DNI, prj.RUC) AS Documento " +
        "FROM detalleCompra dc " +
        "INNER JOIN Insumo i ON dc.idInsumo = i.idInsumo " +
        "INNER JOIN ordenCompra oc ON dc.idOrdenCompra = oc.idOrdenCompra " +
        "INNER JOIN pagoCompra pc ON pc.idOrdenCompra = oc.idOrdenCompra " +
        "INNER JOIN Proveedor pr ON oc.idProveedor = pr.idProveedor " +
        "LEFT JOIN proveedorNatural prn ON prn.idProveedor = pr.idProveedor " +
        "LEFT JOIN proveedorJuridico prj ON prj.idProveedor = pr.idProveedor " +

        ") t " +
        "WHERE (? = '' OR Documento LIKE ?) " +
        "ORDER BY Fecha DESC";

    try {

        PreparedStatement ps = conexion.prepareStatement(sql);

        ps.setString(1, documento);
        ps.setString(2, "%" + documento + "%");

        ResultSet rs = ps.executeQuery();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("N°");
        modelo.addColumn("Fecha");
        modelo.addColumn("Nombre");
        modelo.addColumn("Código");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio Compra");
        modelo.addColumn("Monto");
        modelo.addColumn("Estado Pago");
        modelo.addColumn("Proveedor");
        modelo.addColumn("Documento");

        while (rs.next()) {

            modelo.addRow(new Object[]{
                rs.getInt("Numero"),
                rs.getDate("Fecha"),
                rs.getString("Nombre"),
                rs.getString("Codigo"),
                rs.getDouble("Cantidad"),
                rs.getDouble("PrecioCompra"),
                rs.getDouble("Monto"),
                rs.getString("EstadoPago"),
                rs.getString("Proveedor"),
                rs.getString("Documento")
            });
        }

        tabla.setModel(modelo);

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al cargar compras: " + e.getMessage()
        );

        e.printStackTrace();
    }
}
public static void cargarProveedores_Filtro(
        Connection conexion,
        JTable tabla,
        String documento
) {

    String sql =
        "SELECT " +
        "t.Contacto, " +
        "t.Documento, " +
        "p.telefProveedor, " +
        "p.corrProveedor, " +
        "p.direcProveedor " +
        "FROM Proveedor p " +
        "INNER JOIN ( " +
        "SELECT prj.idProveedor, " +
        "prj.razonSocial AS Contacto, " +
        "prj.RUC AS Documento " +
        "FROM proveedorJuridico prj " +
        "UNION " +
        "SELECT prn.idProveedor, " +
        "prn.apellido AS Contacto, " +
        "prn.DNI AS Documento " +
        "FROM proveedorNatural prn " +
        ") t ON t.idProveedor = p.idProveedor " +
        "WHERE t.Documento LIKE ?";

    try {

        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setString(1, "%" + documento + "%");

        ResultSet rs = ps.executeQuery();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Contacto");
        modelo.addColumn("DNI/RUC");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Correo");
        modelo.addColumn("Dirección");

        while (rs.next()) {

            modelo.addRow(new Object[]{
                rs.getString("Contacto"),
                rs.getString("Documento"),
                rs.getString("telefProveedor"),
                rs.getString("corrProveedor"),
                rs.getString("direcProveedor")
            });
        }

        tabla.setModel(modelo);

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al cargar proveedores: " + e.getMessage()
        );

        e.printStackTrace();
    }
}

public static void cargarProductos(
        Connection conexion,
        JTable tabla,
        String texto
) {

    String sql =
        "SELECT " +
        "p.nombProducto AS Nombre, " +
        "p.codProducto AS Codigo, " +
        "p.precProducto AS Precio, " +
        "SUM(dc.cantCompra) AS Stock, " +
        "p.descProducto AS Descripcion " +
        "FROM detalleCompra dc " +
        "INNER JOIN Producto p " +
        "ON dc.idProducto = p.idProducto ";

    boolean filtrar = texto != null && !texto.trim().isEmpty();

    if (filtrar) {
        sql += "WHERE p.nombProducto LIKE ? OR p.codProducto LIKE ? ";
    }

    sql +=
        "GROUP BY " +
        "p.idProducto, " +
        "p.nombProducto, " +
        "p.codProducto, " +
        "p.precProducto, " +
        "p.descProducto";

    try {

        PreparedStatement ps = conexion.prepareStatement(sql);

        if (filtrar) {
            String like = "%" + texto + "%";
            ps.setString(1, like);
            ps.setString(2, like);
        }

        ResultSet rs = ps.executeQuery();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Nombre");
        modelo.addColumn("Código");
        modelo.addColumn("Precio");
        modelo.addColumn("Stock");
        modelo.addColumn("Descripción");

        while (rs.next()) {

            modelo.addRow(new Object[]{
                rs.getString("Nombre"),
                rs.getString("Codigo"),
                rs.getDouble("Precio"),
                rs.getDouble("Stock"),
                rs.getString("Descripcion")
            });
        }

        tabla.setModel(modelo);

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al cargar productos: " + e.getMessage()
        );

        e.printStackTrace();
    }
}

public static void cargarClientesJuridicos(
        Connection conexion,
        JTable dgvClientes
) {

    String sql =
        "SELECT " +
        "c.nombCliente AS contacto, " +
        "c.telefCliente AS numero, " +
        "j.razonSocial, " +
        "j.ruc, " +
        "c.direcCliente AS direccion, " +
        "j.estado " +
        "FROM Cliente c " +
        "INNER JOIN cJuridico j " +
        "ON c.idCliente = j.idCliente";

    try {

        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Contacto");
        modelo.addColumn("Número");
        modelo.addColumn("Razón Social");
        modelo.addColumn("RUC");
        modelo.addColumn("Dirección");
        modelo.addColumn("Estado");

        while (rs.next()) {

            modelo.addRow(new Object[]{
                rs.getString("contacto"),
                rs.getString("numero"),
                rs.getString("razonSocial"),
                rs.getString("ruc"),
                rs.getString("direccion"),
                rs.getString("estado")
            });
        }

        dgvClientes.setModel(modelo);

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al cargar clientes jurídicos: " + e.getMessage()
        );

        e.printStackTrace();
    }
}
public static void cargarClientesNaturales(
        Connection conexion,
        JTable dgvClientes
) {

    String sql =
        "SELECT " +
        "c.idCliente, " +
        "c.nombCliente AS nombre, " +
        "n.apellido, " +
        "n.DNI, " +
        "c.direcCliente AS direccion, " +
        "c.telefCliente AS telefono " +
        "FROM Cliente c " +
        "INNER JOIN cNatural n " +
        "ON c.idCliente = n.idCliente";

    try {

        PreparedStatement ps = conexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("DNI");
        modelo.addColumn("Dirección");
        modelo.addColumn("Teléfono");

        while (rs.next()) {

            modelo.addRow(new Object[]{
                rs.getInt("idCliente"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("DNI"),
                rs.getString("direccion"),
                rs.getString("telefono")
            });
        }

        dgvClientes.setModel(modelo);

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al cargar clientes naturales: " + e.getMessage()
        );

        e.printStackTrace();
    }
}
public static void buscarCliente(
        Connection conexion,
        String documento,
        JTable dgvClientes
) {

    String sql = "";

    if (documento.trim().isEmpty()) {

        sql =
            "SELECT " +
            "c.idCliente, " +
            "c.nombCliente AS nombre, " +
            "COALESCE(cn.apellido, cj.razonSocial) AS cliente, " +
            "COALESCE(cn.DNI, cj.RUC) AS documento, " +
            "c.direcCliente AS direccion, " +
            "c.telefCliente AS telefono " +
            "FROM Cliente c " +
            "LEFT JOIN cNatural cn ON c.idCliente = cn.idCliente " +
            "LEFT JOIN cJuridico cj ON c.idCliente = cj.idCliente";

    } else if (documento.length() == 8) {

        sql =
            "SELECT " +
            "c.idCliente, " +
            "c.nombCliente AS nombre, " +
            "n.apellido, " +
            "n.DNI, " +
            "c.direcCliente AS direccion, " +
            "c.telefCliente AS telefono " +
            "FROM Cliente c " +
            "INNER JOIN cNatural n " +
            "ON c.idCliente = n.idCliente " +
            "WHERE n.DNI = ?";

    } else if (documento.length() == 11) {

        sql =
            "SELECT " +
            "c.idCliente, " +
            "c.nombCliente AS contacto, " +
            "j.razonSocial, " +
            "j.RUC, " +
            "c.direcCliente AS direccion, " +
            "c.telefCliente AS telefono, " +
            "j.estado " +
            "FROM Cliente c " +
            "INNER JOIN cJuridico j " +
            "ON c.idCliente = j.idCliente " +
            "WHERE j.RUC = ?";

    } else {

        JOptionPane.showMessageDialog(
                null,
                "El documento debe tener 8 (DNI) o 11 (RUC) dígitos."
        );
        return;
    }

    try {

        PreparedStatement ps = conexion.prepareStatement(sql);

        if (!documento.trim().isEmpty()) {
            ps.setString(1, documento);
        }

        ResultSet rs = ps.executeQuery();

        DefaultTableModel modelo = new DefaultTableModel();

        if (documento.trim().isEmpty()) {

            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Cliente");
            modelo.addColumn("Documento");
            modelo.addColumn("Dirección");
            modelo.addColumn("Teléfono");

            while (rs.next()) {

                modelo.addRow(new Object[]{
                    rs.getInt("idCliente"),
                    rs.getString("nombre"),
                    rs.getString("cliente"),
                    rs.getString("documento"),
                    rs.getString("direccion"),
                    rs.getString("telefono")
                });
            }

        } else if (documento.length() == 8) {

            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("DNI");
            modelo.addColumn("Dirección");
            modelo.addColumn("Teléfono");

            while (rs.next()) {

                modelo.addRow(new Object[]{
                    rs.getInt("idCliente"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("DNI"),
                    rs.getString("direccion"),
                    rs.getString("telefono")
                });
            }

        } else {

            modelo.addColumn("ID");
            modelo.addColumn("Contacto");
            modelo.addColumn("Razón Social");
            modelo.addColumn("RUC");
            modelo.addColumn("Dirección");
            modelo.addColumn("Teléfono");
            modelo.addColumn("Estado");

            while (rs.next()) {

                modelo.addRow(new Object[]{
                    rs.getInt("idCliente"),
                    rs.getString("contacto"),
                    rs.getString("razonSocial"),
                    rs.getString("RUC"),
                    rs.getString("direccion"),
                    rs.getString("telefono"),
                    rs.getString("estado")
                });
            }
        }

        dgvClientes.setModel(modelo);

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al buscar cliente: " + e.getMessage()
        );

        e.printStackTrace();
    }
}
public static String[] buscarPorDNI(Connection conexion, String dni) {

    String[] datos = null;
    String sql = """
        SELECT 
            c.idCliente,
            c.nombCliente,
            n.apellido,
            n.DNI,
            c.direcCliente,
            c.telefCliente
        FROM Cliente c
        INNER JOIN cNatural n
            ON c.idCliente = n.idCliente
        WHERE n.DNI = ?
    """;

    try (PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setString(1, dni);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                datos = new String[]{
                    rs.getString("idCliente"),
                    rs.getString("nombCliente"),
                    rs.getString("apellido"),
                    rs.getString("DNI"),
                    rs.getString("direcCliente"),
                    rs.getString("telefCliente")
                };
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return datos;
}
public static String[] buscarPorRUC(Connection conexion, String ruc) {

    String[] datos = null;

    String sql = """
        SELECT 
            c.idCliente,
            c.nombCliente,
            c.direcCliente,
            c.telefCliente,
            c.corrCliente,
            j.RUC,
            j.razonSocial
        FROM Cliente c
        INNER JOIN cJuridico j
            ON c.idCliente = j.idCliente
        WHERE j.RUC = ?
    """;

    try (PreparedStatement ps = conexion.prepareStatement(sql)) {

        ps.setString(1, ruc);

        try (ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                datos = new String[]{
                    rs.getString("idCliente"),
                    rs.getString("nombCliente"),
                    rs.getString("direcCliente"),
                    rs.getString("telefCliente"),
                    rs.getString("corrCliente"),
                    rs.getString("RUC"),
                    rs.getString("razonSocial")
                };
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return datos;
}
public static void Filtro_ordenes_lavado(
        Connection conexion,
        JTable dgvOrdenes,
        String estado
) {

    String sql =
        "SELECT " +
        "o.idOrdenLavado, " +
        "o.fechOrdenLavado, " +
        "c.nombCliente AS cliente, " +
        "o.fechEntregaEstimada, " +
        "o.costLavado, " +
        "o.estadoOrden, " +
        "o.estadoPago " +
        "FROM ordenLavado o " +
        "INNER JOIN Cliente c " +
        "ON o.idCliente = c.idCliente ";

    boolean filtrar = estado != null && !estado.trim().isEmpty();

    if (filtrar) {
        sql += "WHERE o.idOrdenLavado LIKE ?";
    }

    try (PreparedStatement ps = conexion.prepareStatement(sql)) {

        if (filtrar) {
            ps.setString(1, "%" + estado + "%");
        }

        ResultSet rs = ps.executeQuery();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("N°");
        modelo.addColumn("Fecha Orden");
        modelo.addColumn("Cliente");
        modelo.addColumn("Entrega Est.");
        modelo.addColumn("Costo");
        modelo.addColumn("Estado Orden");
        modelo.addColumn("Estado Pago");

        while (rs.next()) {

            modelo.addRow(new Object[]{
                rs.getInt("idOrdenLavado"),
                rs.getString("fechOrdenLavado"),
                rs.getString("cliente"),
                rs.getString("fechEntregaEstimada"),
                rs.getDouble("costLavado"),
                rs.getString("estadoOrden"),
                rs.getString("estadoPago")
            });
        }

        dgvOrdenes.setModel(modelo);

    } catch (SQLException e) {

        JOptionPane.showMessageDialog(
                null,
                "Error al cargar órdenes: " + e.getMessage()
        );

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



