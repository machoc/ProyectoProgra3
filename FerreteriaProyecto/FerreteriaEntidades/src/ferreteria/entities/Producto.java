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
    
    private String codigo;
    private String precio;
    private String nombreProducto;
    private String cantExistencias;

    public Producto(String codigo, String nombreProducto,String precio, String cantExistencias) {
        this.codigo = codigo;
        this.precio = precio;
        this.nombreProducto = nombreProducto;
        this.cantExistencias = cantExistencias;
    }

    public Producto() {
        this.codigo = "";
        this.precio = "";
        this.nombreProducto = "";
        this.cantExistencias = "";
    }
    
    

    public String getCodigo() {
        return codigo;
    }

    public String getPrecio() {
        return precio;
    }

    public String getCantExistencias() {
        return cantExistencias;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setCantExistencias(String cantExistencias) {
        this.cantExistencias = cantExistencias;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    
    
    
    
}
