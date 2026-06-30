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
        panelContenido = new javax.swing.JPanel();
        PanelMenu = new javax.swing.JPanel();
        btnOrdenes = new javax.swing.JButton();
        btnEmpleados = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnOrdenesCompra = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnProveedores = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnProductos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnInsumos = new javax.swing.JButton();
        label1 = new java.awt.Label();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        panelSuperior.setBackground(new java.awt.Color(24, 95, 165));
        panelSuperior.setToolTipText("");
        panelSuperior.setPreferredSize(new java.awt.Dimension(120, 60));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LimiClean - Sistema de gestión");
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
                .addGap(167, 167, 167)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LimiClean");
        setPreferredSize(new java.awt.Dimension(1200, 1000));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelContenido.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 810, 830));

        PanelMenu.setBackground(new java.awt.Color(38, 38, 36));
        PanelMenu.setPreferredSize(new java.awt.Dimension(220, 640));
        PanelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOrdenes.setBackground(new java.awt.Color(38, 38, 36));
        btnOrdenes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnOrdenes.setForeground(new java.awt.Color(255, 255, 255));
        btnOrdenes.setText("Órdenes de lavado");
        btnOrdenes.setActionCommand("Ordenes");
        btnOrdenes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnOrdenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOrdenesMouseClicked(evt);
            }
        });
        btnOrdenes.addActionListener(this::btnOrdenesActionPerformed);
        PanelMenu.add(btnOrdenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 164, 200, 45));

        btnEmpleados.setBackground(new java.awt.Color(38, 38, 36));
        btnEmpleados.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        btnEmpleados.setText("Empleados");
        btnEmpleados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEmpleados.addActionListener(this::btnEmpleadosActionPerformed);
        PanelMenu.add(btnEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 200, 44));

        btnVentas.setBackground(new java.awt.Color(38, 38, 36));
        btnVentas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnVentas.setText("Ventas");
        btnVentas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVentas.addActionListener(this::btnVentasActionPerformed);
        PanelMenu.add(btnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 215, 200, 41));

        btnOrdenesCompra.setBackground(new java.awt.Color(38, 38, 36));
        btnOrdenesCompra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnOrdenesCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnOrdenesCompra.setText("Órdenes de compra");
        btnOrdenesCompra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnOrdenesCompra.addActionListener(this::btnOrdenesCompraActionPerformed);
        PanelMenu.add(btnOrdenesCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 502, 200, 36));

        btnSalir.setBackground(new java.awt.Color(38, 38, 36));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(238, 136, 132));
        btnSalir.setText("Cerrar sesión");
        btnSalir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalir.addActionListener(this::btnSalirActionPerformed);
        PanelMenu.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 690, 210, 37));

        jLabel2.setForeground(new java.awt.Color(136, 134, 127));
        jLabel2.setText("OPERACIONES");
        PanelMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 142, 87, -1));

        jLabel3.setForeground(new java.awt.Color(136, 134, 127));
        jLabel3.setText("REGISTROS");
        PanelMenu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 262, 87, -1));

        btnProveedores.setBackground(new java.awt.Color(38, 38, 36));
        btnProveedores.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnProveedores.setForeground(new java.awt.Color(255, 255, 255));
        btnProveedores.setText("Proveedores");
        btnProveedores.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProveedores.addActionListener(this::btnProveedoresActionPerformed);
        PanelMenu.add(btnProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 429, 200, 39));

        btnClientes.setBackground(new java.awt.Color(39, 39, 37));
        btnClientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnClientes.setText("Clientes");
        btnClientes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClientes.addActionListener(this::btnClientesActionPerformed);
        PanelMenu.add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 200, 44));

        btnReportes.setBackground(new java.awt.Color(38, 38, 36));
        btnReportes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes.setText("Reportes");
        btnReportes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnReportes.addActionListener(this::btnReportesActionPerformed);
        PanelMenu.add(btnReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 611, 200, 39));

        jLabel4.setForeground(new java.awt.Color(136, 134, 127));
        jLabel4.setText("REPORTES");
        PanelMenu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 589, 87, -1));

        btnProductos.setBackground(new java.awt.Color(38, 38, 36));
        btnProductos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnProductos.setText("Productos");
        btnProductos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProductos.addActionListener(this::btnProductosActionPerformed);
        PanelMenu.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 384, 200, 39));

        jLabel5.setForeground(new java.awt.Color(136, 134, 127));
        jLabel5.setText("COMPRAS");
        PanelMenu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 87, -1));

        btnInsumos.setBackground(new java.awt.Color(38, 38, 36));
        btnInsumos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnInsumos.setForeground(new java.awt.Color(255, 255, 255));
        btnInsumos.setText("Insumos");
        btnInsumos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInsumos.addActionListener(this::btnInsumosActionPerformed);
        PanelMenu.add(btnInsumos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 544, 200, 39));

        label1.setForeground(new java.awt.Color(136, 134, 127));
        label1.setText("__________________________________________");
        PanelMenu.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 240, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("NOMBRE ADMINISTRADOR");
        PanelMenu.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ROL");
        PanelMenu.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("FOTO");
        PanelMenu.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        getContentPane().add(PanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 74, 236, 830));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrdenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenesActionPerformed
            mostrarPanel(new PanelOrdenes(this));
    }//GEN-LAST:event_btnOrdenesActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
           
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnOrdenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrdenesMouseClicked

        panelContenido.add(new PanelOrdenes(this));      
    }//GEN-LAST:event_btnOrdenesMouseClicked

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
       mostrarPanel(new PanelProveedores(this));
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
       mostrarPanel(new PanelClientes(this));
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        mostrarPanel(new PanelProductos(this));
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsumosActionPerformed
        // TODO add your handling code here:
        mostrarPanel(new PanelInsumo(this));
    }//GEN-LAST:event_btnInsumosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        mostrarPanel(new PanelVentas(this));
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        mostrarPanel(new PanelEmpleados(this));
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void btnOrdenesCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenesCompraActionPerformed
        mostrarPanel(new PanelOrdenesCompra(this));
    }//GEN-LAST:event_btnOrdenesCompraActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FormPrincipal().setVisible(true));
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnInsumos;
    private javax.swing.JButton btnOrdenes;
    private javax.swing.JButton btnOrdenesCompra;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private java.awt.Label label1;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelSuperior;
    // End of variables declaration//GEN-END:variables
}
