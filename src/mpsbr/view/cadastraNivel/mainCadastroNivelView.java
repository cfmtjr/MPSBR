/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.view.cadastraNivel;

import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import mpsbr.control.NivelControl;
import mpsbr.model.AtributoDeProcesso;
import mpsbr.model.Processo;
import mpsbr.model.ResultadoEsperado;

/**
 *
 * @author gabriela
 */
public class mainCadastroNivelView extends javax.swing.JPanel {

    /**
     * Creates new form cadastraProcessosNivelView
     */
    public mainCadastroNivelView() {
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
        jScrollPane3 = new javax.swing.JScrollPane();
        processoList = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        changeProcButton = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        APList = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        addAPButton = new javax.swing.JToggleButton();
        addProcessoButton = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Cadastro de Nível");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, -1));

        jScrollPane3.setViewportView(processoList);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 130, 90));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Processos Cadastrados:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        changeProcButton.setText("Adicionar RE em Processo Existente");
        changeProcButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeProcButtonActionPerformed(evt);
            }
        });
        add(changeProcButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 240, 30));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 360, 10));

        jScrollPane5.setViewportView(APList);

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 130, 90));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("APs Cadastrados:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        addAPButton.setText("Adicionar Novo AP");
        addAPButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAPButtonActionPerformed(evt);
            }
        });
        add(addAPButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 140, -1));

        addProcessoButton.setText("Adicionar Novo Processo");
        addProcessoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProcessoButtonActionPerformed(evt);
            }
        });
        add(addProcessoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 190, -1));

        jButton1.setText("Consultar Processo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void changeProcButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeProcButtonActionPerformed
        // TODO add your handling code here:
        String process = this.processoList.getSelectedValue();
        if(process.isEmpty()){
            JOptionPane.showMessageDialog(new JFrame(), "Escolha um processo");
        }
        else{
            NivelControl.getInstance().addREProcess(process);
        }
        
    }//GEN-LAST:event_changeProcButtonActionPerformed

    private void addProcessoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProcessoButtonActionPerformed
        // TODO add your handling code here:
        NivelControl.getInstance().cadastroProcesso();
    }//GEN-LAST:event_addProcessoButtonActionPerformed

    private void addAPButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAPButtonActionPerformed
        NivelControl.getInstance().cadastroAP();
    }//GEN-LAST:event_addAPButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String process = this.processoList.getSelectedValue();
        if (process.isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Escolha um processo");
        } else {
            NivelControl.getInstance().consultaProc(process);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> APList;
    private javax.swing.JToggleButton addAPButton;
    private javax.swing.JToggleButton addProcessoButton;
    private javax.swing.JToggleButton changeProcButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<String> processoList;
    // End of variables declaration//GEN-END:variables

    public void loadScreen(Map<Processo, List<ResultadoEsperado>>processos, List<AtributoDeProcesso> aps){
        String[] processosCods = new String[processos.size()];
        String[] apsCods = new String[aps.size()];
        int i = 0;
        for (Processo p : processos.keySet()) {
            processosCods[i] = p.getCodigo();
            i++;
        }
        i = 0;
        for (AtributoDeProcesso ap : aps) {
            apsCods[i] = ap.getCodigo();
            i++;
        }
        this.processoList.setListData(processosCods);
        this.APList.setListData(apsCods);
        this.validate();
        this.repaint();
    }
    
}
