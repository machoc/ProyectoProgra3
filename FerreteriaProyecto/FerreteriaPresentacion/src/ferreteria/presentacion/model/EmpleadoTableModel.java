/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.presentacion.model;

import ferreteria.entities.Empleado;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author luisalejandro
 */
public class EmpleadoTableModel extends AbstractTableModel{
    List<Empleado> rows;
    int[] cols;

    public  EmpleadoTableModel(int[] cols, List<Empleado> rows){
        this.cols=cols;
        this.rows=rows;
        initColNames();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public String getColumnName(int col){
        return colNames[cols[col]];
    }  
    
    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        Empleado empleado = rows.get(row);
        switch (cols[col]){
            case ID: return empleado.getIdEmpleado();
            case NOMBRE: return empleado.getNombreEmpleado();
            case CONTRASENA: return empleado.getContrasena();
            case ROL: return empleado.getRol();
            default: return "";
        }
    }   

    public Empleado getRowAt(int row) {
        return rows.get(row);
    }
    
    public static final int ID=0;
    public static final int NOMBRE=1;
    public static final int CONTRASENA=2;
    public static final int ROL=3; 
    
    String[] colNames = new String[4];
    
    private void initColNames(){
        colNames[ID]= "Id";
        colNames[NOMBRE]= "Nombre";
        colNames[CONTRASENA]= "Contrasena";
        colNames[ROL]= "Rol";
    }
    
}
