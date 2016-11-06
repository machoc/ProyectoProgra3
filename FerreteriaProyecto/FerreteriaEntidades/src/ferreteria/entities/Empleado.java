/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.entities;

/**
 *
 * @author luisalejandro
 */
public class Empleado {
   private String idEmpleado;
   private String nombreEmpleado;
   private String contrasena;
   private String rol;

    public Empleado(String idEmpleado, String nombreEmpleado, String contrasena,String rol) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public Empleado() {
        this.idEmpleado = "";
        this.nombreEmpleado = "";
        this.contrasena = "";
        this.rol = "";
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
  
}
