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
public class ordenCompra {
    
    private int idOrdenCompra;
    private LocalDateTime fechOrden;
    private LocalDateTime fechEntrega;
    private String Observaciones;
    private LocalDateTime fechRecepcion;
    private Proveedor proveedor;
    
    public ordenCompra(int idOrdenCompra, String Observaciones, Proveedor proveedor)
    {
        this.idOrdenCompra = idOrdenCompra;
        this.Observaciones = Observaciones;
    }
    
    
}
