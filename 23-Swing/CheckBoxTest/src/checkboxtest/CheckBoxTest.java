/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkboxtest;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author asus
 */
public class CheckBoxTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                myCheckBox mf = new myCheckBox("Login");
                mf.setSize(300, 150);
                mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mf.setVisible(true);
            }
        });
    }
    
}
class myCheckBox extends JFrame implements ActionListener,ItemListener{

    JPanel panel;
    JButton btnButton;
    JCheckBox cb1,cb2,cb3;
    String msgString ="";
    
    public myCheckBox(String s){
        super(s);
        panel = new JPanel();
        btnButton = new JButton("Check");
        cb1 = new JCheckBox("iOS");
        cb2 = new JCheckBox("Android");
        cb3 = new JCheckBox("WindowPhone");
        
        btnButton.addActionListener(this);
        cb1.addItemListener(this);
        cb2.addItemListener(this);
        cb3.addItemListener(this);
        
        
        panel.setLayout(new FlowLayout());
        
        panel.add(cb1);
        panel.add(cb2);
        panel.add(cb3);
        panel.add(btnButton);
        
        this.add(panel);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnButton){
            JOptionPane.showMessageDialog(null, "Check Box\n" + msgString);
        }
    }
    @Override
    public void itemStateChanged(ItemEvent ie) {
        
        if(ie.getItemSelectable() == cb1){
            msgString += cb1.getText() + "\n";
        }
        if(ie.getItemSelectable() == cb2){
            msgString += cb2.getText()+ "\n";
        }
        if(ie.getItemSelectable() == cb3){
            msgString += cb3.getText()+ "\n";
        }
    }
    
}