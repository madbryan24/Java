/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentaccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.sql.rowset.CachedRowSet;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import static studentaccount.myAccountFrame.data;
import static studentaccount.myAccountFrame.rs;

/**
 *
 * @author asus
 */
class infoFrame extends JFrame implements ActionListener{
    JTable infoTable;
    JTextArea acinfoArea;
    JPanel mainPanel,buttonPanel;
    JButton passChangeButton,exitButton,logOutButton;
    
    static Vector data;
    static String[] column = {"Student_Name","Sex","Class_ID","Subject 1","Subject 2","Subject 3","Subject 4","Subject 5"};
    static DefaultTableModel tb1Model = new DefaultTableModel(column, 0);
    static String pass;
    public infoFrame(String s){
        super(s);
        
    //create vari
        mainPanel = new JPanel();
        buttonPanel = new JPanel();
        infoTable = new JTable();
        acinfoArea = new JTextArea();
        passChangeButton = new JButton("Change Password");
        logOutButton  = new JButton("Log Out");
        exitButton = new JButton("Exit");
    //table
        JScrollPane jsp = new JScrollPane(infoTable);
        infoTable.setModel(tb1Model);

    //Button
        passChangeButton.addActionListener(this);
        logOutButton.addActionListener(this);
        exitButton.addActionListener(this);
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
        buttonPanel.add(passChangeButton);
        buttonPanel.add(logOutButton);
        buttonPanel.add(exitButton);
        
    //main    
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
        mainPanel.add(acinfoArea);
        mainPanel.add(jsp);
        mainPanel.add(buttonPanel);
        this.add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == passChangeButton){
            passChange info = new passChange("Password Change");
            info.setSize(400, 180);
            info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            info.setVisible(true);
            info.oldPass(this.pass);
        }
        else if(ae.getSource() == logOutButton){
            this.setVisible(false);
        }
        else if(ae.getSource() == exitButton){
            System.exit(0);
        }
    }

    void getInfo(Vector data) {
            tb1Model.setRowCount(0);
            tb1Model.addRow(data);
            infoTable.setModel(tb1Model);      
    }

    void getPass(String string) {
        this.pass = string;
    }
}
