/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combobox;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author asus
 */
public class ComboBox {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                myComboBox mf = new myComboBox("Login");
                mf.setSize(300, 150);
                mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mf.setVisible(true);
            }
        });
    }
    
}

class myComboBox extends JFrame implements ActionListener{
    JPanel pnMain;
    JComboBox listBox;
    JButton btn;
    String[] phone = {"iOS","Android","WindowPhone"};
    String msg;
    public myComboBox(String s){
        super(s);
        pnMain = new JPanel();
        listBox = new JComboBox(phone);
        btn = new JButton("Check");
        
        btn.addActionListener(this);
        
        pnMain.setLayout(new FlowLayout());
        pnMain.add(listBox);
        pnMain.add(btn);
        
        this.add(pnMain);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        msg = listBox.getSelectedItem().toString();
        JOptionPane.showMessageDialog(null,msg);
    }
    
}
