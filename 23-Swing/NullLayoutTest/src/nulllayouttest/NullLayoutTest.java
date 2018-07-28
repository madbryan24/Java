/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nulllayouttest;

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
public class NullLayoutTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                            SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                myNullLayout mf = new myNullLayout("Login");
                mf.setSize(300, 150);
                mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mf.setVisible(true);
            }
        });
    }
    
}

class myNullLayout extends JFrame{
            JPanel panelMain;
            JButton btn_login,btn_cancel;
            JTextField txt_login;
            JPasswordField txt_pass;
            JLabel lb_login,lb_pass;
        public myNullLayout(String s){
            super(s);

            panelMain = new JPanel();
            panelMain.setLayout(null);

            btn_login = new JButton("Login");
            btn_cancel = new JButton("Cancel");

            txt_login = new JTextField("",25);
            txt_pass = new JPasswordField();

            lb_login = new JLabel("Account");
            lb_pass = new JLabel("Password");

            lb_login.setBounds(30, 10, 80, 20 );
            txt_login.setBounds(130,10 ,120 ,20 );
            lb_pass.setBounds(30,40 ,80 ,20 );
            txt_pass.setBounds(130,40 ,120 ,20 );
            btn_login.setBounds(30,70 ,100 ,20 );
            btn_cancel.setBounds(135,70 ,100 ,20 );
                    
            panelMain.add(lb_login);
            panelMain.add(txt_login);
            panelMain.add(lb_pass);
            panelMain.add(txt_pass);
            panelMain.add(btn_login);
            panelMain.add(btn_cancel);

            this.add(panelMain);
        }
}