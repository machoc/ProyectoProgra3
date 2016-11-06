/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.presentacion.controller;

import ferreteria.Application;
import ferreteria.Session;
import ferreteria.entities.Empleado;
import ferreteria.logic.Model;
import ferreteria.presentacion.model.ApplicationModel;
import ferreteria.presentacion.view.ApplicationView;
import java.util.Arrays;

/**
 *
 * @author luisalejandro
 */
public class ApplicationController {
    
    Model domainModel;
    Session session;
    ApplicationView view;
    ApplicationModel model;

    public ApplicationController(ApplicationView view,ApplicationModel model,Model domainModel, Session session) {
        this.domainModel = domainModel;
        this.session = session;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }


    public void exit() {
        view.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
    }
    
    public void mostrarProducto(){
        Empleado principal = (Empleado) session.getAttribute(Application.USER_ATTRIBUTE);
        if ( !Arrays.asList(Application.ROL_ADMINISTRADOR).contains(principal.getRol())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            return;
        }
        Application.PRODUCTOS_VIEW.setVisible(true);
    
    }
    
    public void mostrarFactura(){
        Empleado principal = (Empleado) session.getAttribute(Application.USER_ATTRIBUTE);
        if ( !Arrays.asList(Application.ROL_VENDEDOR).contains(principal.getRol())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            return;
        }
        Application.FACTURAS_VIEW.setVisible(true);
    
    }
    
    public void mostrarFacturaPago(){
        Empleado principal = (Empleado) session.getAttribute(Application.USER_ATTRIBUTE);
        if(!Arrays.asList(Application.ROL_CAJERO).contains(principal.getRol())){
            return;
        }
        Application.FACTURAS_VIEW.setVisible(true);
    }

    public void enter() {
        Application.APPLICATION_VIEW.getModel().init();
        Application.APPLICATION_VIEW.getModel().setCurrent((Empleado) session.getAttribute(Application.USER_ATTRIBUTE));
        view.setVisible(true);
    }

    public void mostrarEmpleado() {
        Empleado principal = (Empleado) session.getAttribute(Application.USER_ATTRIBUTE);
        if ( !Arrays.asList(Application.ROL_ADMINISTRADOR).contains(principal.getRol())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            return;
        }
        Application.EMPLEADOS_VIEW.setVisible(true);
    }

    public void mostrarCliente() {
        Empleado principal = (Empleado) session.getAttribute(Application.USER_ATTRIBUTE);
        if ( !Arrays.asList(Application.ROL_VENDEDOR).contains(principal.getRol())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            return;
        }
        Application.CLIENTES_VIEW.setVisible(true);
    }
    
    public void mostrarBodega(){
        Empleado principal = (Empleado) session.getAttribute(Application.USER_ATTRIBUTE);
        if( !Arrays.asList(Application.ROL_BODEGUERO).contains(principal.getRol())){
            return;
        }
        Application.PRODUCTOS_VIEW.setVisible(true);
    }

    
    
    
    
    
    
}
