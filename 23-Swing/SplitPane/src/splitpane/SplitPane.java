/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splitpane;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 *
 * @author asus
 */
public class SplitPane {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mySplitPane mf = new mySplitPane("Progress");
                mf.setSize(300, 150);
                mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mf.setVisible(true);
            }
        });
    }
    
}
class mySplitPane extends JFrame{
    JSplitPane splitPane;
    JPanel panel1,panel2;
    JTextArea txtArea1,txtArea2;
    String str1 ="Unlike some other languages, JavaScript makes no distinction between single-quoted strings and double-quoted strings; therefore, the escape sequences above work in strings created with either single or double quotes.";
    String str2 ="Sometimes, your code will include strings which are very long. Rather than having lines that go on endlessly, or wrap at the whim of your editor, you may wish to specifically break the string into multiple lines in the source code without affecting the actual string contents. There are two ways you can do this.";
    public mySplitPane(String s){
        super(s);
        
        txtArea1 = new JTextArea(str1); 
        txtArea2 = new JTextArea(str2);
        panel1 = new JPanel();
        panel2 = new JPanel();
        
        txtArea1.setLineWrap(true);
        txtArea2.setLineWrap(true);
        
        panel1.add(txtArea1);
        panel2.add(txtArea2);
        
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panel1, panel2);
        splitPane.setOneTouchExpandable(true);
        
        this.setLayout(new BorderLayout());
        this.add(splitPane,BorderLayout.NORTH);
        
    }
}