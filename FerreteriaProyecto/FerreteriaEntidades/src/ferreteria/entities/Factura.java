/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.entities;

import java.util.LinkedList;



/**
 *
 * @author luisalejandro
 */
public class Factura {
    private String numFactura;
    private String fecha;
    private String hora;
    private String numFerreteria;
    private Cliente idCliente;
    private Empleado idEmpleado;
    private boolean depachada;
    private boolean cancelada;
    private LinkedList linea;

    public Factura(String numFactura, String fecha, String hora, String numFerreteria, Cliente idCliente, Empleado idEmpleado, boolean depachada, boolean cancelada) {
        this.numFactura = numFactura;
        this.fecha = fecha;
        this.hora = hora;
        this.numFerreteria = numFerreteria;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.depachada = depachada;
        this.cancelada = cancelada;
    }

    public Factura() {
        this.numFactura = "";
        this.fecha = " / / ";
        this.hora = " : ";
        this.cancelada = false;
        this.depachada = false;
        this.numFerreteria = "24567898";
        this.idEmpleado = new Empleado();
        this.idCliente = new Cliente();
            
    }

    public String getNumFactura() {
        return numFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getNumFerreteria() {
        return numFerreteria;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public boolean isDepachada() {
        return depachada;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setNumFerreteria(String numFerreteria) {
        this.numFerreteria = numFerreteria;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setDepachada(boolean depachada) {
        this.depachada = depachada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }
    
    
    
    
    
}
