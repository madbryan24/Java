/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menubartest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author asus
 */
public class MenuBarTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                myMenuBar mf = new myMenuBar("Progress");
                mf.setSize(300, 150);
                mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mf.setVisible(true);
            }
        });
    }
    
}

class myMenuBar extends JFrame implements ActionListener{
    JMenuBar menuBar;
    JMenu menu1,menu2;
    JMenuItem menuItem1,menuItem2,menuItem3,menuItem4,menuItem5;
    String msg;
    public myMenuBar(String s){
        super(s);
        menuBar = new JMenuBar();
        menu1 = new JMenu("File");
        menu2 = new JMenu("Edit");
        menuItem1 = new JMenuItem("Open...");
        menuItem2 = new JMenuItem("Open File");
        menuItem3 = new JMenuItem("Save");
        menuItem4 = new JMenuItem("Save as...");
        menuItem5 = new JMenuItem("Undo");
        
        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);
        menuItem4.addActionListener(this);
        menuItem5.addActionListener(this);
        
        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menu1.addSeparator(); // to create a line between 2 parts
        menu1.add(menuItem3);
        menu1.add(menuItem4);
        
        menu2.add(menuItem5);
        
        menuBar.add(menu1);
        menuBar.add(menu2);

        this.setJMenuBar(menuBar);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == menuItem1){
           msg = menuItem1.getText();
           JOptionPane.showMessageDialog(null,msg);
       }
       else if(ae.getSource() == menuItem2){
           msg = menuItem2.getText();
           JOptionPane.showMessageDialog(null,msg);
       }
       else if(ae.getSource() == menuItem3){
           msg = menuItem3.getText();
           JOptionPane.showMessageDialog(null,msg);
       }
       else if(ae.getSource() == menuItem4){
           msg = menuItem4.getText();
           JOptionPane.showMessageDialog(null,msg);
       }
       else if(ae.getSource() == menuItem5){
           msg = menuItem5.getText();
           JOptionPane.showMessageDialog(null,msg);
       }
    }

}
