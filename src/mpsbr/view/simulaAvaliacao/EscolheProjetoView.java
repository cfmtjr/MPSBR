/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.view.simulaAvaliacao;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import mpsbr.control.AvaliacaoControl;
import mpsbr.view.MainView;

/**
 *
 * @author gabriela
 */
public class EscolheProjetoView extends javax.swing.JPanel 
{
    
    private Map<String,String> projetosMap;
    private int numProjs;
    private int numProjsEmDesenv;
    
    /**
     * Creates new form EscolheProjetoView
     */
    public EscolheProjetoView() {
        initComponents();
    }

    public Map<String, String> getProjetosMap() {
        return projetosMap;
    }

    public void setProjetosMap(Map<String, String> projetosMap) {
        this.projetosMap = projetosMap;
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
        projetoComboBox = new javax.swing.JComboBox<>();
        addProjButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        projetoScrollPane = new javax.swing.JScrollPane();
        projetoTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        continuaButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Simulação de Avaliação");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        jLabel2.setText("Selecione o projeto:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        projetoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projetoComboBoxActionPerformed(evt);
            }
        });
        add(projetoComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 290, -1));

        addProjButton.setText("Adicionar projeto");
        addProjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProjButtonActionPerformed(evt);
            }
        });
        add(addProjButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Projetos adicionados:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        projetoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        projetoScrollPane.setViewportView(projetoTable);

        add(projetoScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 570, 140));

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, -1, -1));

        continuaButton.setText("Continuar Avaliação");
        continuaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuaButtonActionPerformed(evt);
            }
        });
        add(continuaButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, -1, -1));

        removeButton.setText("Remover Projeto");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        add(removeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Escolha mais X Projetos");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void continuaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuaButtonActionPerformed
        // TODO add your handling code here:
        TableModel table = this.projetoTable.getModel();
        int numRows = table.getRowCount();
        if(numRows == numProjs){
            List<String> projetos = new ArrayList<>();
            for(int i=0;i<numRows;i++)
                projetos.add((String) table.getValueAt(i, 0));
            AvaliacaoControl.getInstance().startAval(projetos);
        } else {
            int restantes = numProjs - numRows;
            JOptionPane.showMessageDialog(new JFrame(), "Selecione mais " + restantes + " Projeto" + ((restantes == 1) ? "" : "s") + " para dar início à avaliação.");
        }
    }//GEN-LAST:event_continuaButtonActionPerformed

    private void addProjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProjButtonActionPerformed
        // TODO add your handling code here:
        String nomePrj = (String) this.projetoComboBox.getSelectedItem();
        DefaultTableModel model = (DefaultTableModel) this.projetoTable.getModel();
        int numRows = model.getRowCount();
        boolean isAdded = false;
        if(numRows < this.numProjs){
            for(int i=0;i<numRows;i++)
            {
                if(nomePrj.equals(model.getValueAt(i, 0))){
                    isAdded=true;
                    JOptionPane.showMessageDialog(new JFrame(), "Projeto já cadastrado para avaliação");
                }
            }
            if(!isAdded)
            {
                String projStatus = this.getProjetosMap().get(nomePrj);
                if(projStatus.equals("EM DESENVOLVIMENTO") && (this.numProjsEmDesenv + 1) > (this.numProjs/2))
                    JOptionPane.showMessageDialog(new JFrame(), "Pelo menos metade dos Projetos deve estar concluída");
                else
                {   
                    if(projStatus.equals("EM DESENVOLVIMENTO"))
                        this.numProjsEmDesenv++;
                    String[] row = new String[2];
                    row[0] = nomePrj;
                    row[1] = projStatus;
                    model.addRow(row);
                    int restantes = numProjs - model.getRowCount();
                    if(restantes > 0) {
                        this.jLabel4.setText("Selecione mais " + restantes + " Projeto" + ((restantes == 1) ? "" : "s"));
                        this.jLabel4.setForeground(Color.red);
                    } else {
                        this.jLabel4.setText("Número máximo de Projetos alcançado");
                        this.jLabel4.setForeground(Color.green);
                    }
                    this.validate();
                    this.repaint();
                }
            }
        }
        else
            JOptionPane.showMessageDialog(new JFrame(), "Número máximo de Projetos alcançado");
    }//GEN-LAST:event_addProjButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
        int delRow = this.projetoTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) this.projetoTable.getModel();
        String projStatus = (String) this.projetoTable.getValueAt(delRow, 1);
        model.removeRow(delRow);
        if(projStatus.equals("EM DESENVOLVIMENTO"))
            this.numProjsEmDesenv--;
        int restantes = numProjs - model.getRowCount();
        this.jLabel4.setText("Selecione mais " + restantes + " Projeto" + ((restantes == 1) ? "" : "s"));
        this.jLabel4.setForeground(Color.red);
        this.validate();
        this.repaint();        
    }//GEN-LAST:event_removeButtonActionPerformed

    private void projetoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projetoComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projetoComboBoxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        MainView.showPanel(MainView.NIVEL_AVL);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProjButton;
    private javax.swing.JButton continuaButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> projetoComboBox;
    private javax.swing.JScrollPane projetoScrollPane;
    private javax.swing.JTable projetoTable;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables

    public void loadScr(Map<String,String> projetos) 
    {
        this.numProjs = AvaliacaoControl.getInstance().getCurrentAval().getNivel().getNome().equals("G") ? 2 : 4;
        this.numProjsEmDesenv = 0;
        this.jLabel4.setText("Selecione mais " + numProjs + " Projetos");
        this.jLabel4.setForeground(Color.red);
        this.setProjetosMap(projetos);
        this.projetoComboBox.removeAllItems();
        
        for(String prj : projetos.keySet())
            this.projetoComboBox.addItem(prj);
        
        Vector<String> colunas = new Vector<String>();
        colunas.add(0,"Status");
        colunas.add(0,"Nome do Projeto");
        DefaultTableModel model = new DefaultTableModel(colunas,0);;
        this.projetoTable.setModel(model);
        this.projetoTable.setEnabled(true);
        this.projetoScrollPane.setVisible(true);
    }
}
