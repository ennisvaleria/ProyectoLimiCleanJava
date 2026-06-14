/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limiclean.Clases;

/**
 *
 * @author valer
 */
public class Insumo {
    private int idInsumo;
    private String nombInsumo;
    private String descInsumo;
    private String unidadMedida;
    private int stockMin;
    private int codInsumo;
    private CategoriaInsumo categoriaInsumo;
    
    public Insumo(int idInsumo, String nombInsumo, String descInsumo, String unidadMedida, int stockMin, int codInsumo, CategoriaInsumo categoriaInsumo)
    {
        this.idInsumo = idInsumo;
        this.nombInsumo = nombInsumo;
        this.descInsumo = descInsumo;
        this.unidadMedida = unidadMedida;
        this.stockMin = stockMin;
        this.codInsumo = codInsumo;
    }
    
}
