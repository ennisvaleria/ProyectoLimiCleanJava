/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limiclean.Clases;

/**
 *
 * @author valer
 */
public class proveedorJuridio extends Proveedor{
    private final String ruc;
    private char estado;
    private String razonSocial;

    public proveedorJuridio(int idProveedor, String nombProveedor, String direcProveedor, String telefProveedor, String corrProveedor, String ruc, char estado, String razonSocial) {
        super(idProveedor, nombProveedor, direcProveedor, telefProveedor, corrProveedor);
        this.ruc = ruc;
        this.estado = estado;
        this.razonSocial = razonSocial;        
    }
    
}
