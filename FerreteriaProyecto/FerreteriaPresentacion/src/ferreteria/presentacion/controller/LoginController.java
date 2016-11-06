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
import ferreteria.presentacion.model.LoginModel;
import ferreteria.presentacion.view.LoginView;

/**
 *
 * @author luisalejandro
 */
public class LoginController {
    
    Model domainModel;
    Session session;
    LoginView view;
    LoginModel model;

    public LoginController(LoginView view,LoginModel model,Model domainModel, Session session) {
        this.domainModel = domainModel;
        this.session = session;
        
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
   
    public void login() {
        model.clearErrors();
        Empleado escribir = model.getCurrent();
        escribir.setIdEmpleado(view.idTxtField.getText());
        escribir.setContrasena(new String(view.clavePassField.getPassword()));
        try {
            Empleado real = domainModel.getEmpleado(escribir.getIdEmpleado(),escribir.getContrasena());
            session.setAttibute(Application.USER_ATTRIBUTE, real);
            view.setVisible(false);
            Application.APPLICATION_VIEW.getController().enter();
        } catch (Exception ex) {
            model.setMensaje("Datos incorrectos");
            escribir.setContrasena("");
            model.setCurrent(escribir);

        }
    }
    
    public void logout(){
        model.clearErrors();
        session.removeAttribute(Application.USER_ATTRIBUTE);
        model.setCurrent(new Empleado());
        view.setVisible(true);
    }

    public void exit() {
        System.exit(0);
    }
    
}
