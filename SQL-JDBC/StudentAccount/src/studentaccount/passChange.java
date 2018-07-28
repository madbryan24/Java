/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentaccount;

import com.sun.corba.se.impl.logging.ORBUtilSystemException;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author asus
 */
public class passChange extends JFrame implements ActionListener{
    JPanel mainPanel,filterPanel,buttonPanel;
    JPasswordField oldField,newField,checknewField;
    JLabel oldLabel,newLabel,checknewLabel;
    JButton checkButton,backButton;
    static String oldPass;
    
    public passChange(String s){
        super(s);
     
    //create vari
        mainPanel = new JPanel();
        filterPanel = new JPanel();
        buttonPanel = new JPanel();
        oldField = new JPasswordField();
        newField = new JPasswordField();
        checknewField = new JPasswordField();
        oldLabel = new JLabel("Current Password");
        newLabel = new JLabel("New Password");
        checknewLabel = new JLabel("New Password Again");
        checkButton = new JButton("Confirm");
        backButton = new JButton("Cancel");
    //filter
        filterPanel.setLayout(new GridLayout(3,2));
        filterPanel.add(oldLabel);
        filterPanel.add(oldField);
        filterPanel.add(newLabel);
        filterPanel.add(newField);
        filterPanel.add(checknewLabel);
        filterPanel.add(checknewField);
    //button
        checkButton.addActionListener(this);
        backButton.addActionListener(this);
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
        buttonPanel.add(checkButton);
        buttonPanel.add(backButton);
    //main
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        mainPanel.add(filterPanel);
        mainPanel.add(buttonPanel);
        this.add(mainPanel);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == checkButton){
            if(oldField.getText().equals(this.oldPass)){
                if(newField.getText().equals(checknewField.getText())){
                    JOptionPane.showMessageDialog(this,"Done!","Confirm",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(this,"Wrong new pass","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JOptionPane.showMessageDialog(this,"Wrong old pass","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(ae.getSource() == backButton){
            this.setVisible(false);
        }
    }

    void oldPass(String pass) {
        this.oldPass = pass;
    }
    
}
