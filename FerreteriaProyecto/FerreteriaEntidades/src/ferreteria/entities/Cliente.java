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
public class Cliente {
    String idCliente;
    String nombreCliente;
    String telefonoCliente;
    String descuento;

    public Cliente(String idCliente, String nombreCliente, String telefonoCliente, String descuento) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.descuento = descuento;
    }

    public Cliente() {
        this.idCliente = "";
        this.nombreCliente = "";
        this.telefonoCliente = "";
        this.descuento = "";
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }
    
    
    
}
