/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.presentacion.controller;

import ferreteria.Session;
import ferreteria.entities.Empleado;
import ferreteria.logic.Model;
import ferreteria.presentacion.model.EmpleadosModel;
import ferreteria.presentacion.view.EmpleadosView;
import ferreteria.Application;
import ferreteria.presentacion.model.EmpleadoModel;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author luisalejandro
 */
public class EmpleadosController {
    Model domainModel;
    Session session;
    EmpleadosView view;
    EmpleadosModel model;
    
    public EmpleadosController(EmpleadosView view, EmpleadosModel model, Model domainModel, Session session) {
        model.init();
        this.domainModel= domainModel;
        this.session=session;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void buscarId(){
        model.clearErrors();
        Empleado principal = (Empleado) session.getAttribute(Application.USER_ATTRIBUTE);
        if ( !Arrays.asList(Application.ROL_ADMINISTRADOR).contains(principal.getRol())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        model.getFilter().setIdEmpleado(view.idFld.getText());
        List<Empleado> rows = domainModel.buscarEmpleado(model.getFilter());
        if (rows.isEmpty()){
            model.getErrores().put("idFld", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setEmpleados(rows);
    }
    
    public void buscarNombre(){
        model.clearErrors();
        Empleado principal = (Empleado) session.getAttribute(Application.USER_ATTRIBUTE);
        if ( !Arrays.asList(Application.ROL_ADMINISTRADOR).contains(principal.getRol())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        model.getFilter().setNombreEmpleado(view.nombreFld.getText());
        List<Empleado> rows = domainModel.buscarEmpleado1(model.getFilter());
        if (rows.isEmpty()){
            model.getErrores().put("nombreFld", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setEmpleados(rows);
    }

    public void preAgregar(){
        model.clearErrors();        
        Empleado principal = (Empleado) session.getAttribute(Application.USER_ATTRIBUTE);
        if ( !Arrays.asList(Application.ROL_ADMINISTRADOR).contains(principal.getRol())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        EmpleadoModel empleadoModel = Application.EMPLEADO_VIEW.getModel();
        empleadoModel.clearErrors();
        empleadoModel.setModo(Application.MODO_AGREGAR);
        empleadoModel.setCurrent(new Empleado());
        Application.EMPLEADO_VIEW.setVisible(true);
    }
    
    public void editar(int row){
        model.clearErrors();        
        EmpleadoModel empleadoModel = Application.EMPLEADO_VIEW.getModel();
        Empleado seleccionado = model.getEmpleados().getRowAt(row); 
        empleadoModel.clearErrors();
        
        Empleado principal = (Empleado) session.getAttribute(Application.USER_ATTRIBUTE);
        if ( !Arrays.asList(Application.ROL_ADMINISTRADOR).contains(principal.getRol())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        Application.EMPLEADO_VIEW.setVisible(true);
    }

    public void borrar(int row){
        model.clearErrors(); 
        Empleado principal = (Empleado) session.getAttribute(Application.USER_ATTRIBUTE);
        if ( !Arrays.asList(Application.ROL_ADMINISTRADOR).contains(principal.getRol())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        Empleado seleccionado = model.getEmpleados().getRowAt(row);
        try{
            domainModel.eliminarEmpleado(seleccionado);
        } catch (Exception ex) { }
        List<Empleado> rowsMod = domainModel.buscarEmpleado(model.getFilter());
        model.setEmpleados(rowsMod);
    }
    
    public void salir(){
        model.clearErrors();        
        domainModel.close();
        view.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
    }   
       
}
