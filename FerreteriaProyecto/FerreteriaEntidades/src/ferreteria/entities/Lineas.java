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
public class Lineas {
    
    private Factura numFactura;
    private Producto codigo;
    private int cantidad;
    private Producto prod;

    public Lineas(Factura numFactura, Producto codigo,int cantidad) {
        this.numFactura = numFactura;
        this.codigo = codigo;
        this.cantidad = cantidad;
    }

    public void setProd(Producto prod) {
        this.prod = prod;
    }

    public Producto getProd() {
        return prod;
    }

    public Lineas() {
        this.numFactura = new Factura();
        this.codigo = new Producto();
        this.cantidad = 0;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Factura getNumFactura() {
        return numFactura;
    }

    public Producto getCodigo() {
        return codigo;
    }

    public void setNumFactura(Factura numFactura) {
        this.numFactura = numFactura;
    }

    public void setCodigo(Producto codigo) {
        this.codigo = codigo;
    }
    
    public int total(){
        return this.prod.getCantExistencias()*this.prod.getPrecio();
    }
    
    
    
}
