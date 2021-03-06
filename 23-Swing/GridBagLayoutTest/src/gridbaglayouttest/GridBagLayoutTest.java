/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridbaglayouttest;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
/**
 *
 * @author asus
 */
public class GridBagLayoutTest {

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
        JPanel JPnorth,JPsouth,JPeast,JPwest,JPcenter;
        JPanel JPGBL;
        JLabel JLnorth,JLsouth,JLeast,JLwest,JLcenter;
        
    public myGridBagLayout(String s){
        super(s);
        JPGBL = new JPanel();
        JPGBL.setLayout(new GridBagLayout());
        
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
        this.add(JPGBL);

    }
}
