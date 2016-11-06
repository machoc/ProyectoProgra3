/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.presentacion.controller;

import ferreteria.Application;
import ferreteria.Session;
import ferreteria.entities.Empleado;
import ferreteria.entities.Producto;
import ferreteria.logic.Model;
import ferreteria.presentacion.model.ProductoModel;
import ferreteria.presentacion.model.ProductosModel;
import ferreteria.presentacion.view.ProductoView;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author luisalejandro
 */
public class ProductoController {
    
    Model domainModel;
    Session session;    
    ProductoView view;
    ProductoModel model;

    public ProductoController(ProductoView view, ProductoModel model, Model domainModel, Session session) {
        model.init();
        this.domainModel = domainModel;
        this.session = session;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    

    
    public void guardar(){
        model.clearErrors();        
        ProductosModel productosModel = Application.PRODUCTOS_VIEW.getModel();

        Producto nuevo = new Producto();
      
        nuevo.setCodigo(Integer.parseInt(view.codigoFld.getText()));
        if (view.codigoFld.getText().length()==0){
            model.getErrores().put("codigo", "Codigo requerido");
        }
        
        nuevo.setNombreProducto(view.nombreFld.getText());;
        if (view.nombreFld.getText().length()==0){
            model.getErrores().put("nombre", "Nombre requerido");
        }
        
        nuevo.setPrecio(Integer.parseInt(view.precioFld.getText()));
        if (view.nombreFld.getText().length()==0){
            model.getErrores().put("precio", "Precio requerido");
        }
        
        nuevo.setCantExistencias(Integer.parseInt(view.cantidadFld.getText()));
        if (view.nombreFld.getText().length()==0){
            model.getErrores().put("cantidad", "Cantidad requerida");
        }
        
        List<Producto> productos;
        if (model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                        domainModel.agregarProducto(nuevo);
                        model.setMensaje("PRODUCTO AGREGADO");
                        model.setCurrent(new Producto());
                        
                        productos = domainModel.buscarProducto1(productosModel.getFilter());
                        productosModel.setProductos(productos);                        
                        break;
                    case Application.MODO_EDITAR:
                        domainModel.actualizaProducto(nuevo);
                        model.setMensaje("PRODUCTO MODIFICADO");
                        model.setCurrent(nuevo);

                        productos = domainModel.buscarProducto1(productosModel.getFilter());
                        productosModel.setProductos(productos); 
                        //view.setVisible(false);
                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("codigo", "Producto ya existe");
                model.setMensaje("PRODUCTO YA EXISTE");
                model.setCurrent(nuevo);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setCurrent(nuevo);
        }
    }   
    
}
