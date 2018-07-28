
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
public class SimpleTableTest extends JFrame{
    protected JTable table;
    JScrollPane jsp = new JScrollPane(table);
    
    public SimpleTableTest(){
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        TableValues tv = new TableValues();
        table = new JTable(tv);
        jsp = new JScrollPane(table);
        pane.add(jsp, BorderLayout.CENTER);
        
    }

    public static void main(String [] args){
        SimpleTableTest stt = new SimpleTableTest();
        stt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stt.setSize(400, 200);
        stt.setVisible(true);
    }
}