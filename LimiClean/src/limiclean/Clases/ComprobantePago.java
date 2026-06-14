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
public class ComprobantePago {
    private int idComprobantePago;
    private String numeroComprobante;
    private double subTotal;
    private double costoTotal;
    private double descuento;
    private LocalDateTime fechaEmision;
    private Venta venta;
    private TipoComprobante tipoComprobante;
    
    public ComprobantePago(int idComprobantePago, String numeroComprobante,
            double descuento, Venta venta, TipoComprobante tipoComprobante)
    {
        this.idComprobantePago = idComprobantePago;
        this.numeroComprobante = numeroComprobante;
        this.descuento = descuento;
        this.fechaEmision = LocalDateTime.now();
        this.venta = venta;
        this.tipoComprobante = tipoComprobante;
    }
}
