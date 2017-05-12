/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.view.cadastraNivel;

import mpsbr.control.NivelControl;

/**
 *
 * @author gabriela
 */
public class SelecionaNivelConsultaView extends javax.swing.JPanel {
    
    public static final String NOME = "cadastraNivelView";
    
    /**
     * Creates new form cadastraNivelView
     */
    public SelecionaNivelConsultaView() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nivelComboBox = new javax.swing.JComboBox<>();
        ConsultaButton = new javax.swing.JToggleButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Consulta de Nível");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        jLabel2.setText("Selecione o nível:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        nivelComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nível A", "Nível B", "Nível C", "Nível D", "Nível E", "Nível F", "Nível G" }));
        add(nivelComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 150, -1));

        ConsultaButton.setText("Consultar");
        ConsultaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultaButtonActionPerformed(evt);
            }
        });
        add(ConsultaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void ConsultaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaButtonActionPerformed
        String nivel = (String) this.nivelComboBox.getSelectedItem();
        NivelControl.getInstance().startConsultaNivel(nivel);
    }//GEN-LAST:event_ConsultaButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ConsultaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> nivelComboBox;
    // End of variables declaration//GEN-END:variables
}