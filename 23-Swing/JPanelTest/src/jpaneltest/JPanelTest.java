/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaneltest;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
/**
 *                      //set title and border for the Panel (at the end of the page)
 * @author asus
 */
public class JPanelTest {
    
    public static void main(String[] args) {
        
            SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                myGridBagLayout mf = new myGridBagLayout("My Window");
                mf.setSize(400, 300);
                mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mf.setVisible(true);
            }
        });
    }
}

class myGridBagLayout extends JFrame{
    public myGridBagLayout(String s){
        super(s);
        JPanel JPGBL = new JPanel();
        JPGBL.setLayout(new GridBagLayout());
        
        JPanel JPnorth,JPsouth,JPeast,JPwest,JPcenter;
        JLabel JLnorth,JLsouth,JLeast,JLwest,JLcenter;
        
        JPnorth = new JPanel();
        JPnorth.setBackground(Color.yellow);
        
        JLnorth = new JLabel();
        JLnorth.setText("1");
        //add label on panel
        JPnorth.add(JLnorth);
        
        JPsouth = new JPanel();
        JPsouth.setBackground(Color.red);
        
        JLsouth = new JLabel();
        JLsouth.setText("2");
        //add label on panel
        JPsouth.add(JLsouth);
        
        JPeast = new JPanel();
        JPeast.setBackground(Color.blue);
        
        JLeast = new JLabel();
        JLeast.setText("3");
        //add label on panel
        JPeast.add(JLeast);
        
        JPwest = new JPanel();
        JPwest.setBackground(Color.white);
        
        JLwest = new JLabel();
        JLwest.setText("4");
        //add label on panel
        JPwest.add(JLwest);
        
        JPcenter = new JPanel();
        JPcenter.setBackground(Color.CYAN);
        
        JLcenter = new JLabel();
        JLcenter.setText("5");
        //add label on panel
        JPcenter.add(JLcenter);
        
        // tạo constraint cho JP
        GridBagConstraints GBC1 = new GridBagConstraints();
        GridBagConstraints GBC2 = new GridBagConstraints();
        GridBagConstraints GBC3 = new GridBagConstraints();
        // set the position for the net
        GBC1.gridx = 0;
        GBC1.gridy = 0;
        // the space from the panel to the other
        GBC1.insets = new Insets(10, 10, 10, 10);
        // the height and width of the panel
        GBC1.gridheight = 1;
        GBC1.gridwidth = 1;
        // the space from the text to the panel
        GBC1.ipadx = 10;
        GBC1.ipady = 15;
        
        
        //2
        GBC2.gridx = 1;
        GBC2.gridy = 0;
        GBC3.gridx = 1;
        GBC3.gridy = 1;
                
                
                
        JPGBL.add(JPnorth,GBC1);
        JPGBL.add(JPsouth,GBC2);
        JPGBL.add(JPeast,GBC3);
        
        TitledBorder title = new TitledBorder("Title");
        JPGBL.setBorder(title);

        this.add(JPGBL);

    }
}
