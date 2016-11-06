/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.presentacion.model;

import ferreteria.entities.Empleado;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author luisalejandro
 */
public class EmpleadosModel extends Observable{
    
    Empleado filter; 
    EmpleadoTableModel empleados;
    HashMap<String,String> errores;
    String mensaje;

    public EmpleadosModel() {
    }

    public void init(){ 
        filter = new Empleado();
        clearErrors();        
        List<Empleado> rows = new ArrayList<Empleado>();
        this.setEmpleados(rows);

    }
    
    public void setEmpleados(List<Empleado> empleados){
        int[] cols={EmpleadoTableModel.ID,EmpleadoTableModel.NOMBRE,EmpleadoTableModel.CONTRASENA,EmpleadoTableModel.ROL};
        this.empleados = new EmpleadoTableModel(cols,empleados);  
        setChanged();
        notifyObservers();        
    }
    
    public Empleado getFilter() {
        return filter;
    }
    
    public void setFilter(Empleado filter) {
        this.filter = filter;
    }
    
     public EmpleadoTableModel getEmpleados() {
        return empleados;
    }

    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
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
    
    public void clearErrors(){
        setErrores(new HashMap<String,String>());
        setMensaje(""); 
    }
    
    public void commit(){
        setChanged();
        notifyObservers();       
    }

    
    
}
