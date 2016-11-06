/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.presentacion.view;

import ferreteria.Application;
import ferreteria.presentacion.controller.ProductosController;
import ferreteria.presentacion.model.ProductosModel;
import java.util.Observer;
import javax.swing.JOptionPane;


/**
 *
 * @author luisalejandro
 */
public class ProductosView extends javax.swing.JInternalFrame implements Observer{
    
    ProductosController controller;
    ProductosModel model;

    public void setController(ProductosController controller) {
        this.controller = controller;
    }

    public ProductosController getController() {
        return controller;
    }

    public void setModel(ProductosModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public ProductosModel getModel() {
        return model;
    }
    
    @Override
   public void update(java.util.Observable updatedModel,Object parametros){
       nombreFld.setText(model.getFilter().getNombreProducto());
       if (model.getErrores().get("nombreFld")!=null){
            nombreLbl.setBorder(Application.BORDER_ERROR);
            nombreLbl.setToolTipText(model.getErrores().get("nombreFld"));
        }
        else{
            nombreLbl.setBorder(null);
            nombreLbl.setToolTipText("");
        }
       
       productosFld.setModel(model.getProductos());
       this.revalidate();
        if (!model.getMensaje().equals("")){
            JOptionPane.showMessageDialog(this, model.getMensaje(), "",JOptionPane.INFORMATION_MESSAGE);
        }       
   }
    /**
     * Creates new form PersonasView
     */
    public ProductosView() {
        super("",false,true);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreLbl = new javax.swing.JLabel();
        nombreFld = new javax.swing.JTextField();
        buscarFld = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productosFld = new javax.swing.JTable();
        agregarFld = new javax.swing.JButton();
        eliminarBtn = new javax.swing.JButton();
        coLbl = new javax.swing.JLabel();
        coFld = new javax.swing.JTextField();
        coBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("PRODUCTOS");

        nombreLbl.setText("Nombre");

        buscarFld.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ferreteria/presentacion/icons/search.png"))); // NOI18N
        buscarFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarFldActionPerformed(evt);
            }
        });

        jScrollPane1.setPreferredSize(new java.awt.Dimension(100, 100));

        productosFld.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        productosFld.setRowHeight(25);
        productosFld.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        productosFld.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productosFldMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productosFld);

        agregarFld.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ferreteria/presentacion/icons/productoagregar_converted.png"))); // NOI18N
        agregarFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarFldActionPerformed(evt);
            }
        });

        eliminarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ferreteria/presentacion/icons/images.png"))); // NOI18N
        eliminarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBtnActionPerformed(evt);
            }
        });

        coLbl.setText("Codigo");

        coBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ferreteria/presentacion/icons/search.png"))); // NOI18N
        coBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(eliminarBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(nombreLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nombreFld, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarFld, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(coLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coFld, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(agregarFld, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nombreLbl)
                                    .addComponent(nombreFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(coBtn)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(coLbl)
                                        .addComponent(coFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(1, 1, 1)
                        .addComponent(agregarFld))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buscarFld)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(eliminarBtn)))
                .addContainerGap(147, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarFldActionPerformed
      controller.buscarNombre();
    }//GEN-LAST:event_buscarFldActionPerformed

    private void agregarFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarFldActionPerformed
        Application.PRODUCTO_VIEW.setLocation(this.agregarFld.getLocationOnScreen());
        controller.agregar();
    }//GEN-LAST:event_agregarFldActionPerformed

    private void productosFldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productosFldMouseClicked
      if (evt.getClickCount() == 2) {
        int row = this.productosFld.getSelectedRow();
        Application.PRODUCTO_VIEW.setLocation(evt.getLocationOnScreen());
        controller.editar(row);
      }
    }//GEN-LAST:event_productosFldMouseClicked

    private void eliminarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBtnActionPerformed
       int row = this.productosFld.getSelectedRow();
        controller.borrar(row);
    }//GEN-LAST:event_eliminarBtnActionPerformed

    private void coBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coBtnActionPerformed
        controller.buscarCodigo();
    }//GEN-LAST:event_coBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProductosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductosView().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarFld;
    private javax.swing.JButton buscarFld;
    private javax.swing.JButton coBtn;
    public javax.swing.JTextField coFld;
    private javax.swing.JLabel coLbl;
    private javax.swing.JButton eliminarBtn;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField nombreFld;
    private javax.swing.JLabel nombreLbl;
    public javax.swing.JTable productosFld;
    // End of variables declaration//GEN-END:variables
}