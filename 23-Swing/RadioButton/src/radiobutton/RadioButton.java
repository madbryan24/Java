/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiobutton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

/**
 *
 * @author asus
 */
public class RadioButton {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                myRadioButton mf = new myRadioButton("Login");
                mf.setSize(300, 150);
                mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mf.setVisible(true);
            }
        });
    }
    
}

class myRadioButton extends JFrame implements ActionListener{
    JPanel panel;
    JButton btnButton;
    JRadioButton cb1,cb2,cb3;
    String msgString ="";
    ButtonGroup btnGroup; //to group 3 RadioButton ->only choose one
    
    public myRadioButton(String s){
        super(s);
        panel = new JPanel();
        btnButton = new JButton("Check");
        cb1 = new JRadioButton("iOS",true); //it's will be selected 
        cb2 = new JRadioButton("Android");
        cb3 = new JRadioButton("WindowPhone");
        btnGroup = new ButtonGroup();
        
        btnButton.addActionListener(this);
        btnGroup.add(cb1);
        btnGroup.add(cb2);
        btnGroup.add(cb3);
        
        panel.setLayout(new FlowLayout());
        
        panel.add(cb1);
        panel.add(cb2);
        panel.add(cb3);
        panel.add(btnButton);
        
        this.add(panel);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(cb1.isSelected()){
            msgString = cb1.getText();
        }
        else if(cb2.isSelected()){
            msgString = cb2.getText();
        }
        else if(cb3.isSelected()){
            msgString = cb3.getText();
        }
        JOptionPane.showMessageDialog(null, "Radio Button: " + msgString);
    }
}