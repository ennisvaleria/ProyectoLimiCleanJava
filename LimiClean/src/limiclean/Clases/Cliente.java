/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limiclean.Clases;

/**
 *
 * @author valer
 */
public abstract class Cliente {
    private int idCliente;
    private String nombre;
    private String direccion;
    private String correo;
    private String telefono;
    
    public Cliente(int idCliente, String nombre, String direccion, String correo, String telefono)
    {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }
}
