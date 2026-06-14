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
public class pagoCompra {
    private int idPagoCompra;
    private LocalDateTime fechPago;
    private double monto;
    private char estadoPago;
    private MetodoPago metodoPago;
    private ordenCompra ordenCompra;
    
    public pagoCompra(int idPagoCompra, double monto, char estadoPago, MetodoPago metodoPago, ordenCompra ordenCompra)
    {
        this.idPagoCompra = idPagoCompra;
        this.monto = monto;
        this.estadoPago = estadoPago;
    }
}
