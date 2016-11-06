/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.presentacion.controller;

import ferreteria.Application;
import ferreteria.Session;
import ferreteria.entities.Cliente;
import ferreteria.entities.Empleado;
import ferreteria.entities.Factura;
import ferreteria.entities.Lineas;
import ferreteria.logic.Model;
import ferreteria.presentacion.model.EmpleadoModel;
import ferreteria.presentacion.model.FacturaModel;
import ferreteria.presentacion.model.FacturasModel;
import ferreteria.presentacion.view.FacturaView;
import java.awt.Dialog;
import ferreteria.entities.Producto;
import ferreteria.presentacion.model.ProductosModel;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author luisalejandro
 */
public class FacturaController {
    
    Model domainModel;
    Session session;
    FacturaModel model;
    ProductosModel productosModel;
    FacturaView view;
    EmpleadoModel empleadoModel;

    public FacturaController(FacturaView view, FacturaModel model, Model domainModel, Session session) {
        model.init(domainModel.getClientes().toArray(new Cliente[0]),domainModel.getEmpleados().toArray(new Empleado[0]));
        this.domainModel = domainModel;
        this.session = session;
        
        this.model = model;
        this.view = view;
        view.setController(this);
        view.setModel(model);
    }
    
    public void guardar(){
        model.clearErrors();        
        FacturasModel facturasModel = Application.FACTURAS_VIEW.getModel();

        Factura nueva = new Factura();
      
        nueva.setNumFactura(view.numFld.getText());
        if (view.numFld.getText().length()==0){
            model.getErrores().put("num", "Numero requerido");
        }
        
        nueva.setFecha(model.getCurrent().getFecha());
        if (view.fechaFld.getText().length()==0){
            model.getErrores().put("fecha", "Fecha requerida");
        }
        
        if (view.estadoFldCancelada.isSelected()) nueva.setCancelada(true);
        else if (view.estadoFldDespachada.isSelected()) nueva.setDepachada(true);
        
        nueva.setHora(view.horaFld.getText());
        if (view.horaFld.getText().length()==0){
            model.getErrores().put("hora", "Hora requerida");
        }
        
        nueva.setIdCliente((Cliente) view.clientecBox.getSelectedItem());
        
        nueva.setIdEmpleado((Empleado)view.empleadocbox.getSelectedItem());
        
        nueva.setCancelada(view.estadoFldCancelada.isSelected());
        
        nueva.setDepachada(view.estadoFldDespachada.isSelected());
        
        List<Factura> facturas;
        if (model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                        domainModel.agregarFactura(nueva);
                        model.setMensaje("FACTURA AGREGADA");
                        model.setCurrent(new Factura());
                        
                        facturas = domainModel.buscarFactura(facturasModel.getFilter());
                        facturasModel.setFacturas(facturas);                        
                        break;
                    case Application.MODO_EDITAR:
                        domainModel.actualizaFactura(nueva);
                        model.setMensaje("FACTURA MODIFICADADA");
                        model.setCurrent(nueva);

                        facturas = domainModel.buscarFactura(facturasModel.getFilter());
                        facturasModel.setFacturas(facturas);
                        //view.setVisible(false);
                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("num", "Factura ya existe");
                model.setMensaje("FACTURA YA EXISTE");
                model.setCurrent(nueva);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setCurrent(nueva);
        }
    }  

    public void buscar(int row) {
        Application.PRODUCTOS_BUSCAR.setVisible(true);
    }

    public void borrar(int row) {
        model.clearErrors(); 
        Empleado principal = (Empleado) session.getAttribute(Application.USER_ATTRIBUTE);
        if ( !Arrays.asList(Application.ROL_CAJERO).contains(principal.getRol())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            return;
        }
        Lineas seleccionada = model.getLineas().getRowAt(row);
        try{
            domainModel.eliminarLinea(seleccionada);
        } catch (Exception ex) { }
        List<Lineas> rowsMod = domainModel.buscarLinea(model.getFilter());
        model.setLineas(rowsMod);
    }
        
}
