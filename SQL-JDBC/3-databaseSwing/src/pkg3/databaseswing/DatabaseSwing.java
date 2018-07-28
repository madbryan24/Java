/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3.databaseswing;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;




/**
 *
 * @author asus
 */
public class DatabaseSwing {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
         SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                teacherFrame mf = new teacherFrame("Teacher Management");
                mf.setSize(500, 500);
                mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mf.setVisible(true);
            }
        }); 
    }   
    
}

