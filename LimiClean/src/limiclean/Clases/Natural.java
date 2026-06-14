/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limiclean.Clases;

/**
 *
 * @author valer
 */
public class Natural extends Cliente {
    private final String dni;
    private String apellido;
    
    public Natural(int idCliente, String nombre, String direccion, String correo, String telefono,
            String dni, String apellido)
    {
        super(idCliente, nombre, direccion, correo, telefono);
        this.dni= dni;
        this.apellido = apellido;
    }
}
