/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4.pkg0.jbdcrowsettest;

import com.sun.rowset.JdbcRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.rowset.RowSetProvider;


/**
 *
 * @author asus
 */
public class JBDCRowsetTest {

    /**
     * @param args the command line arguments
     */
    static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=StudentDB;user=sa;password=123456";
    static Connection conn =null;
    /*
    static Statement stmt;
    static String SQL;
    static ResultSet rs;
    */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            System.out.print("Connecting to SQL Server ... ");
            conn = DriverManager.getConnection(URL);
            System.out.println(" Done.");
            /*
            System.out.print("Creating statement...");
            stmt = (Statement) conn.createStatement(); //create the statement
            System.out.println(" Done.");
            //SQL        
            SQL = "SELECT * FROM Class"; 
            rs = stmt.executeQuery(SQL);
            System.out.printf("%-8s%-10s\n","ID","Subject");
            while(rs.next()){
                System.out.printf("%-8s%-10s\n",rs.getString("Class_ID"),rs.getString("Class_Name"));
            }
            */
            JdbcRowSet jbRowSet = new JdbcRowSetImpl(conn);
            jbRowSet.setType(ResultSet.TYPE_SCROLL_INSENSITIVE);
            System.out.println("set");
            jbRowSet.setCommand("SELECT * FROM Class");
            System.out.println("cm");
            jbRowSet.execute();
            System.out.println("ex");
            
            System.out.printf("%-8s%-10s\n","ID","Subject");
            while(jbRowSet.next()){
                System.out.printf("%-8s%-10s\n",jbRowSet.getString(1),jbRowSet.getString(2));
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }catch(NullPointerException ne){
        }
    }
        
    
}
