/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4.pkg1.joinrowsettest;

import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.JoinRowSetImpl;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.Vector;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus
 */
class myJoinRowSet extends JFrame{
    private CachedRowSet crClass, crStudent;
   //Column name in database
    private static final String CLASS_ID = "class_id";
    JPanel mainPanel;
    JTable classTable,studenTable,joinTable;
    static String[] classColumn = {"class_id","class_Name"};
    static String[] studentColumn = {"student_id","student_name","sex","class_id"};
    static String[] joinColumn = {"student_id","student_name","sex","class_name"};

    static DefaultTableModel classModel = new DefaultTableModel(classColumn, 0);
    static DefaultTableModel studentModel = new DefaultTableModel(studentColumn, 0);
    static DefaultTableModel joinModel = new DefaultTableModel(joinColumn, 0);
    static Vector data;
    
    public myJoinRowSet(String s) {
        super(s);
        
    //interface
    mainPanel = new JPanel();
    classTable = new JTable();
    studenTable = new JTable();
    joinTable = new JTable();
    
    JScrollPane jsp1 = new JScrollPane(classTable);
    JScrollPane jsp2 = new JScrollPane(studenTable);
    JScrollPane jsp3 = new JScrollPane(joinTable);
    
    mainPanel.setLayout(new FlowLayout());
    mainPanel.add(jsp1);
    mainPanel.add(jsp2);
    mainPanel.add(jsp3);
    
    this.add(mainPanel);
    //display
        getClassInfo();
        getStudentInfo();
    }

    public String getStringUrl() {
        return "jdbc:sqlserver://localhost:1433;databasename=StudentDB";
    }
//Get Class and Student Info
    public void getClassInfo() {
        try {
            String sql = "Select * from Class";
            crClass = new CachedRowSetImpl();
            crClass.setUrl(getStringUrl());
            crClass.setUsername("sa");
            crClass.setPassword("123456");
            crClass.setCommand(sql);
            crClass.execute(); 
            
            classModel.setRowCount(0);
            while(crClass.next()) {
                data = new Vector(); 
                data.add(crClass.getString("class_id"));
                data.add(crClass.getString("class_name"));
                
                classModel.addRow(data);
            }
            classTable.setModel(classModel);
        }catch (SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException e){
        }
    }

    public void getStudentInfo() {
        try {
            String sql = "Select * from student";
            crStudent = new CachedRowSetImpl();
            crStudent.setUrl(getStringUrl());
            crStudent.setUsername("sa");
            crStudent.setPassword("123456");
            crStudent.setCommand(sql);
            crStudent.execute(); 
            
            studentModel.setRowCount(0);
            while(crStudent.next()) {
                data = new Vector(); 
                data.add(crStudent.getString("student_id"));
                data.add(crStudent.getString("student_name"));
                data.add(crStudent.getString("sex"));
                data.add(crStudent.getString("class_id"));
                
                studentModel.addRow(data);
            }
            studenTable.setModel(studentModel);
        
        }catch(SQLException e) {
            e.printStackTrace();
        }catch(NullPointerException e){
        }
        
    }
//JoinRowSet
    public void getStudentBaseClassId() {
        try {
            JoinRowSet jrs = new JoinRowSetImpl();
            jrs.addRowSet(crClass, CLASS_ID);
            jrs.addRowSet(crStudent, CLASS_ID);
            joinModel.setRowCount(0);
            while(jrs.next()) {
                data = new Vector(); 
                data.add(jrs.getString("student_id"));
                data.add(jrs.getString("student_name"));
                data.add(jrs.getString("sex"));
                data.add(jrs.getString("class_name"));
                
                joinModel.addRow(data);
            }
            joinTable.setModel(joinModel);
        }catch (SQLException ex) {
            ex.printStackTrace();
        }catch(NullPointerException e){
        }
    }
}
