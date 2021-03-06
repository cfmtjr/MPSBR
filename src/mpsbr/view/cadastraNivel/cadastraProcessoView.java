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
import mpsbr.view.MainView;

/**
 *
 * @author gabriela
 */
public class cadastraProcessoView extends javax.swing.JPanel 
{
	
    private List<String> resultados;
    /**
     * Creates new form cadastraProcessoView
     */
    public cadastraProcessoView() {
        initComponents();
    }

    public void setResultados(List<String> resultados) {
        this.resultados = resultados;
    }

    public List<String> getResultados() {
        return resultados;
    }

    public void setREList(List<String> resultados) {
        this.cadastroREList.setListData(resultados.toArray(new String[resultados.size()]));
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
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        cadastroREList = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        addREButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        finalizaButton = new javax.swing.JButton();

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
        jLabel2.setText("Cadastro de Processo");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 460, 10));

        jScrollPane3.setViewportView(cadastroREList);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 130, 90));

        jLabel6.setText("REs Cadastrados:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        addREButton.setText("Adicionar Novo RE");
        addREButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addREButtonActionPerformed(evt);
            }
        });
        add(addREButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, -1));

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, -1, -1));

        finalizaButton.setText("Finalizar");
        finalizaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizaButtonActionPerformed(evt);
            }
        });
        add(finalizaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void addREButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addREButtonActionPerformed
        String codigo = this.codigoTextField.getText();
        String desc = this.descricaoTextArea.getText();
        String nome = this.nomeTextField.getText();

        if (codigo.equals("") || desc.equals("") || nome.equals("")) {
            JOptionPane.showMessageDialog(new JFrame(), "Preencha todos os campos");
        } else {
            NivelControl.getInstance().cadastroRE(codigo);
        }
    }//GEN-LAST:event_addREButtonActionPerformed

    private void finalizaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizaButtonActionPerformed
        // TODO add your handling code here:
        String codigo = this.codigoTextField.getText();
        String desc = this.descricaoTextArea.getText();
        String nome = this.nomeTextField.getText();
        
        if(codigo.equals("")||desc.equals("")||nome.equals(""))
        {
            JOptionPane.showMessageDialog(new JFrame(), "Preencha todos os campos");
        }        
        else
        {
            NivelControl.getInstance().cadastroProcesso(codigo, nome, desc);
        }        
    }//GEN-LAST:event_finalizaButtonActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        NivelControl nc = NivelControl.getInstance();
        nc.setNovoProcesso(null);
        nc.setCodNovoProcesso(null);
        nc.getCnv().loadScreen(nc.getProcessos(), nc.getAp());
        MainView.showPanel(MainView.CADASTRA_NIVEL);
    }//GEN-LAST:event_cancelButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addREButton;
    private javax.swing.JList<String> cadastroREList;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField codigoTextField;
    private javax.swing.JTextArea descricaoTextArea;
    private javax.swing.JButton finalizaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nomeTextField;
    // End of variables declaration//GEN-END:variables

    public void loadScreen() 
    {
        this.setResultados(new ArrayList<String>());
        this.cadastroREList.setListData(new String[0]);
        this.descricaoTextArea.setText("");
        this.codigoTextField.setText("");
        this.nomeTextField.setText("");
    }
}