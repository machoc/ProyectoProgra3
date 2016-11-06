/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria;

import ferreteria.logic.Model;
import ferreteria.presentacion.controller.ApplicationController;
import ferreteria.presentacion.controller.ClienteController;
import ferreteria.presentacion.controller.ClientesController;
import ferreteria.presentacion.controller.EmpleadoController;
import ferreteria.presentacion.controller.EmpleadosController;
import ferreteria.presentacion.controller.FacturaController;
import ferreteria.presentacion.controller.FacturasController;
import ferreteria.presentacion.controller.LoginController;
import ferreteria.presentacion.controller.ProductoController;
import ferreteria.presentacion.controller.ProductosBuscarController;
import ferreteria.presentacion.controller.ProductosController;
import ferreteria.presentacion.model.ApplicationModel;
import ferreteria.presentacion.model.ClienteModel;
import ferreteria.presentacion.model.ClientesModel;
import ferreteria.presentacion.model.EmpleadoModel;
import ferreteria.presentacion.model.EmpleadosModel;
import ferreteria.presentacion.model.FacturaModel;
import ferreteria.presentacion.model.FacturasModel;
import ferreteria.presentacion.model.LoginModel;
import ferreteria.presentacion.model.ProductoModel;
import ferreteria.presentacion.model.ProductosBuscarModel;
import ferreteria.presentacion.model.ProductosModel;
import ferreteria.presentacion.view.ApplicationView;
import ferreteria.presentacion.view.ClienteView;
import ferreteria.presentacion.view.ClientesView;
import ferreteria.presentacion.view.EmpleadoView;
import ferreteria.presentacion.view.EmpleadosView;
import ferreteria.presentacion.view.FacturaView;
import ferreteria.presentacion.view.FacturasView;
import ferreteria.presentacion.view.LoginView;
import ferreteria.presentacion.view.ProductoView;
import ferreteria.presentacion.view.ProductosBuscarView;
import ferreteria.presentacion.view.ProductosView;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author luisalejandro
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Model domainModel = Model.instance();
        Session session = new Session();
        
        ApplicationModel applicationModel = new ApplicationModel();
        ApplicationView applicationView= new ApplicationView();
        APPLICATION_VIEW = applicationView;
        ApplicationController applicationController = new ApplicationController(applicationView,applicationModel,domainModel,session);
        
        ProductosModel productosModel = new ProductosModel();
        ProductosView productosView= new ProductosView();
        PRODUCTOS_VIEW = productosView;
        applicationView.addInternalFrame(productosView);
        ProductosController productosController = new ProductosController(productosView,productosModel,domainModel,session);

        ProductoModel productoModel = new ProductoModel();        
        ProductoView productoView = new ProductoView(applicationView,true);
        PRODUCTO_VIEW=productoView;
        ProductoController productoController = new ProductoController(productoView,productoModel,domainModel,session);
        
        EmpleadosModel empleadosModel = new EmpleadosModel();
        EmpleadosView empleadosView = new EmpleadosView();
        EMPLEADOS_VIEW = empleadosView;
        applicationView.addInternalFrame(empleadosView);
        EmpleadosController empleadosController = new EmpleadosController(empleadosView, empleadosModel, domainModel, session);
        
        EmpleadoModel empleadoModel = new EmpleadoModel();
        EmpleadoView empleadoView = new EmpleadoView(applicationView,true);
        EMPLEADO_VIEW =empleadoView;
        EmpleadoController empleadoController = new EmpleadoController(empleadoView, empleadoModel, domainModel, session);
        
        FacturasModel facturasModel = new FacturasModel();
        FacturasView facturasView = new FacturasView();
        FACTURAS_VIEW = facturasView;
        applicationView.addInternalFrame(facturasView);
        FacturasController facturasController = new FacturasController(facturasView, facturasModel, domainModel, session);
        
        FacturaModel facturaModel = new FacturaModel();
        FacturaView facturaView = new FacturaView(applicationView,true);
        FACTURA_VIEW =facturaView;
        FacturaController facturaController = new FacturaController(facturaView, facturaModel, domainModel, session);
        
        ProductosBuscarModel productosBuscarModel = new ProductosBuscarModel();
        ProductosBuscarView productosBuscarView= new ProductosBuscarView(applicationView,true);
        PRODUCTOS_BUSCAR =productosBuscarView;
        ProductosBuscarController productosBuscarController = new ProductosBuscarController(productosBuscarView,productosBuscarModel,domainModel,session);
        
        
        ClientesModel clientesModel = new ClientesModel();
        ClientesView clientesView = new ClientesView();
        CLIENTES_VIEW = clientesView;
        applicationView.addInternalFrame(clientesView);
        ClientesController clientesController = new ClientesController(clientesView, clientesModel, domainModel, session);
        
        ClienteModel clienteModel = new ClienteModel();
        ClienteView clienteView = new ClienteView(applicationView,true);
        CLIENTE_VIEW = clienteView;
        ClienteController clienteController = new ClienteController(clienteView, clienteModel, domainModel, session);
        
        
        LoginModel loginModel = new LoginModel();
        LoginView loginView= new LoginView();
        LOGIN_VIEW=loginView;
        LoginController logincontroller = new LoginController(loginView,loginModel,domainModel,session);
        loginView.setVisible(true);
        
    }
    public static ApplicationView APPLICATION_VIEW;
    public static LoginView LOGIN_VIEW;
    public static ProductoView PRODUCTO_VIEW;
    public static ProductosView PRODUCTOS_VIEW;
    public static EmpleadosView EMPLEADOS_VIEW;
    public static EmpleadoView EMPLEADO_VIEW;
    public static ClienteView CLIENTE_VIEW;
    public static ClientesView CLIENTES_VIEW;
    public static FacturasView FACTURAS_VIEW;
    public static FacturaView FACTURA_VIEW;
    public static ProductosBuscarView PRODUCTOS_BUSCAR;
    
    public static  final int  MODO_AGREGAR=0;
    public static final int MODO_EDITAR=1;
    public static final int MODO_CONSULTAR=2;
    public static Border BORDER_ERROR = BorderFactory.createLineBorder(Color.red);
    public static  final String  USER_ATTRIBUTE="Empleado";
    public static  final String  ROL_ADMINISTRADOR="Administrador";
    public static  final String  ROL_VENDEDOR="Vendedor";
    public static  final String  ROL_CAJERO="Cajero";
    public static  final String ROL_DESPACHADOR="Despachador";
    public static final String ROL_BODEGUERO ="Bodeguero";
    public static  final String  ROL_NOTAUTHORIZED="No Autorizado!";
}
