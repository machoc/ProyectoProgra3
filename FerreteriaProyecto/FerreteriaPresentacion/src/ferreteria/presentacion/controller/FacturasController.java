/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.presentacion.controller;

import ferreteria.Application;
import ferreteria.Session;
import ferreteria.entities.Empleado;
import ferreteria.entities.Factura;
import ferreteria.logic.Model;
import ferreteria.presentacion.model.FacturaModel;
import ferreteria.presentacion.model.FacturasModel;
import ferreteria.presentacion.view.FacturasView;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author luisalejandro
 */
public class FacturasController {
    Model domainModel;
    Session session;
    FacturasView view;
    FacturasModel model;

    public FacturasController(FacturasView view, FacturasModel model, Model domainModel, Session session) {
        model.init();
        this.domainModel = domainModel;
        this.session = session;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void buscar() {
        model.clearErrors();        
        model.getFilter().setNumFactura(view.facturaFld.getText());
        List<Factura> rows = domainModel.buscarFactura(model.getFilter());
        if (rows.isEmpty()){
            model.getErrores().put("facturaFld", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setFacturas(rows);
    }

    public void editar(int row) {
        model.clearErrors();     
        
        FacturaModel facturaModel = Application.FACTURA_VIEW.getModel();
        Factura seleccionada = model.getFacturas().getRowAt(row); 
        facturaModel.clearErrors();
        
        Empleado principal = (Empleado) session.getAttribute(Application.USER_ATTRIBUTE);
        if ( Arrays.asList(Application.ROL_CAJERO).contains(principal.getRol())){
            facturaModel.setModo(Application.MODO_EDITAR);
        }
        else{
            facturaModel.setModo(Application.MODO_CONSULTAR);            
        }
        facturaModel.setCurrent(seleccionada);
        Application.FACTURA_VIEW.setVisible(true);
    }
    
    public void preAgregar(){
        model.clearErrors();        
        Empleado principal = (Empleado) session.getAttribute(Application.USER_ATTRIBUTE);
        if ( !Arrays.asList(Application.ROL_VENDEDOR).contains(principal.getRol())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        FacturaModel facturaModel = Application.FACTURA_VIEW.getModel();
        facturaModel.clearErrors();
        facturaModel.setModo(Application.MODO_AGREGAR);
        facturaModel.setCurrent(new Factura());
        Application.FACTURA_VIEW.setVisible(true);
    }
    
    public void borrar(int row){
        model.clearErrors(); 
        Empleado principal = (Empleado) session.getAttribute(Application.USER_ATTRIBUTE);
        if ( !Arrays.asList(Application.ROL_DESPACHADOR).contains(principal.getRol())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        Factura seleccionada = model.getFacturas().getRowAt(row); 
        try {
            domainModel.eliminarFactura(seleccionada);
        } catch (Exception ex) { }
        List<Factura> rowsMod = domainModel.buscarFactura(model.getFilter());
        model.setFacturas(rowsMod);
    }
    
}
