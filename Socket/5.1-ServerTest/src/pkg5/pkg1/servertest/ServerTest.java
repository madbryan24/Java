/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5.pkg1.servertest;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author asus
 */
public class ServerTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                myServerFrame jrsce = new myServerFrame("Class Management");
                jrsce.setSize(250, 150);
                jrsce.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jrsce.setVisible(true);
            }
        }); 
    }
    
}
