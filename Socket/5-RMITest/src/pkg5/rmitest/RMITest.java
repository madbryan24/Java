/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5.rmitest;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author asus
 */
public class RMITest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                myClientFrame jrsce = new myClientFrame("Client");
                jrsce.setSize(350, 150);
                jrsce.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jrsce.setVisible(true);
            }
        });  
    }
}
