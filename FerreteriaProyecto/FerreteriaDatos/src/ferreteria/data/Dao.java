/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.data;

import ferreteria.entities.Cliente;
import ferreteria.entities.Empleado;
import ferreteria.entities.Factura;
import ferreteria.entities.Lineas;
import ferreteria.entities.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisalejandro
 */
public class Dao {
    
    FerreteriaBaseDatos db;

    public Dao() {
        db = new FerreteriaBaseDatos();
    }
    
    public void insertarProducto(Producto p) throws Exception{
        String sql="insert into Producto (codigo, nombreProducto,precio, cantExistencias)"+
                "values('%s','%s','%s','%s','%s')";
        sql=String.format(sql,p.getCodigo(),p.getNombreProducto(),p.getPrecio(),p.getCantExistencias());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Producto ya existe");
        }
    
    }
    
    public void insertarCliente(Cliente c) throws Exception{
        String sql ="insert into Cliente (idCliente, nombreCliente, telefonoCliente, descuento)"+
                "values('%s','%s','%s','%s')";
        sql=String.format(sql,c.getIdCliente(),c.getNombreCliente(),c.getTelefonoCliente(),c.getDescuento());
        int count=db.executeUpdate(sql);
        if(count==0){
            throw new Exception("Cliente ya existe");
        }
    
    }
    
    public void insertarEmpleado(Empleado e) throws Exception{
        String sql="insert into Empleado (idEmpleado, nombreEmpleado, contrasena,rol)" +
                "values('%s','%s','%s','%s')";
        sql=String.format(sql,e.getIdEmpleado(),e.getNombreEmpleado(),e.getContrasena(),e.getRol());
        int count=db.executeUpdate(sql);
        if(count==0){
            throw new Exception("Empleado ya existe");
        }
    }
    
    public void insertarLinea(Lineas l) throws Exception{
        String sql="insert into Lineas (numFactura1, codigo)"+
                "values('%s','%s')";
        sql=String.format(sql,l.getNumFactura().getNumFactura(),l.getCodigo().getCodigo());
        int count=db.executeUpdate(sql);
        if(count==0){
            throw new Exception("Linea ya existe");
        }
    }
    
    public void insertarFactura(Factura f) throws Exception{
        String sql="insert into Factura (numFactura,fecha,hora,cancelada,despachada,"+
                "numFerreteria,Cliente,Empleado)"+
                "values('%s','%s','%s',%b,%b, '%s','%s','%s')";
        sql=String.format(sql,f.getNumFactura(),f.getFecha(),f.getHora(),f.isCancelada(),
                f.isDepachada(),f.getNumFerreteria(),f.getIdCliente().getIdCliente(),f.getIdEmpleado().getIdEmpleado());
        ResultSet keys = db.executeUpdateWithKeys(sql);
        try{
            keys.next();
        }
        catch(Exception ex){
            throw new Exception("Factura ya existe");
        }
    }
    
    public void eliminarProducto(Producto p) throws Exception{
        String sql = "delete from Producto where codigo='%s'";
        sql=String.format(sql, p.getCodigo());
        int count=db.executeUpdate(sql);
        if(count==0){
            throw new Exception("Producto no existe");
        }
    }
    
    public void eliminarCliente(Cliente c) throws Exception{
        String sql="delete from Cliente where idCliente='%s'";
        sql=String.format(sql, c.getIdCliente());
        int count=db.executeUpdate(sql);
        if(count==0){
            throw new Exception("Cliente no existe");
        }
    }
    
    public void eliminarEmpleado(Empleado e) throws Exception{
        String sql="delete from Empleado where idEmpleado='%s'";
        sql=String.format(sql, e.getIdEmpleado());
        int count=db.executeUpdate(sql);
        if(count==0){
            throw new Exception("Empleado no existe");
        }
    }
    
    public void eliminarLinea(Lineas l) throws Exception{
        String sql="delete from Lineas where numFactura1='%s' and codigo='%s'";
        sql=String.format(sql, l.getNumFactura().getNumFactura());
        int count=db.executeUpdate(sql);
        if(count==0){
            throw new Exception("Linea no existe");
        }
    }
    
    public void eliminarFactura(Factura f) throws Exception{
        String sql="delete from Factura where numFactura='%s'";
        sql=String.format(sql, f.getNumFactura());
        int count=db.executeUpdate(sql);
        if(count==0){
            throw new Exception("Factura no existe");
        }
    }
    
    public void actualizarProducto(Producto p) throws Exception{
        String sql="update Producto set nombreProducto='%s',precio='%s',cantExistencias= '%s',"+
                "where codigo='%s'";
        sql=String.format(sql,p.getNombreProducto(),p.getPrecio(),p.getCantExistencias(),
                p.getCodigo());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Producto no existe");
        }
    }
    
    public void actualizarCliente(Cliente c) throws Exception{
        String sql="update Cliente set nombreCliente='%s',telefonoCliente='%s',descuento='%s',"+
                "where idCliente='%s'";
        sql=String.format(sql,c.getNombreCliente(),c.getTelefonoCliente(),c.getDescuento());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Cliente no existe");
        }
    }
    
    public void actualizarEmpleado(Empleado e) throws Exception{
        String sql="update Empleado set nombreEmpleado='%s',contrasena='%s,rol='%s'" +
                "where idEmpleado='%s'";
        sql=String.format(sql,e.getNombreEmpleado(),e.getContrasena(),e.getRol(),e.getIdEmpleado());
        int count=db.executeUpdate(sql);
        if(count==0){
            throw new Exception("Empleado no existe");
        }
    }
    
    public void actualizarFactura(Factura f) throws Exception{
        String sql="update Factura set fecha='%s',hora='%s',cancelada=%b,"+
                "despachada=%b,numFerreteria='%s',Cliente='%s',Empleado='%s'"+
                "where numFactura='%s'";
        sql=String.format(sql,f.getFecha(),f.getHora(),f.isCancelada(),
                f.isDepachada(),f.getNumFerreteria(),f.getIdCliente().getIdCliente(),
                f.getIdEmpleado().getIdEmpleado(),f.getNumFactura());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Factura no existe");
        }
    }
    
    public Producto ProductoGet(String codigo) throws Exception{
        String sql="select * from Producto where codigo='%s'";
        sql = String.format(sql,codigo);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            return producto(rs);
        }
        else{
            throw new Exception ("Producto no Existe");
        }
    }
    
    private Producto producto(ResultSet rs){
        try {
            Producto p= new Producto();
            p.setCodigo(rs.getString("codigo"));
            p.setNombreProducto(rs.getString("nombreProducto"));
            p.setPrecio(rs.getString("precio"));
            p.setCantExistencias(rs.getString("cantExistencias"));
            return p;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Cliente ClienteGet(String idCliente) throws Exception{
        String sql="select * from Cliente where idCliente='%s'";
        sql = String.format(sql,idCliente);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            return cliente(rs);
        }
        else{
            throw new Exception ("Cliente no Existe");
        }
    }
    
    private Cliente cliente(ResultSet rs){
        try {
            Cliente c = new Cliente();
            c.setIdCliente(rs.getString("idCliente"));
            c.setNombreCliente(rs.getString("nombreCliente"));
            c.setTelefonoCliente(rs.getString("telefonoCliente"));
            c.setDescuento(rs.getString("descuento"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Empleado EmpleadoGet(String idEmpleado) throws Exception{
        String sql = "Select * from Empleado where idEmpleado= '%s'";
        sql = String.format(sql,idEmpleado);
        ResultSet rs = db.executeQuery(sql);
        if(rs.next()){
            return empleado(rs);
        }
        else{
            throw new Exception("Empleado no existe");
        }
    }

    private Empleado empleado(ResultSet rs) {
        try {
            Empleado e = new Empleado();
            e.setIdEmpleado(rs.getString("idEmpleado"));
            e.setNombreEmpleado(rs.getString("nombreEmpleado"));
            e.setContrasena(rs.getString("contrasena"));
            e.setRol(rs.getString("rol"));
            return e;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Factura FacturaGet(String numFactura) throws Exception{
        String sql="select * from Factura where numFactura='%s'";
        sql = String.format(sql,numFactura);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            return factura(rs);
        }
        else{
            throw new Exception ("Factura no Existe");
        }
    }
    
    private Factura factura(ResultSet rs){
        try {
            Factura f = new Factura();
            f.setNumFactura(rs.getString("numFactura"));
            f.setFecha(rs.getString("fecha"));
            f.setHora(rs.getString("hora"));
            f.setCancelada(rs.getBoolean("cancelada"));
            f.setDepachada(rs.getBoolean("despachada"));
            f.setNumFerreteria(rs.getString("numFerreteria"));
            f.setIdCliente(cliente(rs));
            f.setIdEmpleado(empleado(rs));
            return f;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Lineas LineasGet(String numFactura1) throws Exception{
        String sql="select * from Lineas where numFactura1='%s'";
        sql = String.format(sql,numFactura1);
        ResultSet rs =  db.executeQuery(sql);
        if (rs.next()) {
            return lineas(rs);
        }
        else{
            throw new Exception ("Lineas no Existe");
        }
    }
     
    private Lineas lineas(ResultSet rs){
        Lineas l = new Lineas();
        l.setNumFactura(factura(rs));
        l.setCodigo(producto(rs));
        return l;
    }
    
   public List<Producto> BuscarProducto(Producto filtro){
        List<Producto> resultado = new ArrayList<Producto>();
        try {
            String sql="select * from Producto where nombreProducto like '%%%s%%'";
            sql=String.format(sql,filtro.getNombreProducto());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(producto(rs));
            }
        } catch (SQLException ex) { }
        return resultado;
    }
   
   public List<Producto> BuscarProducto1(Producto filtro){
        List<Producto> resultado5 = new ArrayList<Producto>();
        try {
            String sql="select * from Producto where codigo like '%%%s%%'";
            sql=String.format(sql,filtro.getCodigo());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                resultado5.add(producto(rs));
            }
        } catch (SQLException ex) { }
        return resultado5;
    }
   
   public List<Cliente> BuscarCliente(Cliente filtro){
        List<Cliente> resultado1 = new ArrayList<Cliente>();
        try {
            String sql="select * from cliente where idCliente like '%%%s%%'";
            sql=String.format(sql,filtro.getIdCliente());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                resultado1.add(cliente(rs));
            }
        } catch (SQLException ex) { }
        return resultado1;
    }
   
   public List<Cliente> BuscarCliente1(Cliente filtro){
        List<Cliente> resultado4 = new ArrayList<Cliente>();
        try {
            String sql="select * from cliente where nombreCliente like '%%%s%%'";
            sql=String.format(sql,filtro.getNombreCliente());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                resultado4.add(cliente(rs));
            }
        } catch (SQLException ex) { }
        return resultado4;
    }
   
   public List<Empleado> BuscarEmpleado(Empleado filtro){
        List<Empleado> resultado2 = new ArrayList<Empleado>();
        try {
            String sql="select * from Empleado where idEmpleado like '%%%s%%'";
            sql=String.format(sql,filtro.getIdEmpleado());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                resultado2.add(empleado(rs));
            }
        } catch (SQLException ex) { }
        return resultado2;
    } 
   
   public List<Empleado> BuscarEmpleado1(Empleado filtro){
        List<Empleado> resultado3 = new ArrayList<Empleado>();
        try {
            String sql="select * from Empleado where nombreEmpleado like '%%%s%%'";
            sql=String.format(sql,filtro.getNombreEmpleado());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                resultado3.add(empleado(rs));
            }
        } catch (SQLException ex) { }
        return resultado3;
    } 
   
   public List<Factura> BuscarFactura(Factura filtro){
        List<Factura> resultado6 = new ArrayList<Factura>();
        try {
            String sql="select * from Factura where numFactura like '%%%s%%'";
            sql=String.format(sql,filtro.getNumFactura());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                resultado6.add(factura(rs));
            }
        } catch (SQLException ex) { }
        return resultado6;
    } 
   
   public Collection<Cliente> ClienteGetAll(){
        Vector<Cliente> clientes=new Vector<Cliente>();
        try {
            String sql="select * from Cliente";
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                clientes.add(cliente(rs));
            }
        } catch (SQLException ex) { }
        return clientes;        
    }
   
   public Collection<Empleado> EmpleadoGetAll(){
     Vector<Empleado> empleados=new Vector<Empleado>();
        try {
            String sql="select * from Empleado";
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                empleados.add(empleado(rs));
            }
        } catch (SQLException ex) { }
        return empleados;   
   }

    public void close() {
        System.exit(0);
    }

    public List<Lineas> BuscarLineas(Lineas filtro){
        List<Lineas> resultado8 = new ArrayList<Lineas>();
        try {
            String sql="select * from Lineas where numFactura1 like '%%%s%%'";
            sql=String.format(sql,filtro.getNumFactura());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                resultado8.add(lineas(rs));
            }
        } catch (SQLException ex) { }
        return resultado8;
    }

}
