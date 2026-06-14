/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limiclean.Clases;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author valer
 */
public class Venta {
    private int idVenta;
    private LocalDateTime fechaVenta;
    private double subTotal;
    private String estadoPago;
    private Cliente cliente;
    private ArrayList<DetalleVenta> detalles;
    private int contadorItem;
    
}
