/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.view;

import java.util.List;
import mpsbr.DAO.ProjetoDAO;
import mpsbr.DAOImpl.ProjetoDAOImpl;
import mpsbr.control.ProjetoControl;
import mpsbr.model.Projeto;

/**
 *
 * @author gabriela
 */
public class BuscaProjetoView extends javax.swing.JPanel {

    List<Projeto> projetos = null;
    /**
     * Creates new form BuscaProjetoView
     */
    public BuscaProjetoView() {
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
        projetoLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        buscarButton = new javax.swing.JButton();
        projetoComboBox = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Buscar Projeto");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, -1));

        projetoLabel.setText("Selecione o projeto:");
        add(projetoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        cancelButton.setText("Cancelar");
        add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, -1, -1));

        buscarButton.setText("Buscar Informações");
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });
        add(buscarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 150, -1));

        projetoComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                projetoComboBoxItemStateChanged(evt);
            }
        });
        projetoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projetoComboBoxActionPerformed(evt);
            }
        });
        add(projetoComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 390, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void projetoComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_projetoComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_projetoComboBoxItemStateChanged

    private void projetoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projetoComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projetoComboBoxActionPerformed

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        ProjetoControl pc = ProjetoControl.getInstance();
        pc.getCopv().loadScreen(projetos.get(projetoComboBox.getSelectedIndex()));
        MainView.showPanel(MainView.CONSULTA_PRJ);
    }//GEN-LAST:event_buscarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> projetoComboBox;
    private javax.swing.JLabel projetoLabel;
    // End of variables declaration//GEN-END:variables

    public void loadScreen() {
        this.projetoComboBox.removeAllItems();
        ProjetoDAO pd = new ProjetoDAOImpl();
        projetos = pd.getAllProjeto();
        for (Projeto proj : projetos) {
            this.projetoComboBox.addItem(proj.getNome());
        }
        this.validate();
        this.repaint();
    }
}
