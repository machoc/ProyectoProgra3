/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.presentacion.model;

import ferreteria.entities.Cliente;
import java.util.HashMap;
import java.util.Observable;

/**
 *
 * @author luisalejandro
 */
public class ClienteModel extends Observable {

    Cliente current;
    HashMap<String, String> errores;
    String mensaje;
    int modo;

    public ClienteModel() {
    }

    public void init() {
        setCurrent(new Cliente());
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

    public void clearErrors() {
        setErrores(new HashMap<String, String>());
        setMensaje("");

    }

    public Cliente getCurrent() {
        return current;
    }

    public void setCurrent(Cliente current) {
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
