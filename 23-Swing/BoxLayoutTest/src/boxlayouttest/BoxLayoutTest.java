/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxlayouttest;

import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author asus
 */
public class BoxLayoutTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                
            SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                myBoxLayout mf = new myBoxLayout("My Window");
                mf.setSize(400, 300);
                mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mf.setVisible(true);
            }
        });
    }
    
}

class myBoxLayout extends JFrame{
        JPanel panel;
        JLabel label1,label2,label3;
    public myBoxLayout(String s){
        super(s);
        

        
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        
        label1 = new JLabel();
        label1.setText("label 1");
        panel.add(label1);
        label2 = new JLabel();
        label2.setText("label 2");
        panel.add(label2);
        label3 = new JLabel();
        label3.setText("label 3");
        panel.add(label3);
        
        //c1
        //Container con = new Container();
        //con = getContentPane();
        //con.add(panel);
        //c2 để lấy panel vào frame
        this.add(panel);
        
    }
}