/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limiclean.Clases;

/**
 *
 * @author valer
 */
public class proveedorNatural extends Proveedor{
    private final String DNI;
    private String Apellido;
    public proveedorNatural(int idProveedor, String nombProveedor, String direcProveedor, String telefProveedor, String corrProveedor, String DNI, String Apellido) {
        super(idProveedor, nombProveedor, direcProveedor, telefProveedor, corrProveedor);
        this.DNI = DNI;
        this.Apellido = Apellido;
    }
    
}
 