/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.presentacion.model;

import ferreteria.entities.Cliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author luisalejandro
 */
public class ClienteTableModel extends AbstractTableModel{

   List<Cliente> rows;
    int[] cols;

    public  ClienteTableModel(int[] cols, List<Cliente> rows){
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
        Cliente cliente = rows.get(row);
        switch (cols[col]){
            case ID: return cliente.getIdCliente();
            case NOMBRE: return cliente.getNombreCliente();
            case TELEFONO: return cliente.getTelefonoCliente();
            case DESCUENTO: return cliente.getDescuento();
            default: return "";
        }
    }    

    public Cliente getRowAt(int row) {
        return rows.get(row);
    }
    
    public static final int ID=0;
    public static final int NOMBRE=1;
    public static final int TELEFONO=2;
    public static final int DESCUENTO=3;
  
    String[] colNames = new String[4];
    
    private void initColNames(){
        colNames[ID]= "Id";
        colNames[NOMBRE]= "Nombre";
        colNames[TELEFONO]= "Telefono";
        colNames[DESCUENTO]= "Descuento";
    }
    
}
