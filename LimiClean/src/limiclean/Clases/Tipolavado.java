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
public class Tipolavado {
    private int idTipoLavado;
    private String nombTipo;
    private LocalDateTime tiempoEstimado;
    private double precBase;
    private String descripcion;
    
    
    public Tipolavado(int idTipoLavado, String nombTipo, double precBase, String descripcion)
    {
        this.idTipoLavado = idTipoLavado;
        this.nombTipo = nombTipo;
        this.precBase = precBase;
        this.descripcion = descripcion;
    }
}
