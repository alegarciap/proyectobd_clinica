/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.MedicoDAO;
import conexion.Conexion;
import conexion.IConexion;
import entidades.Medico;
import excepciones.PersistenciaException;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Abraham Coronel Bringas
 */
public class EstadoMedico extends javax.swing.JFrame {

    private MedicoDAO medicoDAO;
    private Medico medico;

    // Constructor que recibe el objeto Medico
    public EstadoMedico(int id_medico) {
        initComponents();
        IConexion conexion = new Conexion();
        medicoDAO = new MedicoDAO(conexion);
        try {
            medico = medicoDAO.obtenerMedico(id_medico); // Obtener el médico usando el id
        } catch (SQLException | PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener el médico: " + ex.getMessage());
        }
    }

    // Método para desactivar el médico
    private void desactivarMedico() {
        try {
            medicoDAO.desactivarMedico(medico);
            JOptionPane.showMessageDialog(this, "Médico desactivado exitosamente.");
            btnActivo.setEnabled(true); // Habilitamos el botón de activar
            btnInactivo.setEnabled(false); // Deshabilitamos el botón de inactivo
        } catch (SQLException | PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, "Error al desactivar el médico: " + ex.getMessage());
        }
    }

    // Método para activar el médico
    private void activarMedico() {
        try {
            medicoDAO.activarMedico(medico);
            JOptionPane.showMessageDialog(this, "Médico activado exitosamente.");
            btnActivo.setEnabled(false); // Deshabilitamos el botón de activo
            btnInactivo.setEnabled(true); // Habilitamos el botón de inactivo
        } catch (SQLException | PersistenciaException ex) {
            JOptionPane.showMessageDialog(this, "Error al activar el médico: " + ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnActivo = new javax.swing.JButton();
        btnInactivo = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1280, 720));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Clinica BD");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Estado");

        btnActivo.setBackground(new java.awt.Color(0, 255, 0));
        btnActivo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActivo.setForeground(new java.awt.Color(255, 255, 255));
        btnActivo.setText("Activo");
        btnActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivoActionPerformed(evt);
            }
        });

        btnInactivo.setBackground(new java.awt.Color(255, 0, 0));
        btnInactivo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInactivo.setForeground(new java.awt.Color(255, 255, 255));
        btnInactivo.setText("Inactivo");
        btnInactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInactivoActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(346, 346, 346)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(396, 396, 396)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(btnActivo)
                        .addGap(103, 103, 103)
                        .addComponent(btnInactivo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jButton3)))
                .addContainerGap(324, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActivo)
                    .addComponent(btnInactivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivoActionPerformed
        activarMedico();
    }//GEN-LAST:event_btnActivoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnInactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInactivoActionPerformed
        desactivarMedico();
    }//GEN-LAST:event_btnInactivoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int idMedico = 1; // Aquí puedes cambiar este valor por cualquier ID de médico
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstadoMedico(idMedico).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivo;
    private javax.swing.JButton btnInactivo;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
