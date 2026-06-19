/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class FormPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormPrincipal.class.getName());

    /**
     * Creates new form FormPrincipal
     */
    public FormPrincipal() {
        initComponents();
        panelContenido.setLayout(new BorderLayout());
        panelContenido.removeAll();
        panelContenido.add(new PanelOrdenes(this),BorderLayout.CENTER);
        panelContenido.revalidate();
        panelContenido.repaint();
        
       
    }
    

    //Metodo para mostrar panel
    public void mostrarPanel(JPanel panel){

       panelContenido.removeAll();
    panelContenido.add(panel, BorderLayout.CENTER);
    panelContenido.revalidate();
    panelContenido.repaint();

}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSuperior = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PanelMenu = new javax.swing.JPanel();
        btnOrdenes = new javax.swing.JButton();
        btnCompras = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnServicios = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        panelContenido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LimiClean");
        setPreferredSize(new java.awt.Dimension(800, 600));

        panelSuperior.setBackground(new java.awt.Color(102, 153, 255));
        panelSuperior.setToolTipText("");
        panelSuperior.setPreferredSize(new java.awt.Dimension(120, 60));

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel1.setText("LimiClean");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(573, Short.MAX_VALUE))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        PanelMenu.setBackground(new java.awt.Color(153, 153, 153));
        PanelMenu.setPreferredSize(new java.awt.Dimension(220, 640));

        btnOrdenes.setText("Ordenes");
        btnOrdenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOrdenesMouseClicked(evt);
            }
        });
        btnOrdenes.addActionListener(this::btnOrdenesActionPerformed);

        btnCompras.setText("Registro Usuario");

        btnVentas.setText("Ventas");

        btnServicios.setText("Compra");

        btnSalir.setText("Salir");

        javax.swing.GroupLayout PanelMenuLayout = new javax.swing.GroupLayout(PanelMenu);
        PanelMenu.setLayout(PanelMenuLayout);
        PanelMenuLayout.setHorizontalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnOrdenes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCompras, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
            .addComponent(btnServicios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelMenuLayout.setVerticalGroup(
            PanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuLayout.createSequentialGroup()
                .addComponent(btnOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        panelContenido.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panelContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrdenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenesActionPerformed
            panelContenido.setLayout(new BorderLayout());
        panelContenido.removeAll();
        panelContenido.add(new PanelOrdenes(this),BorderLayout.NORTH);
        panelContenido.revalidate();
        panelContenido.repaint();
    }//GEN-LAST:event_btnOrdenesActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
           
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnOrdenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrdenesMouseClicked
        panelContenido.removeAll();
        panelContenido.add(new PanelOrdenes(this),BorderLayout.NORTH);
        panelContenido.revalidate();
        panelContenido.repaint();        
    }//GEN-LAST:event_btnOrdenesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FormPrincipal().setVisible(true));
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JButton btnCompras;
    private javax.swing.JButton btnOrdenes;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnServicios;
    private javax.swing.JButton btnVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelSuperior;
    // End of variables declaration//GEN-END:variables
}
