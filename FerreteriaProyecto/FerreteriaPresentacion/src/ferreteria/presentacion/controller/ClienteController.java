/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.presentacion.controller;

import ferreteria.Application;
import ferreteria.Session;
import ferreteria.entities.Cliente;
import ferreteria.logic.Model;
import ferreteria.presentacion.model.ClienteModel;
import ferreteria.presentacion.model.ClientesModel;
import ferreteria.presentacion.view.ClienteView;
import java.util.List;

/**
 *
 * @author luisalejandro
 */
public class ClienteController {
    
    Model domainModel;
    Session session;
    ClienteView view;
    ClienteModel model;

    public ClienteController(ClienteView view, ClienteModel model, Model domainModel, Session session) {
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
         ClientesModel clientesModel = Application.CLIENTES_VIEW.getModel();
         
         Cliente nuevo = new Cliente();
      
        nuevo.setIdCliente(view.idFld.getText());
        if (view.idFld.getText().length()==0){
            model.getErrores().put("id", "Id requerido");
        }
        
        nuevo.setNombreCliente(view.nombreFld.getText());
        if (view.nombreFld.getText().length()==0){
            model.getErrores().put("nombre", "Nombre requerido");
        }
        
        nuevo.setTelefonoCliente(view.telFld.getText());
        if (view.telFld.getText().length()==0){
            model.getErrores().put("telefono", "Telefono requerido");
        }
        
        nuevo.setDescuento(view.desFld.getText());
        if (view.desFld.getText().length()==0){
            model.getErrores().put("descuento", "Descuento requerido");
        }
        
        List<Cliente> clientes;
        if (model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                        domainModel.agregarCliente(nuevo);
                        model.setMensaje("CLIENTE AGREGADO");
                        model.setCurrent(new Cliente());
                        
                        clientes = domainModel.buscarCliente(clientesModel.getFilter());
                        clientesModel.setClientes(clientes);                        
                        break;
                    case Application.MODO_EDITAR:
                        domainModel.actualizaCliente(nuevo);
                        model.setMensaje("CLIENTE MODIFICADO");
                        model.setCurrent(nuevo);

                        clientes = domainModel.buscarCliente(clientesModel.getFilter());
                        clientesModel.setClientes(clientes);
                        //view.setVisible(false);
                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("idCliente", "Cliente ya existe");
                model.setMensaje("CLIENTE YA EXISTE");
                model.setCurrent(nuevo);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setCurrent(nuevo);
        }
    }   
    
    
    
}
