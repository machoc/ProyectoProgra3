/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.presentacion.model;

import ferreteria.entities.Empleado;
import ferreteria.presentacion.view.ApplicationView;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author luisalejandro
 */
public class ApplicationModel extends Observable{
    String mensaje;
    Empleado current;

    public void init(){ 
        clearErrors();
    }   
    
    public ApplicationModel() {
        clearErrors();       
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Empleado getCurrent() {
        return current;
    }

    public void setCurrent(Empleado current) {
        this.current = current;
        this.setChanged();
        this.notifyObservers();
    }
    
    public void clearErrors(){
        setMensaje("");
        
    }
    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers();
    }

   
}
