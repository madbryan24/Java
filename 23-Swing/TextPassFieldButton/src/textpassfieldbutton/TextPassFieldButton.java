/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textpassfieldbutton;

import java.awt.Button;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author asus
 */
public class TextPassFieldButton {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                    SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                myField mf = new myField("Login");
                mf.setSize(400, 150);
                mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mf.setVisible(true);
            }
        });
    }
    
}

class myField extends JFrame{
        JPanel panelMain;
        JButton btn_login,btn_cancel;
        JTextField txt_login;
        JPasswordField txt_pass;
        JLabel lb_login,lb_pass;
    public myField(String s){
        super(s);
        
 
        
        panelMain = new JPanel();
        panelMain.setLayout(new GridLayout(3,2));
        
        btn_login = new JButton("Login");
        btn_cancel = new JButton("Cancel");
        
        txt_login = new JTextField("",25);
        txt_pass = new JPasswordField();
        
        lb_login = new JLabel("Account");
        lb_pass = new JLabel("Password");
        
        panelMain.add(lb_login);
        panelMain.add(txt_login);
        panelMain.add(lb_pass);
        panelMain.add(txt_pass);
        panelMain.add(btn_login);
        panelMain.add(btn_cancel);
        
        this.add(panelMain);
        
        
        
    }
}
