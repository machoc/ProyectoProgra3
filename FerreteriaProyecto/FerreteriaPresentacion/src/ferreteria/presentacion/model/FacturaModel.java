/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.presentacion.model;

import ferreteria.entities.Cliente;
import ferreteria.entities.Empleado;
import ferreteria.entities.Factura;
import ferreteria.entities.Lineas;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author luisalejandro
 */
public class FacturaModel extends Observable{

    Factura current;
    Lineas filter;
    ComboBoxModel<Cliente> clientes;
    ComboBoxModel<Empleado> empleados;
    LineaTableModel lineas;
    HashMap<String, String> errores;
    String mensaje;
    int modo;

    public FacturaModel() {
    }

    public void init(Cliente[] clientes,Empleado[] empleados) {
        filter=new Lineas();
        List<Lineas> rows = new ArrayList<Lineas>();
        setClientes(clientes);
        setEmpleados(empleados);
        setCurrent(new Factura());
        this.setLineas(rows);
        clearErrors();
    }

    public LineaTableModel getLineas() {
        return lineas;
    }

    public void setLineas(List<Lineas> lineas) {
        int cols[] = {LineaTableModel.NUM_FACTURA,LineaTableModel.CODIGO};
        this.lineas = new LineaTableModel(cols,lineas);
        setChanged();
        notifyObservers();
    }
    
    public Lineas getFilter() {
        return filter;
    }
    
    public void setFilter(Lineas filter) {
        this.filter = filter;
    } 

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public HashMap<String, String> getErrores() {
        return errores;
    }

    public void setErrores(HashMap<String, String> errores) {
        this.errores = errores;
    }

    public void clearErrors() {
        setErrores(new HashMap<String, String>());
        setMensaje("");

    }

    public Factura getCurrent() {
        return current;
    }

    public void setCurrent(Factura current) {
        this.current = current;
        setChanged();
        notifyObservers();
    }
    
    public ComboBoxModel<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = new DefaultComboBoxModel(clientes);
        setChanged();
        notifyObservers();        
    }
    
    public ComboBoxModel<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado[] empleados) {
        this.empleados = new DefaultComboBoxModel(empleados);
        setChanged();
        notifyObservers();        
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
    
}
