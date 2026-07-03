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
     public final String ruc;
    public String razonSocial;
    public String Estado;
    
    public Juridico(int idCliente, String nombre, String direccion, String correo, String telefono, String ruc, String razonSocial,String Estado)
    {
        super(idCliente, nombre, direccion, correo, telefono);
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.Estado= Estado;
    }
}
