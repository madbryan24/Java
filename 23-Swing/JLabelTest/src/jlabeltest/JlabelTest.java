/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlabeltest;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
/**
 *
 * @author asus
 */
public class JlabelTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //create a FRAME
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                myFrame mf = new myFrame("JLabel");
                mf.setSize(400, 300);
                mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mf.setVisible(true);
            }
        });
        
    }  
}

class myFrame extends JFrame{
    public myFrame(String s){
        super(s);
        //create a Label
        JLabel jl = new JLabel();
        jl.setText("Hello World");
        jl.setForeground(Color.RED);
        
        this.add(jl);
    }
}
