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
public class detalleLavado {
    private OrdenLavado ordenLavado;
    private Calzado calzado;
    private Tipolavado tipoLavado;
    private String estadoEntrada;
    private String estadoSalida;
    private String Observaciones;
    private LocalDateTime fechInicio;
    private LocalDateTime fechFinalizacion;
    
    public detalleLavado(OrdenLavado ordenLavado, Calzado calzado, Tipolavado tipoLavado, String estadoEntrada, String estadoSalida, String Observaciones)
    {
        this.estadoEntrada = estadoEntrada;
        this.estadoSalida = estadoSalida;
        this.Observaciones = Observaciones;
    }
}
