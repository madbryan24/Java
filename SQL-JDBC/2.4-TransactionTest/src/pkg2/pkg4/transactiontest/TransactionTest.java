/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.pkg4.transactiontest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import static pkg2.pkg4.transactiontest.TransactionTest.SQL;

/**
 *
 * @author asus
 */
public class TransactionTest {

    /**
     * @param args the command line arguments
     */
    static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=SimpleQuery;user=sa;password=123456";
    static Statement stmt = null;
    static String SQL;
    static Connection conn =null;
    static ResultSet rs;
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {
            // Load SQL Server JDBC driver and establish connection.
    //connecting to server
            System.out.print("Connecting to SQL Server ... ");
            conn = DriverManager.getConnection(URL);
            System.out.println(" Done.");

            System.out.print("Creating statement...");
            stmt = (Statement) conn.createStatement(); //create the statement
            System.out.println(" Done.");
            
            conn.setAutoCommit(false);
            
            printTable();
    //create savepoint        
            Savepoint sp1 = conn.setSavepoint();
            delGV();
            System.out.println("Del Teacher Done");
            printTable();
            
            Savepoint sp2 = conn.setSavepoint();
            insertGV();
            System.out.println("Insert Teacher Done");
            printTable();
    //rollback        
            System.out.println("Commit Done");
            conn.rollback(sp2);
            System.out.println("Rollback to 2 Done");
            printTable();
            conn.rollback(sp1); //to rollback to state 1
            System.out.println("Rollback to 1 Done");
            printTable();
            conn.commit(); //commit the transaction
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
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
    public static void delGV() throws SQLException{
        SQL = "DELETE FROM giaovien1 WHERE MAGV = '1'";
        stmt.executeUpdate(SQL); //execute the query
    }
    
    public static void insertGV() throws SQLException{
        SQL = "INSERT INTO giaovien1 VALUES(1,1,1,1,'19971113',1,1,'MMT')";
        stmt.executeUpdate(SQL); //execute the query
    }

    public static void printTable() throws SQLException{
            SQL = "SELECT * FROM giaovien1";
            rs = stmt.executeQuery(SQL);
            
            String MAGV;
            String HOTEN;
            Float LUONG;
            String PHAI;
            String NGSINH;
            String DIACHI;
            String GLQLCM = null;
            String MABM;
            
            System.out.println("Getting Information from Database...");
            System.out.println("TABLE: GIAOVIEN");
            System.out.printf("%-5s%-20s%-15s%-8s%-15s%-50s%-8s%-8s\n","MAGV","HOTEN","LUONG","PHAI","NGSINH","DIACHI","GLQLCM","MABM");
            while (rs.next()){
                MAGV = rs.getString("MAGV");
                HOTEN = rs.getString("HOTEN");
                LUONG = rs.getFloat("LUONG");
                PHAI = rs.getString("PHAI");
                NGSINH = rs.getString("NGSINH");
                DIACHI = rs.getString("DIACHI");
                try{
                    GLQLCM = rs.getString("GLQLCM");
                }catch(SQLException se2){
                }
                MABM = rs.getString("MABM");

                System.out.printf("%-5s%-20s%-15g%-8s%-15s%-50s%-8s%-8s\n",MAGV,HOTEN,LUONG,PHAI,NGSINH,DIACHI,GLQLCM,MABM);
            }
    }
}
