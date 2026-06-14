/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limiclean.Clases;

/**
 *
 * @author valer
 */
public abstract class Proveedor {
    private int idProveedor;
    private String nombProveedor;
    private String direcProveedor;
    private String telefProveedor;
    private String corrProveedor;
    
    public Proveedor(int idProveedor, String nombProveedor, String direcProveedor, String telefProveedor, String corrProveedor)
    {
        this.idProveedor = idProveedor;
        this.nombProveedor = nombProveedor;
        this.direcProveedor = direcProveedor;
        this.corrProveedor = corrProveedor;
    }
    
}
