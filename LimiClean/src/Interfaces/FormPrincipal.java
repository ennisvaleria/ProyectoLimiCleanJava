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

    private int xMouse, yMouse;
    private String nombreCompleto;
    private String rol;
    public FormPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public FormPrincipal(String nombreCompleto, String rol) 
    {
    initComponents();
    setLocationRelativeTo(null);
    jLabel4.setText(nombreCompleto + ",");
    jLabel7.setText(rol);
    }
    

    //Metodo para mostrar panel
    public void mostrarPanel(JPanel panel)
    {
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
        btnProductos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnTipos = new javax.swing.JButton();
        btnInsumos2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        label1 = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

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
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelContenido.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 800, 750));

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
        PanelMenu.add(btnOrdenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 240, 45));

        btnEmpleados.setBackground(new java.awt.Color(38, 38, 36));
        btnEmpleados.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEmpleados.setForeground(new java.awt.Color(255, 255, 255));
        btnEmpleados.setText("Empleados");
        btnEmpleados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEmpleados.addActionListener(this::btnEmpleadosActionPerformed);
        PanelMenu.add(btnEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 240, 40));

        btnVentas.setBackground(new java.awt.Color(38, 38, 36));
        btnVentas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnVentas.setText("Ventas");
        btnVentas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVentas.addActionListener(this::btnVentasActionPerformed);
        PanelMenu.add(btnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 240, 41));

        btnOrdenesCompra.setBackground(new java.awt.Color(38, 38, 36));
        btnOrdenesCompra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnOrdenesCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnOrdenesCompra.setText("Órdenes de compra");
        btnOrdenesCompra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnOrdenesCompra.addActionListener(this::btnOrdenesCompraActionPerformed);
        PanelMenu.add(btnOrdenesCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 240, 50));

        btnSalir.setBackground(new java.awt.Color(38, 38, 36));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(238, 136, 132));
        btnSalir.setText("Cerrar sesión");
        btnSalir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalir.addActionListener(this::btnSalirActionPerformed);
        PanelMenu.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 760, 240, 50));

        jLabel2.setForeground(new java.awt.Color(136, 134, 127));
        jLabel2.setText("OPERACIONES");
        PanelMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 87, -1));

        jLabel3.setForeground(new java.awt.Color(136, 134, 127));
        jLabel3.setText("REGISTROS");
        PanelMenu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 87, -1));

        btnProveedores.setBackground(new java.awt.Color(38, 38, 36));
        btnProveedores.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnProveedores.setForeground(new java.awt.Color(255, 255, 255));
        btnProveedores.setText("Proveedores");
        btnProveedores.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProveedores.addActionListener(this::btnProveedoresActionPerformed);
        PanelMenu.add(btnProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 240, 39));

        btnClientes.setBackground(new java.awt.Color(39, 39, 37));
        btnClientes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnClientes.setText("Clientes");
        btnClientes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClientes.addActionListener(this::btnClientesActionPerformed);
        PanelMenu.add(btnClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 240, 40));

        btnProductos.setBackground(new java.awt.Color(38, 38, 36));
        btnProductos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnProductos.setText("Productos");
        btnProductos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProductos.addActionListener(this::btnProductosActionPerformed);
        PanelMenu.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 240, 39));

        jLabel5.setForeground(new java.awt.Color(136, 134, 127));
        jLabel5.setText("COMPRAS");
        PanelMenu.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 87, -1));

        btnTipos.setBackground(new java.awt.Color(38, 38, 36));
        btnTipos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTipos.setForeground(new java.awt.Color(255, 255, 255));
        btnTipos.setText("Tipos");
        btnTipos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTipos.addActionListener(this::btnTiposActionPerformed);
        PanelMenu.add(btnTipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 240, 39));

        btnInsumos2.setBackground(new java.awt.Color(38, 38, 36));
        btnInsumos2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnInsumos2.setForeground(new java.awt.Color(255, 255, 255));
        btnInsumos2.setText("Insumos");
        btnInsumos2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInsumos2.addActionListener(this::btnInsumos2ActionPerformed);
        PanelMenu.add(btnInsumos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 240, 39));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("jLabel4");
        PanelMenu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("jLabel7");
        PanelMenu.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        label1.setForeground(new java.awt.Color(136, 134, 127));
        label1.setText("__________________________________________");
        PanelMenu.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 240, -1));

        getContentPane().add(PanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 236, 810));

        jPanel1.setBackground(new java.awt.Color(0, 27, 139));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Lavandería LiMiClean");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addContainerGap(696, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 60));

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

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        mostrarPanel(new PanelProductos(this));
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnTiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTiposActionPerformed
        // TODO add your handling code here:
        mostrarPanel(new PanelTipos(this));
    }//GEN-LAST:event_btnTiposActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
       this.dispose();
       Login frm = new Login();
       frm.setVisible(true);
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

    private void btnInsumos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsumos2ActionPerformed
        // TODO add your handling code here:
        mostrarPanel(new PanelInsumo(this));
    }//GEN-LAST:event_btnInsumos2ActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        setLocation(
        evt.getXOnScreen() - xMouse,
        evt.getYOnScreen() - yMouse
    );
    }//GEN-LAST:event_jPanel1MouseDragged

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
    private javax.swing.JButton btnInsumos2;
    private javax.swing.JButton btnOrdenes;
    private javax.swing.JButton btnOrdenesCompra;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTipos;
    private javax.swing.JButton btnVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label label1;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JPanel panelSuperior;
    // End of variables declaration//GEN-END:variables
}
