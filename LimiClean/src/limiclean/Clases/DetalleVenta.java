/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limiclean.Clases;

/**
 *
 * @author valer
 */
public class DetalleVenta {
    private int idDetalleVenta;
    private int cantidad;
    private double precioUnitario;
    private double subTotal;
    private Venta venta;
    private Producto producto;
    
    public DetalleVenta(int idDetalleVenta, int cantidad,
            Venta venta, Producto producto)
    {
        this.idDetalleVenta = idDetalleVenta;
        this.cantidad = cantidad;
        this.venta = venta;
        this.producto = producto;
    }
}
