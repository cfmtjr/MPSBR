/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpsbr;

import java.awt.Dimension;
import javax.swing.JFrame;
import mpsbr.view.MainView;

/**
 *
 * @author gabriela
 */
public class MPSBR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Thread(new MainView()).start();
    }
    
}
