/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg23.swingt;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 *
 * @author asus
 */
public class Swingt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //create a FRAME
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame itf = new JFrame("My Frame");
                itf.setSize(400, 300);
                itf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                itf.setVisible(true);
            }
        });
        
    }  
}

