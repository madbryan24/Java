/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textarea;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author asus
 */
public class TextArea {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                myTextArea mf = new myTextArea("Login");
                mf.setSize(300, 150);
                mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mf.setVisible(true);
            }
        });
    }
    
}

class myTextArea extends JFrame implements ActionListener{
    JPanel pnMain,pn1,pn2;
    JButton btn1,btn2;
    JTextArea txtArea;
    String msg;
    public myTextArea(String s){
        super(s);
        pnMain = new JPanel();
        pn1 = new JPanel();
        pn2 = new JPanel();
        btn1 = new JButton("iOS");
        btn2 = new JButton("Android");
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
                              //String,height,width                         
        txtArea = new JTextArea(3, 25);
        
        pn1.add(btn1);
        pn1.add(btn2);
        pn2.add(txtArea);
        
        pnMain.setLayout(new BorderLayout());
        pnMain.add(pn1,BorderLayout.NORTH);
        pnMain.add(pn2,BorderLayout.CENTER);
        
        this.add(pnMain);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btn1){
            msg = "iOS\n";
            txtArea.append(msg);
        }
        else if(ae.getSource() == btn2){
            msg = "Android\n";
            txtArea.append(msg);
        }
    }
    
}