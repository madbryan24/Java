/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1.testconnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

/**
 *
 * @author asus
 */
public class TestConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String conn = "jdbc:sqlserver://localhost:1433;databaseName=SimpleQuery;user=sa;password=123456";

            try{
		// Load SQL Server JDBC driver and establish connection.
                System.out.print("Connecting to SQL Server ... ");
                Connection connection = DriverManager.getConnection(conn);
                System.out.println("Done.\n");
                
                DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());         
            }catch(Exception e){
		System.out.println();
		e.printStackTrace();
            }
    }
    
}
