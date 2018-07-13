/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg15.dialog;

/**
 *
 * @author asus
 */
import javax.swing.JOptionPane;
        
public class InOutDialog {
    public static void main(String[] args) {
        String name;
        name = JOptionPane.showInputDialog("Please enter your name" );
        JOptionPane.showMessageDialog(null, "Hello " + name + " !");
        System.exit(0);
    }
}
