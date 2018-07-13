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
public class Dialog{
    public static void main(String[] args){
        JOptionPane.showMessageDialog(null, "Hello");
        JOptionPane.showMessageDialog(null,"Parameters ERROR","ERROR",JOptionPane.ERROR_MESSAGE);
        
        JOptionPane.showConfirmDialog(null,"Do you really want to quit","Confirm",JOptionPane.YES_NO_OPTION);
        JOptionPane.showConfirmDialog(null,"Do you really want to quit","Confirm",JOptionPane.YES_NO_CANCEL_OPTION);
        
        System.exit(0);
    }
}
