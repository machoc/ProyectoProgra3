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
import ferreteria.logic.Model;
import ferreteria.presentacion.model.ClienteModel;
import ferreteria.presentacion.model.ClientesModel;
import ferreteria.presentacion.view.ClientesView;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author luisalejandro
 */
public class ClientesController {
    
    Model domainModel;
    Session session;
    ClientesView view;
    ClientesModel model;

    public ClientesController(ClientesView view, ClientesModel model, Model domainModel, Session session) {
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
        model.getFilter().setNombreCliente(view.nombreFld.getText());
        List<Cliente> rows = domainModel.buscarCliente1(model.getFilter());
        if (rows.isEmpty()){
            model.getErrores().put("nombreFld", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setClientes(rows);
    }
    
    public void buscarId(){
        model.clearErrors();        
        model.getFilter().setIdCliente(view.idFld.getText());
        List<Cliente> rows = domainModel.buscarCliente(model.getFilter());
        if (rows.isEmpty()){
            model.getErrores().put("idFld", "Ningun registro coincide");
            model.setMensaje("NINGUN REGISTRO COINCIDE");
        }
        model.setClientes(rows);
    }

    public void preAgregar(){
        model.clearErrors();        
        Empleado principal = (Empleado) session.getAttribute(Application.USER_ATTRIBUTE);
        if ( !Arrays.asList(Application.ROL_ADMINISTRADOR).contains(principal.getRol())){
            model.setMensaje(Application.ROL_NOTAUTHORIZED);
            model.commit();
            return;
        }
        ClienteModel clienteModel = Application.CLIENTE_VIEW.getModel();
        clienteModel.clearErrors();
        clienteModel.setModo(Application.MODO_AGREGAR);
        clienteModel.setCurrent(new Cliente());
        Application.CLIENTE_VIEW.setVisible(true);
    }
    
    public void editar(int row){
        model.clearErrors();
        ClienteModel clienteModel = Application.CLIENTE_VIEW.getModel();
        Cliente seleccionado = model.getClientes().getRowAt(row);
        clienteModel.clearErrors();
        
        Empleado principal = (Empleado) session.getAttribute(Application.USER_ATTRIBUTE);
        if ( Arrays.asList(Application.ROL_ADMINISTRADOR, Application.ROL_CAJERO).contains(principal.getRol())){
            clienteModel.setModo(Application.MODO_EDITAR);
        }
        else{
            clienteModel.setModo(Application.MODO_CONSULTAR);            
        }
        clienteModel.setCurrent(seleccionado);
        Application.CLIENTE_VIEW.setVisible(true);
    }

    public void borrar(int row){
        model.clearErrors();        
        Cliente seleccionado = model.getClientes().getRowAt(row); 
        try {
            domainModel.eliminarCliente(seleccionado);
        } catch (Exception ex) { }
        List<Cliente> rowsMod = domainModel.buscarCliente(model.getFilter());
        model.setClientes(rowsMod);
    }
    
    public void salir(){
        model.clearErrors();        
        domainModel.close();
        view.setVisible(false);
        Application.LOGIN_VIEW.getController().logout();
    }
    
    
    
}
