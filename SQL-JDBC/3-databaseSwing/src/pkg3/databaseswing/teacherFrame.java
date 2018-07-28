/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3.databaseswing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
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
public class teacherFrame extends JFrame implements ActionListener,MouseListener{
    
    JPanel mainPanel,filterPanel,buttonPanel;
    JTextField txtField;
    JButton searchButton,deleteButton,exitButton;
    JTable table;
    
    static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=SimpleQuery;user=sa;password=123456";
    static Connection conn =null;
    static Statement stmt;
    static PreparedStatement preparedStatement;
    static String SQL;
    static ResultSet rs;
    static String[] column = {"MAGV","HOTEN","LUONG","PHAI","NGSINH","DIACHI","GLQLCM","MABM"};
    static DefaultTableModel tblModel = new DefaultTableModel(column, 0);
    static Vector data;
    static int index;
    
    public teacherFrame(String s){
        super(s);
    //create vari
        mainPanel = new JPanel();
        filterPanel = new JPanel();
        buttonPanel = new JPanel();
        txtField = new JTextField(20);
        searchButton = new JButton("Search");
        deleteButton = new JButton("Delete");
        exitButton = new JButton("Exit");
        table = new JTable(tblModel);
    //filter
        TitledBorder title = new TitledBorder("Filter");
        filterPanel.setBorder(title);
        filterPanel.add(txtField);
    //button
        searchButton.addActionListener(this);
        deleteButton.addActionListener(this);
        exitButton.addActionListener(this);
        TitledBorder title1 = new TitledBorder("Button");
        buttonPanel.setBorder(title1);
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.Y_AXIS));
        buttonPanel.add(searchButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(exitButton);
    //table
    JScrollPane jsp = new JScrollPane(table);
    table.setModel(tblModel);
    table.addMouseListener(this);
    //main 
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(filterPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(jsp);
        this.add(mainPanel);
//-------------------------------------------------------     
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
    //Search    
        if(e.getSource() == searchButton){
            try {
                System.out.print("Connecting to SQL Server ... ");
                conn = DriverManager.getConnection(URL);
                System.out.println(" Done.");

                System.out.print("Creating statement...");
                stmt = (Statement) conn.createStatement(); //create the statement
                System.out.println(" Done.");
            //SQL        
                SQL = "SELECT * FROM giaovien1"; 
                if (txtField.getText().length() > 0){
                    SQL = SQL + " WHERE MAGV LIKE '%" + txtField.getText() + "%'";
                }
                    rs = stmt.executeQuery(SQL);
            //insert
                if (rs.isBeforeFirst() == false) {
                    JOptionPane.showMessageDialog(this, "Teacher is not available!");
                }         
                else{
                    tblModel.setRowCount(0);
                
                    while (rs.next()) {
                        data = new Vector();
                        data.add(rs.getString("MAGV"));
                        data.add(rs.getString("HOTEN"));
                        data.add(rs.getFloat("LUONG"));
                        data.add(rs.getString("PHAI"));
                        data.add(rs.getString("NGSINH"));
                        data.add(rs.getString("DIACHI"));   
                        data.add(rs.getString("GVQLCM"));
                        data.add(rs.getString("MABM"));

                        tblModel.addRow(data);
                    }
                    table.setModel(tblModel);
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
        }
    //Delete    
        else if(e.getSource() == deleteButton){
            try {
                System.out.print("Connecting to SQL Server ... ");
                conn = DriverManager.getConnection(URL);
                System.out.println(" Done.");

                System.out.print("Creating statement...");
                stmt = (Statement) conn.createStatement(); //create the statement
                System.out.println(" Done.");
            //SQL   
                tblModel = (DefaultTableModel) table.getModel();
                String id = (String) tblModel.getValueAt(index,0);
                int i = Integer.parseInt(id);
                System.out.println("Index is: " + index);
                System.out.println("ID is: " + id);
                int ret = JOptionPane.showConfirmDialog(this, "Do you want to delete?", "Confirm", JOptionPane.YES_NO_OPTION);
                if(ret == JOptionPane.YES_OPTION) {
                    SQL = "DELETE FROM giaovien1 WHERE MAGV = ?"; 
                    preparedStatement = conn.prepareStatement(SQL);
                    preparedStatement.setInt(1,i); 
                    ret = preparedStatement.executeUpdate();
                    if (ret != -1) {
                        JOptionPane.showMessageDialog(this, "This book has been deleted");  
                    }
                }
                
                preparedStatement.close();
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
        }
    //Exit    
        else if(e.getSource() == exitButton){
            System.exit(0);
        }
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent me) {
         index = table.getSelectedRow(); 
         System.out.println("Index is: " + index);
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent me) {
        
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent me) {
        
    }
   

}