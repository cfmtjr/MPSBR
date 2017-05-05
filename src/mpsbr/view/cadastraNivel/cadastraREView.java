/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.view.cadastraNivel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mpsbr.control.NivelControl;

/**
 *
 * @author gabriela
 */
public class cadastraREView extends javax.swing.JPanel {

    private List<String> niveis;
    
    
    /**
     * Creates new form cadastraREview
     */
    public cadastraREView() {
        this.setNiveis(new ArrayList<String>());
        initComponents();
    }

    public List<String> getNiveis() {
        return niveis;
    }

    public void setNiveis(List<String> niveis) {
        this.niveis = niveis;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        codigoTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descricaoTextArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        cancelarButton = new javax.swing.JButton();
        finalizarButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        NivGComboBox = new javax.swing.JCheckBox();
        NivAComboBox = new javax.swing.JCheckBox();
        NivBComboBox = new javax.swing.JCheckBox();
        NivCComboBox = new javax.swing.JCheckBox();
        NivDComboBox = new javax.swing.JCheckBox();
        NivEComboBox = new javax.swing.JCheckBox();
        NivFComboBox = new javax.swing.JCheckBox();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Cadastro de Nível");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jLabel3.setText("Código:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel4.setText("Nome:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel5.setText("Descrição: ");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));
        add(nomeTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 350, -1));
        add(codigoTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 100, 100, 20));

        descricaoTextArea.setColumns(20);
        descricaoTextArea.setRows(5);
        jScrollPane1.setViewportView(descricaoTextArea);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 350, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setText("Cadastro de Resultado Esperado");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });
        add(cancelarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, -1, -1));

        finalizarButton.setText("Finalizar");
        finalizarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarButtonActionPerformed(evt);
            }
        });
        add(finalizarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, -1, -1));

        jLabel6.setText("RE válido para os níveis: ");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        NivGComboBox.setText("G");
        NivGComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NivGComboBoxActionPerformed(evt);
            }
        });
        add(NivGComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, -1, -1));

        NivAComboBox.setText("A");
        NivAComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NivAComboBoxActionPerformed(evt);
            }
        });
        add(NivAComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        NivBComboBox.setText("B");
        NivBComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NivBComboBoxActionPerformed(evt);
            }
        });
        add(NivBComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        NivCComboBox.setText("C");
        NivCComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NivCComboBoxActionPerformed(evt);
            }
        });
        add(NivCComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, -1, -1));

        NivDComboBox.setText("D");
        NivDComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NivDComboBoxActionPerformed(evt);
            }
        });
        add(NivDComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, -1, -1));

        NivEComboBox.setText("E");
        NivEComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NivEComboBoxActionPerformed(evt);
            }
        });
        add(NivEComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, -1, -1));

        NivFComboBox.setText("F");
        NivFComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NivFComboBoxActionPerformed(evt);
            }
        });
        add(NivFComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void finalizarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarButtonActionPerformed
        
        String codigo = this.codigoTextField.getText();
        String desc = this.descricaoTextArea.getText();
        String nome = this.nomeTextField.getText();
        
        if(codigo.equals("")||desc.equals("")||nome.equals(""))
        {
            JOptionPane.showMessageDialog(new JFrame(), "Preencha todos os campos");
        }
        else if(this.getNiveis().isEmpty())
        {
            JOptionPane.showMessageDialog(new JFrame(), "Escolha ao menos um nivel");
        }
        else
        {
            NivelControl.getInstance().cadastroRE(codigo,nome,desc,this.getNiveis());
        }
        
    }//GEN-LAST:event_finalizarButtonActionPerformed

    private void NivGComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NivGComboBoxActionPerformed
        // TODO add your handling code here:
        this.changeNivel("G",this.NivGComboBox.isSelected());
    }//GEN-LAST:event_NivGComboBoxActionPerformed

    private void NivAComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NivAComboBoxActionPerformed
        // TODO add your handling code here:
        this.changeNivel("A",this.NivAComboBox.isSelected());
    }//GEN-LAST:event_NivAComboBoxActionPerformed

    private void NivBComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NivBComboBoxActionPerformed
        // TODO add your handling code here:
        this.changeNivel("B",this.NivBComboBox.isSelected());
    }//GEN-LAST:event_NivBComboBoxActionPerformed

    private void NivCComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NivCComboBoxActionPerformed
        // TODO add your handling code here:
        this.changeNivel("C",this.NivCComboBox.isSelected());
    }//GEN-LAST:event_NivCComboBoxActionPerformed

    private void NivDComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NivDComboBoxActionPerformed
        // TODO add your handling code here:
        
        this.changeNivel("D",this.NivDComboBox.isSelected());
    }//GEN-LAST:event_NivDComboBoxActionPerformed

    private void NivEComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NivEComboBoxActionPerformed
        // TODO add your handling code here:
        this.changeNivel("E",this.NivEComboBox.isSelected());
    }//GEN-LAST:event_NivEComboBoxActionPerformed

    private void NivFComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NivFComboBoxActionPerformed
        // TODO add your handling code here:
        this.changeNivel("F",this.NivFComboBox.isSelected());
    }//GEN-LAST:event_NivFComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox NivAComboBox;
    private javax.swing.JCheckBox NivBComboBox;
    private javax.swing.JCheckBox NivCComboBox;
    private javax.swing.JCheckBox NivDComboBox;
    private javax.swing.JCheckBox NivEComboBox;
    private javax.swing.JCheckBox NivFComboBox;
    private javax.swing.JCheckBox NivGComboBox;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JTextField codigoTextField;
    private javax.swing.JTextArea descricaoTextArea;
    private javax.swing.JButton finalizarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nomeTextField;
    // End of variables declaration//GEN-END:variables

    public void loadScreen() 
    {
        this.codigoTextField.setText("");
        this.descricaoTextArea.setText("");
        this.nomeTextField.setText("");
        this.NivAComboBox.setSelected(false);
        this.NivBComboBox.setSelected(false);
        this.NivCComboBox.setSelected(false);
        this.NivDComboBox.setSelected(false);
        this.NivEComboBox.setSelected(false);
        this.NivFComboBox.setSelected(false);
        this.NivGComboBox.setSelected(false);
    }

    private void changeNivel(String nivel, boolean isSelected) {
        List<String> lst = this.getNiveis();
        if(isSelected&&(!lst.contains(nivel)))
            lst.add(nivel);
        else if(lst.contains(nivel))
            lst.remove(nivel);
        this.setNiveis(lst);
    }
}
