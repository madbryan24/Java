/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package borderlayouttest;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
/**
 *
 * @author asus
 */
public class BorderLayoutTest {

    public static void main(String[] args) {
        
            SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                myBorderLayout mf = new myBorderLayout("My Window");
                mf.setSize(400, 300);
                mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mf.setVisible(true);
            }
        });
    }
}

class myBorderLayout extends JFrame{
    public myBorderLayout(String s){
        super(s);
        
        JPanel JPnorth,JPsouth,JPeast,JPwest,JPcenter;
        JLabel JLnorth,JLsouth,JLeast,JLwest,JLcenter;
        
        JPnorth = new JPanel();
        JPnorth.setBackground(Color.yellow);
        
        JLnorth = new JLabel();
        JLnorth.setText("North");
        //add label on panel
        JPnorth.add(JLnorth);
        
        JPsouth = new JPanel();
        JPsouth.setBackground(Color.red);
        
        JLsouth = new JLabel();
        JLsouth.setText("South");
        //add label on panel
        JPsouth.add(JLsouth);
        
        JPeast = new JPanel();
        JPeast.setBackground(Color.blue);
        
        JLeast = new JLabel();
        JLeast.setText("East");
        //add label on panel
        JPeast.add(JLeast);
        
        JPwest = new JPanel();
        JPwest.setBackground(Color.white);
        
        JLwest = new JLabel();
        JLwest.setText("West");
        //add label on panel
        JPwest.add(JLwest);
        
        JPcenter = new JPanel();
        JPcenter.setBackground(Color.CYAN);
        
        JLcenter = new JLabel();
        JLcenter.setText("Center");
        //add label on panel
        JPcenter.add(JLcenter);
        
        this.add(JPnorth,BorderLayout.NORTH);
        this.add(JPsouth,BorderLayout.SOUTH);
        this.add(JPeast,BorderLayout.EAST);
        this.add(JPwest,BorderLayout.WEST);
        this.add(JPcenter,BorderLayout.CENTER);
    }
}