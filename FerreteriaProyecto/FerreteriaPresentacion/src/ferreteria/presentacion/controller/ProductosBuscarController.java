/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.presentacion.controller;

import ferreteria.Session;
import ferreteria.entities.Factura;
import ferreteria.entities.Lineas;
import ferreteria.entities.Producto;
import ferreteria.logic.Model;
import ferreteria.presentacion.model.ProductosBuscarModel;
import ferreteria.presentacion.view.ProductosBuscarView;
import java.util.List;

/**
 *
 * @author luisalejandro
 */
public class ProductosBuscarController {
    Model domainModel;
    Session session;
    ProductosBuscarView view;
    ProductosBuscarModel model;
    
    

    public ProductosBuscarController(ProductosBuscarView view, ProductosBuscarModel model, Model domainModel, Session session) {
        model.init();
        this.domainModel = domainModel;
        this.session = session;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void buscarNombre(){
        model.clearErrors();
        model.getFilter().setNombreProducto(view.nombreFld.getText());
        List<Producto> rows = domainModel.buscarProducto(model.getFilter());
        if(rows.isEmpty()){
            model.getErrores().put("nombreFld", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setProductos(rows);
    }

    public void buscarCodigo() {
        model.clearErrors();
        model.getFilter().setCodigo(view.coFld.getText());
        List<Producto> rows = domainModel.buscarProducto1(model.getFilter());
        if(rows.isEmpty()){
            model.getErrores().put("coFld", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setProductos(rows);
    }
    
    public void seleccionar(int row){
        Producto seleccionado = model.getPrductos().getRowAt(row); 
        model.setSelected(seleccionado);
        Producto p;
        Factura f;
        List<Lineas> lineas = null;
        lineas.add(new Lineas(f.getNumFactura(),p.getCodigo()));
        view.setVisible(false);
     }
   

     public void cancelar(){
       model.setSelected(null);
        view.setVisible(false);       
     }
}
