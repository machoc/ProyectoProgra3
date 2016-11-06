/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.presentacion.model;

import ferreteria.entities.Empleado;
import java.util.HashMap;
import java.util.Observable;


/**
 *
 * @author luisalejandro
 */
public class EmpleadoModel extends Observable {
    Empleado current;
    HashMap<String,String> errores;
    String mensaje;
    int modo;    

    public EmpleadoModel() {
    }

    public void init(){
        setCurrent(new Empleado());
        clearErrors();
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
    
    public void clearErrors(){
        setErrores(new HashMap<String,String>());
        setMensaje("");
        
    }
    public Empleado getCurrent() {
        return current;
    }

    public void setCurrent(Empleado current) {
        this.current = current;
        setChanged();
        notifyObservers();        
    }

    @Override
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }
}
