/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.presentacion.model;

import ferreteria.entities.Factura;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author luisalejandro
 */
public class FacturasModel extends Observable{
    
    Factura filter; 
    FacturaTableModel facturas;
    HashMap<String,String> errores;
    String mensaje;

    public FacturasModel() {
    }

    public void init(){ 
        filter = new Factura();
        clearErrors();        
        List<Factura> rows = new ArrayList<Factura>();
        this.setFacturas(rows);

    }
    
    public void setFacturas(List<Factura> facturas){
        int[] cols={FacturaTableModel.NUMERO,FacturaTableModel.FECHA,FacturaTableModel.HORA,FacturaTableModel.CANCELADA,FacturaTableModel.DESPACHADA,FacturaTableModel.NUM_FERRETERIA,FacturaTableModel.CLIENTE,FacturaTableModel.EMPLEADO};
        this.facturas =new FacturaTableModel(cols,facturas);  
        setChanged();
        notifyObservers();        
    }
    
    public Factura getFilter() {
        return filter;
    }
    
    public void setFilter(Factura filter) {
        this.filter = filter;
    }
    
     public FacturaTableModel getFacturas() {
        return facturas;
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
