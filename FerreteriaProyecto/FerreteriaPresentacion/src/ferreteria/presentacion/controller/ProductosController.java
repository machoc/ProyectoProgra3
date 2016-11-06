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
import ferreteria.presentacion.view.ProductosView;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author luisalejandro
 */
public class ProductosController {
    Model domainModel;
    Session session;
    ProductosView view;
    ProductosModel model;

    public ProductosController(ProductosView view, ProductosModel model, Model domainModel, Session session) {
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
        Empleado principal = (Empleado) session.getAttribute(Application.USER_ATTRIBUTE);
        if ( !Arrays.asList(Application.ROL_ADMINISTRADOR,Application.ROL_BODEGUERO).contains(principal.getRol())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        model.getFilter().setNombreProducto(view.nombreFld.getText());
        List<Producto> rows = domainModel.buscarProducto(model.getFilter());
        if(rows.isEmpty()){
            model.getErrores().put("nombreFld", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setProductos(rows);
    }
    public void editar(int row){
        model.clearErrors();        
        ProductoModel productoModel = Application.PRODUCTO_VIEW.getModel();
        Producto seleccionado = model.getProductos().getRowAt(row);
        productoModel.clearErrors();
        
        Empleado principal = (Empleado) session.getAttribute(Application.USER_ATTRIBUTE);
        if ( !Arrays.asList(Application.ROL_ADMINISTRADOR,Application.ROL_BODEGUERO).contains(principal.getRol())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        productoModel.setCurrent(seleccionado);
        Application.PRODUCTO_VIEW.setVisible(true);
    }
    
    public void borrar(int row){
        model.clearErrors();  
        Empleado principal = (Empleado) session.getAttribute(Application.USER_ATTRIBUTE);
        if ( !Arrays.asList(Application.ROL_ADMINISTRADOR,Application.ROL_BODEGUERO).contains(principal.getRol())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        Producto seleccionado = model.getProductos().getRowAt(row); 
        try {
            domainModel.eiminarProducto(seleccionado);
        } catch (Exception ex) { }
        List<Producto> rowsMod = domainModel.buscarProducto1(model.getFilter());
        model.setProductos(rowsMod);
    }
    
    public void agregar(){
        model.clearErrors();
        Empleado principal = (Empleado) session.getAttribute(Application.USER_ATTRIBUTE);
        if ( !Arrays.asList(Application.ROL_ADMINISTRADOR,Application.ROL_BODEGUERO).contains(principal.getRol())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        ProductoModel productoModel = Application.PRODUCTO_VIEW.getModel();
        productoModel.clearErrors();
        productoModel.setModo(Application.MODO_AGREGAR);
        productoModel.setCurrent(new Producto());
        Application.PRODUCTO_VIEW.setVisible(true);
        
    }

    public void buscarCodigo() {
        model.clearErrors();
        Empleado principal = (Empleado) session.getAttribute(Application.USER_ATTRIBUTE);
        if ( !Arrays.asList(Application.ROL_ADMINISTRADOR,Application.ROL_BODEGUERO).contains(principal.getRol())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        model.getFilter().setCodigo(Integer.parseInt(view.coFld.getText()));
        List<Producto> rows = domainModel.buscarProducto1(model.getFilter());
        if(rows.isEmpty()){
            model.getErrores().put("coFld", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setProductos(rows);
    }
    
    
    
}
