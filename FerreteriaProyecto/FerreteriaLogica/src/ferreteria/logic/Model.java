/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.logic;

import ferreteria.entities.Cliente;
import ferreteria.entities.Empleado;
import ferreteria.entities.Factura;
import ferreteria.entities.Lineas;
import ferreteria.entities.Producto;
import ferreteria.data.Dao;
import java.util.Collection;
import java.util.List;
        

/**
 *
 * @author luisalejandro
 */
public class Model {
    
    private Dao dao;
    private static Model uniqueInstance;
    
    public static Model instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Model();
        }
        return uniqueInstance;
    }

    public Model() {
        dao = new Dao();
    }
    
    public Collection<Cliente> getClientes(){
        return dao.ClienteGetAll();
    }
    
    public Collection<Empleado> getEmpleados(){
        return dao.EmpleadoGetAll();
    }
    
    public Producto getProducto(String codigo) throws Exception{
        return dao.ProductoGet(codigo);
    }
    
    public Cliente getCliente(String idCliente) throws Exception{
        return dao.ClienteGet(idCliente);
    }
    
    public Empleado getEmpleado(String idEmpleado,String contrasena) throws Exception{
        Empleado e = dao.EmpleadoGet(idEmpleado);
        if (e.getContrasena().equals(contrasena)){
            return e;
        }
        else{
            throw new Exception ("Clave incorrecta");
        }
    }
    
    public Factura getFactura(String numFactura) throws Exception{
        return dao.FacturaGet(numFactura);
    }
    
    public Lineas getLineas(String numFactura1) throws Exception{
        return dao.LineasGet(numFactura1);
    }
    
    public void agregarProducto(Producto producto) throws Exception{
        dao.insertarProducto(producto);
    }
    
    public void agregarCliente(Cliente cliente) throws Exception{
        dao.insertarCliente(cliente);
    }
    
    public void agregarEmpleado(Empleado empleado) throws Exception{
        dao.insertarEmpleado(empleado);
    }
    
    public void agregarFactura(Factura factura) throws Exception{
        dao.insertarFactura(factura);
    }
    
    public void agregarLineas(Lineas lineas) throws Exception{
        dao.insertarLinea(lineas);
    }
    
    public void eiminarProducto(Producto p) throws Exception{
        dao.eliminarProducto(p);
    }
    
    public void eliminarCliente(Cliente c) throws Exception{
        dao.eliminarCliente(c);
    }
    
    public void eliminarEmpleado(Empleado e) throws Exception{
        dao.eliminarEmpleado(e);
    }
    
    public void eliminarFactura(Factura f) throws Exception{
        dao.eliminarFactura(f);
    }
    
    public void eliminarLinea(Lineas l) throws Exception{
        dao.eliminarLinea(l);
    }
    
    public void actualizaProducto(Producto producto) throws Exception{
        dao.actualizarProducto(producto);
    }
    
    public void actualizaCliente(Cliente cliente) throws Exception{
        dao.actualizarCliente(cliente);
    }
    
    public void actualizaEmpleado(Empleado empleado) throws Exception{
        dao.actualizarEmpleado(empleado);
    }
    
    public void actualizaFactura(Factura factura) throws Exception{
       dao.actualizarFactura(factura);
    }
    
    public List<Producto> buscarProducto(Producto filtro){
        return dao.BuscarProducto(filtro);
    }
    
    public List<Producto> buscarProducto1(Producto flitro){
        return dao.BuscarProducto1(flitro);
    }
    
    public List<Cliente> buscarCliente(Cliente filtro){
        return dao.BuscarCliente(filtro);
    }
    
    public List<Cliente> buscarCliente1(Cliente filtro){
        return dao.BuscarCliente1(filtro);
    }
    
    public List<Empleado> buscarEmpleado(Empleado filtro){
        return dao.BuscarEmpleado(filtro);
    }
    
    public List<Empleado> buscarEmpleado1(Empleado filtro){
        return dao.BuscarEmpleado1(filtro);
    }
    
    public List<Factura> buscarFactura(Factura filtro){
        return dao.BuscarFactura(filtro);
    }
    
    public void close(){
        dao.close();
    }

    public List<Lineas> buscarLinea(Lineas filtro) {
        return dao.BuscarLineas(filtro);
    }

    
    
}
