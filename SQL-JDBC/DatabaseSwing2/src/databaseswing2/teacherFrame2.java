/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseswing2;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus
 */
public class teacherFrame2 extends JFrame implements ActionListener{
    JPanel mainPanel,filterPanel,editPanel,buttonPanel;
    JLabel label1,label2,label3,label4,label5,label6,label7,label8;
    JTextField txtField1,txtField2,txtField3,txtField4,txtField5,txtField6,txtField7,txtField8;
    JButton saveButton,exitButton;
    JComboBox box;
    
    static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=SimpleQuery;user=sa;password=123456";
    static Connection conn =null;
    static Statement stmt;
    static String SQL;
    static ResultSet rs;
    static DefaultComboBoxModel comboBoxModel;
    static Vector data;
    static int index;
    static String id;
    PreparedStatement preparedStatement;
    public teacherFrame2(String s){
        super(s);
    //create vari
        mainPanel = new JPanel();
        filterPanel = new JPanel();
        buttonPanel = new JPanel();
        editPanel = new JPanel();
        
        label1 = new JLabel("MAGV");
        label2 = new JLabel("HOTEN");
        label3 = new JLabel("LUONG");
        label4 = new JLabel("PHAI");
        label5 = new JLabel("NGSINH");
        label6 = new JLabel("DIACHI");
        label7 = new JLabel("GVQLCM");
        label8 = new JLabel("MABM");

        txtField1 = new JTextField(30);
        txtField2 = new JTextField(30);
        txtField3 = new JTextField(30);
        txtField4 = new JTextField(30);
        txtField5 = new JTextField(30);
        txtField6 = new JTextField(30);
        txtField7 = new JTextField(30);
        txtField8 = new JTextField(30);
        
        saveButton = new JButton("Save");
        exitButton = new JButton("Exit");
        
        box = new JComboBox();
    //filter
        TitledBorder title = new TitledBorder("Filter");
        filterPanel.setBorder(title);
        filterPanel.add(box);
    //edit
        TitledBorder title2 = new TitledBorder("Edit");
        filterPanel.setBorder(title2);
        editPanel.setLayout(new GridLayout(8,2));
        editPanel.add(label1);
        editPanel.add(txtField1);
        editPanel.add(label2);
        editPanel.add(txtField2);
        editPanel.add(label3);
        editPanel.add(txtField3);
        editPanel.add(label4);
        editPanel.add(txtField4);
        editPanel.add(label5);
        editPanel.add(txtField5);
        editPanel.add(label6);
        editPanel.add(txtField6);
        editPanel.add(label7);
        editPanel.add(txtField7);
        editPanel.add(label8);
        editPanel.add(txtField8);
    //button
        saveButton.addActionListener(this);
        exitButton.addActionListener(this);
        TitledBorder title1 = new TitledBorder("Button");
        buttonPanel.setBorder(title1);
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
        buttonPanel.add(saveButton);
        buttonPanel.add(exitButton);
    //combobox
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    System.out.print("Connecting to SQL Server ... ");
                    conn = DriverManager.getConnection(URL);
                    System.out.println(" Done.");

                    id = (String)box.getSelectedItem();
                    System.out.println("id is: " + id);
                //SQL    
                    SQL = "SELECT * FROM giaovien1 WHERE MAGV = ?";
                    preparedStatement = conn.prepareStatement(SQL);
                    preparedStatement.setString(1,id);
                    rs = preparedStatement.executeQuery();
                    while (rs.next()) {   
                        txtField1.setText(rs.getString("MAGV"));
                        txtField2.setText(rs.getString("HOTEN"));
                        txtField3.setText(rs.getString("LUONG"));
                        txtField4.setText(rs.getString("PHAI"));
                        txtField5.setText(rs.getString("NGSINH"));
                        txtField6.setText(rs.getString("DIACHI"));
                        txtField7.setText(rs.getString("GVQLCM"));
                        txtField8.setText(rs.getString("MABM"));
                    }

                    preparedStatement.close();
                    rs.close();
                    stmt.close();
                    conn.close();  
                }catch (SQLException ex) {
                    ex.printStackTrace();
                } catch(NullPointerException ne){
                }
                finally {
                //finally block used to close resources
                    try {
                        if (stmt != null) {
                            stmt.close();
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
        });
           
        try {
                System.out.print("Connecting to SQL Server ... ");
                conn = DriverManager.getConnection(URL);
                System.out.println(" Done.");

                System.out.print("Creating statement...");
                stmt = (Statement) conn.createStatement(); //create the statement
                System.out.println(" Done.");
            //SQL        
                SQL = "SELECT MAGV FROM giaovien1"; 
                rs = stmt.executeQuery(SQL);
            //insert
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "Teacher is not available!");
                }         
                else{   
                    data = new Vector();
                    while (rs.next()) { 
                        data.add(rs.getString("MAGV"));
                    }
                    comboBoxModel = new DefaultComboBoxModel(data);
                    box.setModel(comboBoxModel);
                }
                
                
                
                rs.close();
                stmt.close();
                conn.close();     
            } catch (SQLException ex) {
            ex.printStackTrace();
            } catch(NullPointerException ne){
            }
            finally {
                //finally block used to close resources
                try {
                    if (stmt != null) {
                        stmt.close();
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
            }
        System.out.println("Done!");
    //main 
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(filterPanel);
        mainPanel.add(editPanel);
        mainPanel.add(buttonPanel);
        
        this.add(mainPanel);
//-------------------------------------------------------     
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    //save   
        if(e.getSource() == saveButton){
            try{
                System.out.print("Connecting to SQL Server ... ");
                conn = DriverManager.getConnection(URL);
                System.out.println(" Done."); 
             
                int ret = JOptionPane.showConfirmDialog(this, "Do you want to Update?", "Confirm", JOptionPane.YES_NO_OPTION);
                if(ret == JOptionPane.YES_OPTION) {
                    SQL = "UPDATE giaovien1"
                            + " SET HOTEN = ?,LUONG = ?,PHAI = ?,NGSINH = ?,DIACHI = ?,GVQLCM = ?,MABM = ?" 
                            + " WHERE MAGV = ?"; 
                    preparedStatement = conn.prepareStatement(SQL);
                    preparedStatement.setString(1,txtField2.getText()); 
                    preparedStatement.setString(2,txtField3.getText()); 
                    preparedStatement.setString(3,txtField4.getText()); 
                    preparedStatement.setString(4,txtField5.getText()); 
                    preparedStatement.setString(5,txtField6.getText()); 
                    preparedStatement.setString(6,txtField7.getText()); 
                    preparedStatement.setString(7,txtField8.getText()); 
                    preparedStatement.setString(8,id);  
                    ret = preparedStatement.executeUpdate();
                    if (ret != -1) {
                        JOptionPane.showMessageDialog(this, "This teacher has been Updated");  
                    }
                }
                
                preparedStatement.close();
                rs.close();
                stmt.close();
                conn.close();     
        }catch (SQLException ex) {
            ex.printStackTrace();
            } catch(NullPointerException ne){
            }
            finally {
            //finally block used to close resources
                try {
                    if (stmt != null) {
                        stmt.close();
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
    //Exit    
        else if(e.getSource() == exitButton){
            System.exit(0);
        }
    }
}
