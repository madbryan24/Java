/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.pkg3.callablestatementtest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author asus
 */
public class CallableStatementTest {
    static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=SimpleQuery;user=sa;password=123456";
    public static void main(String[] args) {
        // TODO code application logic here
        Connection conn =null;
        CallableStatement stmt = null;
        String SQL;
        ResultSet rs;
        // TODO code application logic here
        try {
            // Load SQL Server JDBC driver and establish connection.
            System.out.print("Connecting to SQL Server ... ");
            conn = DriverManager.getConnection(URL);
            System.out.println(" Done.");

            SQL = "{call USP_Test(?,?)}";
            stmt = (CallableStatement) conn.prepareCall(SQL); //create the statement
            stmt.setString(1,"001");
            stmt.setInt(2,2000);
            rs = stmt.executeQuery(); //execute the query
            
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


