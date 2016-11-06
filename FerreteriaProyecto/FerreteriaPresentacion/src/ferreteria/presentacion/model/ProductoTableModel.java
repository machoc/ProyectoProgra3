/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.presentacion.model;

import ferreteria.entities.Producto;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author luisalejandro
 */
public class ProductoTableModel extends AbstractTableModel {
    
    List<Producto> rows;
    int[] cols;

    public ProductoTableModel(int[] cols, List<Producto> rows) {
        this.rows = rows;
        this.cols = cols;
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
        Producto producto = rows.get(row);
        switch (cols[col]){
            case CODIGO: return producto.getCodigo();
            case NOMBRE: return producto.getNombreProducto();
            case PRECIO: return producto.getPrecio();
            case CANTIDAD: return producto.getCantExistencias();
            default: return "";
        }
    }
    
    public Producto getRowAt(int row) {
        return rows.get(row);
    }
    
    public static final int CODIGO=0;
    public static final int NOMBRE=1;
    public static final int PRECIO=2;
    public static final int CANTIDAD=3; 
    
    String[] colNames = new String[4];
    
    private void initColNames(){
        colNames[CODIGO]= "Codigo";
        colNames[NOMBRE]= "Nombre Producto";
        colNames[PRECIO]= "Precio";
        colNames[CANTIDAD]= "Cantidad";
    }
    
}
