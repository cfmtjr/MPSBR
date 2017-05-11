/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr.view;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import mpsbr.control.AvaliacaoControl;
import mpsbr.control.NivelControl;
import mpsbr.control.ProjetoControl;

/**
 *
 * @author gabriela
 */
public class MainView extends javax.swing.JFrame implements Runnable{
    
    public static final String CADASTRA_PRJ = "cadPrj";
    public static final String BUSCA_PRJ = "srcPrj";
    public static final String NIVEL_AVL = "nivAvl";
    public static final String DO_AVL = "doAvl";
    public static final String RESULT_AVL = "resultAvl";
    public static final String SEL_PRJ = "selPrj";
    public static final String CONSULTA_AVL = "consAvl";
    public static final String CADASTRA_XML = "regXML";
    public static final String CADASTRA_USR = "regUsr";
    public static final String SEL_NIVEL = "selNivel";
    public static final String CADASTRA_NIVEL = "cadNivel";
    public static final String CADASTRA_PROC = "cadProc";
    public static final String CADASTRA_RE = "cadRE";
    public static final String CADASTRA_AP = "cadAP";
    public static final String ADD_RE = "addRE";
    public static final String CONSULTA_PROC = "consProc";
    public static final String CONSULTA_RE = "consRE";
    public static final String CONFIG = "configDB";
   
    public static MainView FRAME;
    
    private ServerConfigPanel configPanel;
    /**
     * Creates new form mainView
     */
    private final static JFileChooser FILECHOOSER = new JFileChooser();
    
    public MainView() {
        initComponents();
    }
    
    public static void showPanel(String panelName){                
        CardLayout cl = (CardLayout)MainView.FRAME.mainPanel.getLayout();
        cl.show(MainView.FRAME.mainPanel, panelName);
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu5 = new javax.swing.JMenu();
        mainPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        cadProjMenuItem = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        buscProj = new javax.swing.JMenuItem();
        remProjMenuItem = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);

        mainPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        jMenu6.setText("Arquivo");

        jMenuItem6.setText("Configurações");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem6);

        jMenuBar1.add(jMenu6);

        jMenu1.setText("Usuários");

        jMenuItem1.setText("Cadastrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Alterar Senha");
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Remover");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Projetos");

        cadProjMenuItem.setText("Cadastrar");
        cadProjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadProjMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(cadProjMenuItem);

        jMenuItem5.setText("Alterar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        buscProj.setText("Consultar");
        buscProj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscProjActionPerformed(evt);
            }
        });
        jMenu2.add(buscProj);

        remProjMenuItem.setText("Remover");
        remProjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remProjMenuItemActionPerformed(evt);
            }
        });
        jMenu2.add(remProjMenuItem);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Avaliações");

        jMenuItem8.setText("Simular Avaliação");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem9.setText("Consultar Avaliações Anteriores");
        jMenu3.add(jMenuItem9);

        jMenuBar1.add(jMenu3);

        jMenu7.setText("Níveis MPS.BR");

        jMenuItem4.setText("Cadastrar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem4);

        jMenuItem11.setText("Alterar");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem11);

        jMenuItem12.setText("Consultar");
        jMenu7.add(jMenuItem12);

        jMenuItem13.setText("Remover");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem13);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void remProjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remProjMenuItemActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)this.mainPanel.getLayout();
        cl.show(this.mainPanel, "REM PROJ");
    }//GEN-LAST:event_remProjMenuItemActionPerformed

    private void cadProjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadProjMenuItemActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)this.mainPanel.getLayout();
        cl.show(this.mainPanel, MainView.CADASTRA_PRJ);
    }//GEN-LAST:event_cadProjMenuItemActionPerformed

    private void buscProjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscProjActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)this.mainPanel.getLayout();
        cl.show(this.mainPanel, MainView.BUSCA_PRJ);
    }//GEN-LAST:event_buscProjActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)this.mainPanel.getLayout();
        cl.show(this.mainPanel, MainView.NIVEL_AVL);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout)this.mainPanel.getLayout();
        cl.show(this.mainPanel, MainView.SEL_NIVEL);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        CardLayout cl = (CardLayout) this.mainPanel.getLayout();
        cl.show(this.mainPanel, MainView.CONFIG);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    public void run() 
    {
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");            
            MainView mv = new MainView();
            
            ProjetoControl pc = ProjetoControl.getInstance();
            NivelControl nc = NivelControl.getInstance();
            AvaliacaoControl ac = AvaliacaoControl.getInstance();
            this.setConfigPanel(new ServerConfigPanel());
            
            mv.mainPanel.add(ac.getEnv(),MainView.NIVEL_AVL);
            mv.mainPanel.add(ac.getEpv(),MainView.SEL_PRJ);
            mv.mainPanel.add(ac.getApv(),MainView.DO_AVL);
            mv.mainPanel.add(ac.getErv(),MainView.RESULT_AVL);
            mv.mainPanel.add(pc.getBpv(),MainView.BUSCA_PRJ);
            mv.mainPanel.add(pc.getCpv(),MainView.CADASTRA_PRJ);
            //mv.mainPanel.add(nc.getCnxv(),MainView.CADASTRA_XML);
            mv.mainPanel.add(nc.getSnv(),MainView.SEL_NIVEL);
            mv.mainPanel.add(nc.getCnv(),MainView.CADASTRA_NIVEL);
            mv.mainPanel.add(nc.getCpv(),MainView.CADASTRA_PROC);
            mv.mainPanel.add(nc.getCrev(),MainView.CADASTRA_RE);
            mv.mainPanel.add(nc.getCapv(),MainView.CADASTRA_AP);
            mv.mainPanel.add(nc.getArev(),MainView.ADD_RE);
            mv.mainPanel.add(nc.getConspv(),MainView.CONSULTA_PROC);
            mv.mainPanel.add(this.getConfigPanel(),MainView.CONFIG);
            mv.setVisible(true);
            mv.setPreferredSize(new Dimension(960,720));
            mv.pack();
            
            MainView.FRAME = mv; 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem buscProj;
    private javax.swing.JMenuItem cadProjMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem remProjMenuItem;
    // End of variables declaration//GEN-END:variables

    public ServerConfigPanel getConfigPanel() {
        return configPanel;
    }

    public void setConfigPanel(ServerConfigPanel configPanel) {
        this.configPanel = configPanel;
    }

}
