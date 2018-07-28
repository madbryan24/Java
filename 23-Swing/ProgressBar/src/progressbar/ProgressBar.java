/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progressbar;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

/**
 *
 * @author asus
 */
public class ProgressBar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                myProgressBar mf = new myProgressBar("Progress");
                mf.setSize(300, 150);
                mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mf.setVisible(true);
            }
        });
    }
    
}

class myProgressBar extends JFrame implements ActionListener{
    JPanel pnMain;
    JButton btn;
    JProgressBar pb;
    
    public myProgressBar(String s){
        super(s);
        pnMain = new JPanel();
        pb = new JProgressBar(0,100);
        btn = new JButton("Run");
        
        btn.addActionListener(this);
        pnMain.setLayout(new FlowLayout());
        pnMain.add(pb);
        pnMain.add(btn);
        this.add(pnMain);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btn){
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i =0;i<=100;i+=10){
                        pb.setValue(i);
                        try {

                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(myProgressBar.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    JOptionPane.showMessageDialog(pnMain, "Running Progress Successfully");
                }
            });
            t1.start();
        }
    }
    
}