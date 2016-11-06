/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.entities;

/**
 *
 * @author luisalejandro
 */
public class Producto {
    
    private int codigo;
    private int precio;
    private String nombreProducto;
    private int cantExistencias;

    public Producto(int codigo, String nombreProducto,int precio, int cantExistencias) {
        this.codigo = codigo;
        this.precio = precio;
        this.nombreProducto = nombreProducto;
        this.cantExistencias = cantExistencias;
    }

    public Producto() {
        this.codigo = 0;
        this.precio = 0;
        this.nombreProducto = "";
        this.cantExistencias = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCantExistencias() {
        return cantExistencias;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setCantExistencias(int cantExistencias) {
        this.cantExistencias = cantExistencias;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    
    
    
    
}
