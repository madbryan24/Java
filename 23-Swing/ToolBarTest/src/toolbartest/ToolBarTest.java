/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toolbartest;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

/**
 *
 * @author asus
 */
public class ToolBarTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                myToolBar mf = new myToolBar("Progress");
                mf.setSize(300, 150);
                mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mf.setVisible(true);
            }
        });
    }
    
}

class myToolBar extends JFrame implements ActionListener{
    JToolBar toolBar;
    JTextField textField;
    JButton btn;
    String msg;
    public myToolBar(String s){
        super(s);
        toolBar = new JToolBar();
        textField = new JTextField();
        btn = new JButton("Test");
        
        btn.addActionListener(this);
        toolBar.add(textField);
        toolBar.add(btn);
        this.setLayout(new BorderLayout());
        this.add(toolBar,BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btn){
           msg = "Testing Successfully";
           JOptionPane.showMessageDialog(this,msg);
       }
    }
}
