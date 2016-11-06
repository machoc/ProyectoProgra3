/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.presentacion.model;

import ferreteria.entities.Lineas;
import ferreteria.entities.Producto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author luisalejandro
 */
public class LineaTableModel extends AbstractTableModel {

    List<Lineas> rows;
    int[] cols;

    public LineaTableModel(int[] cols,List<Lineas> rows) {
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
        Lineas linea = rows.get(row);
        switch (cols[col]){
            case NUM_FACTURA: return linea.getNumFactura();
            case CODIGO: return linea.getCodigo(); 
            default: return "";
        }
    }   

    public Lineas getRowAt(int row) {
        return rows.get(row);
    }
    
    public static final int NUM_FACTURA=0;
    public static final int CODIGO=1; 
    
    String[] colNames = new String[2];
    
    private void initColNames(){
        colNames[NUM_FACTURA]= "Numero Factura";
        colNames[CODIGO]= "Codigo";
    }
    
}
