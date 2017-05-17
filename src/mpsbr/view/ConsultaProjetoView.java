/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.view;

import mpsbr.control.ProjetoControl;
import mpsbr.model.Projeto;

/**
 *
 * @author gabriela
 */
public class ConsultaProjetoView extends javax.swing.JPanel {

    /**
     * Creates new form CadastraProjetoView
     */
    public ConsultaProjetoView() {
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

        titleLabel = new javax.swing.JLabel();
        nomeLabel = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        descricaoLabel = new javax.swing.JLabel();
        clienteTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descricaoTextField = new javax.swing.JTextArea();
        clienteLabel = new javax.swing.JLabel();
        gerenteLabel = new javax.swing.JLabel();
        gerenteTextField = new javax.swing.JTextField();
        cadastrarbutton = new javax.swing.JButton();
        faseLabel = new javax.swing.JLabel();
        faseComboBox = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        titleLabel.setText("Consultar Projeto");
        add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, -1, -1));

        nomeLabel.setText("Nome:");
        add(nomeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        nomeTextField.setEditable(false);
        nomeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeTextFieldActionPerformed(evt);
            }
        });
        add(nomeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 530, -1));

        descricaoLabel.setText("Descrição:");
        add(descricaoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        clienteTextField.setEditable(false);
        add(clienteTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 530, -1));

        descricaoTextField.setEditable(false);
        descricaoTextField.setColumns(20);
        descricaoTextField.setRows(5);
        jScrollPane1.setViewportView(descricaoTextField);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 530, -1));

        clienteLabel.setText("Cliente:");
        add(clienteLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, -1, -1));

        gerenteLabel.setText("Gerente:");
        add(gerenteLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, -1, -1));

        gerenteTextField.setEditable(false);
        add(gerenteTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 530, -1));

        cadastrarbutton.setText("Ok");
        cadastrarbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarbuttonActionPerformed(evt);
            }
        });
        add(cadastrarbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, -1, -1));

        faseLabel.setText("Fase de Desenvolvimento:");
        add(faseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, -1, -1));

        faseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CONCLUIDO", "EM DESENVOLVIMENTO" }));
        faseComboBox.setSelectedItem("CONCLUIDO");
        faseComboBox.setEnabled(false);
        faseComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faseComboBoxActionPerformed(evt);
            }
        });
        add(faseComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 440, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void faseComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faseComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_faseComboBoxActionPerformed

    private void cadastrarbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarbuttonActionPerformed
        ProjetoControl pc = ProjetoControl.getInstance();
        pc.getBpv().loadScreen();
        MainView.showPanel(MainView.BUSCA_PRJ);
    }//GEN-LAST:event_cadastrarbuttonActionPerformed

    private void nomeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarbutton;
    private javax.swing.JLabel clienteLabel;
    private javax.swing.JTextField clienteTextField;
    private javax.swing.JLabel descricaoLabel;
    private javax.swing.JTextArea descricaoTextField;
    private javax.swing.JComboBox<String> faseComboBox;
    private javax.swing.JLabel faseLabel;
    private javax.swing.JLabel gerenteLabel;
    private javax.swing.JTextField gerenteTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

    public void loadScreen(Projeto proj) {
        this.nomeTextField.setText(proj.getNome());
        this.descricaoTextField.setText(proj.getDescricao());
        this.clienteTextField.setText(proj.getCliente());
        this.gerenteTextField.setText(proj.getGerente());
        this.faseComboBox.setSelectedItem(proj.getFaseDesenv());
        this.validate();
        this.repaint();
    }

}
