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
public class OrdenLavado {
    private int idOrdenLavado;
    private LocalDateTime fechOrdenLavado;
    private double costoLavado;
    private LocalDateTime fechEntregaEstimada;
    private double descOrdenLavado;
    private LocalDateTime fechEntregaReal;
    private String notasOrdenLavado;
    private char estadoPago;
    private Cliente cliente;
    
    public OrdenLavado(int idOrdenLavado, double costoLavado, double descOrdenLavado, String notasOrdenLavado, char estadoPago, Cliente cliente)
    {
        this.idOrdenLavado = idOrdenLavado;
        this.costoLavado = costoLavado;
        this.descOrdenLavado = descOrdenLavado;
        this.notasOrdenLavado = notasOrdenLavado;
        this.estadoPago = estadoPago;
    }
}
