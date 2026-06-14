/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limiclean.Clases;

/**
 *
 * @author valer
 */
public class Juridico extends Cliente{
     private final String ruc;
    private String razonSocial;
    
    public Juridico(int idCliente, String nombre, String direccion, String correo, String telefono, String ruc, String razonSocial)
    {
        super(idCliente, nombre, direccion, correo, telefono);
        this.ruc = ruc;
        this.razonSocial = razonSocial;
    }
}
