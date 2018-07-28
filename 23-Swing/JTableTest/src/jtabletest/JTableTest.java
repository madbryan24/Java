/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jtabletest;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus
 */
public class JTableTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                teacherFrame mf = new teacherFrame("Teacher Management");
                mf.setSize(450, 300);
                mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mf.setVisible(true);
            }
        }); 
    }
    
}
class teacherFrame extends JFrame{
    
    JPanel mainPanel;
    JScrollPane jsp;
    String[][] data = new String[10][10];
    String[] column = {"MAGV","HOTEN","LUONG","PHAI","NGSINH","DIACHI","GLQLCM","MABM"};
    DefaultTableModel tblModel = new DefaultTableModel(data,column);
    JTable table;
    public teacherFrame(String s){
        super(s);
    //create vari
        mainPanel = new JPanel();
        table = new JTable(tblModel);

    //table
        jsp = new JScrollPane(table);
        table.setModel(tblModel);
    //main 
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(jsp);
        this.add(mainPanel);
      
    }

}