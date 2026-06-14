/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package limiclean.Clases;

import java.time.LocalDate;

/**
 *
 * @author valer
 */
public class Producto {
    private int idProducto;
    private String codigo;
    private int stock;
    private String nombre;
    private String descripcion;
    private LocalDate fechaIngreso;
    private double precio;
    private CategoriaProducto categoriaProducto;
    
    public Producto(int idProducto, String codigo, int stock, String nombre,
            String descripcion, double precio, CategoriaProducto categoriaProducto)
    {
        this.idProducto = idProducto;
        this.codigo = codigo;
        this.stock = stock;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaIngreso = LocalDate.now();
        this.precio = precio;
        this.categoriaProducto = categoriaProducto;
    }
    
}
