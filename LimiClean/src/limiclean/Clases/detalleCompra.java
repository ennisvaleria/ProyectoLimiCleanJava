/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limiclean.Clases;

import java.time.LocalDateTime;

/**
 *
 * @author valer
 */
public class detalleCompra {
    private Producto producto;
    private Insumo insumo;
    private ordenCompra ordenCompra;
    private double cantidad;
    private double precCompra;
    private String loteCompra;
    private LocalDateTime fechVencimiento;
    private String Observaciones;
    
    public detalleCompra(Producto producto, Insumo insumo, ordenCompra ordenCompra, double cantidad, double precCompra, String loteCompra, String Observaciones)
    {
        this.cantidad = cantidad;
        this.precCompra = precCompra;
        this.loteCompra = loteCompra;
        this.Observaciones = Observaciones;
    }
}
