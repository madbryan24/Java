/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlisttest;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author asus
 */
public class JListTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                myList mf = new myList("Progress");
                mf.setSize(300, 150);
                mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mf.setVisible(true);
            }
        });
    }
    
}

class myList extends JFrame implements ActionListener{
    JPanel pnMain;
    JList list;
    JButton btn;
    String[] phone = {"iOS","Android","WindowPhone"};
    String msg;
    DefaultListModel model = new DefaultListModel();
    
    public myList(String s){
        super(s);
        pnMain = new JPanel();
        list = new JList(phone);
        btn = new JButton("Check");
        
        btn.addActionListener(this);
        
        pnMain.setLayout(new FlowLayout());
        pnMain.add(list);
        pnMain.add(btn);
        
        this.add(pnMain);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        msg = list.getSelectedValue().toString();
        //JOptionPane.showMessageDialog(pnMain,msg); 
        //query the model if choose one from list
        for(int i =0;i<5;i++){
            model.addElement("Phone" + i);
        }
        list.setModel(model);
    }
    
}
