/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.presentacion.model;

import ferreteria.entities.Factura;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author luisalejandro
 */
public class FacturaTableModel extends AbstractTableModel {

    List<Factura> rows;
    int[] cols;

    public  FacturaTableModel(int[] cols, List<Factura> rows){
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
    public Class<?> getColumnClass(int col){
        switch (cols[col]){
            case CANCELADA: return Boolean.class;
            case DESPACHADA: return Boolean.class;
            default: return super.getColumnClass(col);
        }    
    }    
    
    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        Factura factura = rows.get(row);
        switch (cols[col]){
            case NUMERO: return factura.getNumFactura();
            case FECHA: return factura.getFecha();
            case HORA: return factura.getHora();
            case CANCELADA: return factura.isCancelada();
            case DESPACHADA: return factura.isDepachada();
            case NUM_FERRETERIA: return factura.getNumFerreteria();
            case CLIENTE: return factura.getIdCliente();
            case EMPLEADO: return factura.getIdEmpleado();
            default: return "";
        }
    }    

    public Factura getRowAt(int row) {
        return rows.get(row);
    }
    
    public static final int NUMERO=0;
    public static final int FECHA=1;
    public static final int HORA=2;
    public static final int CANCELADA=3;
    public static final int DESPACHADA=4;
    public static final int NUM_FERRETERIA=5;
    public static final int CLIENTE=6;
    public static final int EMPLEADO=7;  
    
    String[] colNames = new String[8];
    private void initColNames(){
        colNames[NUMERO]= "Numero Factura";
        colNames[FECHA]= "Fecha";
        colNames[HORA]= "Hora";
        colNames[CANCELADA]= "Cancelada";
        colNames[DESPACHADA]= "Despachada";
        colNames[NUM_FERRETERIA]= "Numero Ferreteria";
        colNames[CLIENTE]= "Cliente";
        colNames[EMPLEADO]= "Empleado";
    }
    
}
