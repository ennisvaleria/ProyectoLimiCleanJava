/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limiclean.Clases;

/**
 *
 * @author valer
 */
public class Calzado {
    private int idCalzado;
    private String nombCalzado;
    private String descCalzado;
    private double precReferencia;
    private TipoCalzado tipoCalzado;
    private Material material;
    private Marca marca;
    
    public Calzado(int idCalzado, String nombCalzado, String descCalzado, double precReferencia, TipoCalzado tipoCalzado, Material material, Marca marca)
    {
        this.idCalzado = idCalzado;
        this.nombCalzado = nombCalzado;
        this.descCalzado = descCalzado;
        this.precReferencia = precReferencia;
    }
}
