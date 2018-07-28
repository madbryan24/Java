/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4.pkg1.joinrowsettest;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 *
 * @author asus
 */
public class JoinRowsetTest {
 
   public static void main(String args[]) {
       SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                myJoinRowSet jrsce = new myJoinRowSet("Class Management");
                jrsce.getStudentBaseClassId();
                jrsce.setSize(750, 350);
                jrsce.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jrsce.setVisible(true);
            }
        }); 
    
    
   }

}

