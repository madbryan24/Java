/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentaccount;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import static studentaccount.infoFrame.data;

/**
 *
 * @author asus
 */
public class myAccountFrame extends JFrame implements ActionListener{
    JPanel mainPanel,filterPanel,buttonPanel;
    JLabel accountLabel,passLabel;
    JTextField accountField;
    JPasswordField passField;
    JButton logInButton,exitButton;
    
    static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=studentAccount;user=sa;password=123456";
    static Connection conn =null;
    static String SQL;
    static ResultSet rs;
    static PreparedStatement preparedStatement;
    static Vector data;
    static String id;
    public myAccountFrame(String s){
        super(s);
    //create vari
        mainPanel = new JPanel();
        filterPanel = new JPanel();
        buttonPanel = new JPanel();
        accountLabel = new JLabel("Account");
        passLabel = new JLabel("Password");
        accountField = new JTextField(25);
        passField = new JPasswordField(25);    
        logInButton = new JButton("Log in");     
        exitButton = new JButton("Exit");
        
    //Account Log in Frame
        //Filter
            TitledBorder title = new TitledBorder("Filter");
            filterPanel.setBorder(title);
            filterPanel.setLayout(new GridLayout(2,2));
            filterPanel.add(accountLabel);
            filterPanel.add(accountField);
            filterPanel.add(passLabel);
            filterPanel.add(passField);
        //Button
            logInButton.addActionListener(this);
            exitButton.addActionListener(this);
            buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
            buttonPanel.add(logInButton);
            buttonPanel.add(exitButton);
        //main
            mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
            mainPanel.add(filterPanel);
            mainPanel.add(buttonPanel);
            this.add(mainPanel);
    //Info
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == logInButton){
            try {
                    System.out.print("Connecting to SQL Server ... ");
                    conn = DriverManager.getConnection(URL);
                    System.out.println(" Done.");

                //SQL    
                    id = accountField.getText();
                    SQL = "SELECT * FROM student WHERE Student_ID = ?";
                    preparedStatement = conn.prepareStatement(SQL);
                    preparedStatement.setString(1,id);
                    rs = preparedStatement.executeQuery();
                    
                    if(!rs.next() ) {
                        JOptionPane.showMessageDialog(this,"Wrong account!","ERROR",JOptionPane.ERROR_MESSAGE);
                    } 
                    else{
                        if(rs.getString("Pass").equals(passField.getText())){
                            JOptionPane.showMessageDialog(this, "Log in successfully");
                            
                            data = new Vector();
                            data.add(rs.getString("Student_Name"));
                            data.add(rs.getString("Sex"));
                            data.add(rs.getString("Class_ID"));
                            data.add(rs.getFloat("diem1"));
                            data.add(rs.getFloat("diem2"));
                            data.add(rs.getFloat("diem3"));   
                            data.add(rs.getFloat("diem4"));
                            data.add(rs.getFloat("diem5"));
                            
                            infoFrame info = new infoFrame("Student Infomation");
                            info.setSize(800, 200);
                            info.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            info.setVisible(true);
                            info.getInfo(data);
                            info.getPass(rs.getString("Pass"));
                        }
                        else{
                            JOptionPane.showMessageDialog(this,"Wrong password!","ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    
                    preparedStatement.close();
                    rs.close();
                    conn.close();  
            }catch (SQLException ex) {
                    ex.printStackTrace();
            } catch(NullPointerException ne){
            }
                finally {
                //finally block used to close resources
                    try {
                        if (preparedStatement != null) {
                            preparedStatement.close();
                        }
                    }catch (SQLException se2){
                        se2.printStackTrace();
                    }

                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException se) {
                        se.printStackTrace();
                    }
                    System.out.println("Done!");
                }  
        }
        else if(ae.getSource() == exitButton){
            System.exit(0);
        }
    }
    
}
