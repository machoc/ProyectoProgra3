/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.presentacion.controller;

import ferreteria.Session;
import ferreteria.logic.Model;
import ferreteria.presentacion.model.EmpleadoModel;
import ferreteria.presentacion.model.EmpleadosModel;
import ferreteria.Application;
import ferreteria.entities.Empleado;
import ferreteria.presentacion.view.EmpleadoView;
import java.util.List;

/**
 *
 * @author luisalejandro
 */
public class EmpleadoController {
    
    Model domainModel;
    Session session;
    EmpleadoView view;
    EmpleadoModel model;

    public EmpleadoController(EmpleadoView view, EmpleadoModel model, Model domainModel, Session session) {
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
        EmpleadosModel empleadosModel = Application.EMPLEADOS_VIEW.getModel();

        Empleado nuevo = new Empleado();
      
        nuevo.setIdEmpleado(view.idFld.getText());
        if (view.idFld.getText().length()==0){
            model.getErrores().put("id", "Id requerido");
        }
        
        nuevo.setNombreEmpleado(view.nombreFld.getText());
        if (view.nombreFld.getText().length()==0){
            model.getErrores().put("nombre", "Nombre requerido");
        }
        
        nuevo.setContrasena(view.contrasenaFld.getText());
        if (view.contrasenaFld.getText().length()==0){
            model.getErrores().put("contrasena", "Contrasena requerida");
        }
        
        nuevo.setRol(view.rolFld.getText());
        if (view.nombreLbl.getText().length()==0){
            model.getErrores().put("rol", "Rol requerido");
        }
        
        List<Empleado> empleados;
        if (model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                        domainModel.agregarEmpleado(nuevo);
                        model.setMensaje("EMPLEADO AGREGADO");
                        model.setCurrent(new Empleado());
                        
                        empleados = domainModel.buscarEmpleado(empleadosModel.getFilter());
                        empleadosModel.setEmpleados(empleados);                       
                        break;
                    case Application.MODO_EDITAR:
                        domainModel.actualizaEmpleado(nuevo);
                        model.setMensaje("EMPLEADO MODIFICADO");
                        model.setCurrent(nuevo);

                        empleados = domainModel.buscarEmpleado(empleadosModel.getFilter());
                        empleadosModel.setEmpleados(empleados);
                        //view.setVisible(false);
                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("idEmpleado", "Empleado ya existe");
                model.setMensaje("EMPLEADO YA EXISTE");
                model.setCurrent(nuevo);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setCurrent(nuevo);
        }
    }
    
    
    
    
    
}
