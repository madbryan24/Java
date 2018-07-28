/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg25.javamailtest;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author asus
 */
public class JavaMailTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                loginFrame mf = new loginFrame("Mail");
                mf.setSize(500, 280);
                mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mf.setVisible(true);
            }
        }); 
    }
    
}
