/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.getdatafromdatabase;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author asus
 */
public class GetDatafromDatabase {
    /*
    static String URL = "jdbc:sqlserver://localhost:1433;databaseName=SimpleQuery;user=sa;password=123456";
    static Statement stmt = null;
    static String SQL = null;
    static Connection conn;
    static ResultSet rs;
    */
    /**
     * @param args the command line arguments
     */
    static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=SimpleQuery;user=sa;password=123456";
    static Connection conn =null;
    static Statement stmt = null;
    static String SQL;
    static ResultSet rs;
    public static void main(String[] args) {
        
       
        // TODO code application logic here
        try {
            // Load SQL Server JDBC driver and establish connection.
            System.out.print("Connecting to SQL Server ... ");
            conn = DriverManager.getConnection(URL);
            System.out.println(" Done.");

            System.out.print("Creating statement...");
            stmt = (Statement) conn.createStatement(); //create the statement
            System.out.println(" Done.");

            SQL = "DELETE FROM GIAOVIEN WHERE HOTEN = '001'";
            stmt.executeUpdate(SQL); //execute the query
            
            SQL = "SELECT * FROM GIAOVIEN";
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
                GLQLCM = rs.getString("GVQLCM");
                MABM = rs.getString("MABM");
                
                
                System.out.printf("%-5s%-20s%-15g%-8s%-15s%-50s%-8s%-8s\n",MAGV,HOTEN,LUONG,PHAI,NGSINH,DIACHI,GLQLCM,MABM);
            
            }
            
            
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
    
}
