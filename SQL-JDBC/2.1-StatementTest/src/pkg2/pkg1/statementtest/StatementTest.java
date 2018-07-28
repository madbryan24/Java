/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.pkg1.statementtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author asus
 */
public class StatementTest {

    /**
     * @param args the command line arguments
     */
    static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=SimpleQuery;user=sa;password=123456";
    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rs;
    public static void main(String[] args) {
        // TODO code application logic here
        
    try {
      //Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(URL);

      //Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql = "INSERT INTO Employees VALUES (100, 18, N'gia sư', N'tin học');"; 
      int rows = stmt.executeUpdate(sql);
      System.out.println("Rows impacted : " + rows);

      // Let us select all the records and display them.
      sql = "SELECT id, first, last, age FROM Employees";
      rs = stmt.executeQuery(sql);

      //Extract data from result set
      while (rs.next()) {
        //Retrieve by column name
        int id = rs.getInt("id");
        int age = rs.getInt("age");
        String first = rs.getString("first");
        String last = rs.getString("last");

        //Display values
        System.out.print("ID: " + id);
        System.out.print(", Age: " + age);
        System.out.print(", First: " + first);
        System.out.println(", Last: " + last);
      }

      //Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
    } catch (SQLException se) {
      //Handle errors for JDBC
      se.printStackTrace(); 
    } finally {
      //finally block used to close resources
      try {
        if (stmt != null) {
          stmt.close();
        }
      } catch (SQLException se2) {
      }// nothing we can do
      try {
        if (conn != null) {
          conn.close();
        }
      } catch (SQLException se) {
          se.printStackTrace();
      }//end finally try
     }//end try
    System.out.println("Done!");
  }
}
   
