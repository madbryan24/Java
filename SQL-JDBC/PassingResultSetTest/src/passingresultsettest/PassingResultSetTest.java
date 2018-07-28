/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passingresultsettest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author asus
 */
public class PassingResultSetTest {

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
            stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            System.out.println(" Done.");
            
            SQL = "SELECT * FROM GIAOVIEN1";
            rs = stmt.executeQuery(SQL);
            if(!rs.next()){
            
            }
            else{
                rs.absolute(0);
                PassingClass passingClass = new PassingClass();
                passingClass.setResultSet(rs);
                passingClass.print();
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
