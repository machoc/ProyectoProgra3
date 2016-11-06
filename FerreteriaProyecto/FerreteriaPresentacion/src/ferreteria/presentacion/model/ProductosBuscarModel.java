/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.presentacion.model;

import ferreteria.entities.Producto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author luisalejandro
 */
public class ProductosBuscarModel extends Observable {
    
    Producto filter; 
    ProductoTableModel productos;
    HashMap<String,String> errores;
    String mensaje;
    Producto selected; 

    public ProductosBuscarModel() {
    }

    public void init(){ 
        filter = new Producto();
        selected=null;
        List<Producto> rows = new ArrayList<Producto>();
        this.setProductos(rows);
        clearErrors();
    }
    
    public void setProductos(List<Producto> productos){
        int[] cols={ProductoTableModel.CODIGO,ProductoTableModel.NOMBRE,ProductoTableModel.PRECIO,ProductoTableModel.CANTIDAD};
        this.productos =new ProductoTableModel(cols,productos);  
        setChanged();
        notifyObservers();        
    }
    
    public Producto getFilter() {
        return filter;
    }
    
    public void setFilter(Producto filter) {
        this.filter = filter;
    }
    
     public ProductoTableModel getPrductos() {
        return productos;
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

    public Producto getSelected() {
        return selected;
    }

    public void setSelected(Producto selected) {
        this.selected = selected;
    }
}
