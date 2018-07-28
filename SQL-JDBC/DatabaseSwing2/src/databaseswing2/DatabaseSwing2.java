/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseswing2;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author asus
 */
public class DatabaseSwing2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                teacherFrame2 mf = new teacherFrame2("Teacher Management");
                mf.setSize(750, 350);
                mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mf.setVisible(true);
            }
        }); 
    }
    
}
