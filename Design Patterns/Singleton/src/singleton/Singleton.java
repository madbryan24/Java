/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author asus
 */
            //Singleton is available for the system but unique
public class Singleton {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JDBCSingleton jdbc = JDBCSingleton.getInstance();

        Scanner s = new Scanner(System.in);

        int count = 1;
        int choice;

        do{
            System.out.println(" 1. Create account");
            System.out.println(" 2. Display account");
            System.out.println(" 3. Exit");

            System.out.print("Please enter the choice: ");
            choice = s.nextInt();

            //clear buffer
            s.nextLine();

            switch (choice) {
            case 1:
                System.out.print("Nhap ten : ");
                String username = s.nextLine();
                System.out.print("Nhap mat khau : ");
                String password = s.nextLine();

                try {
                    int i = jdbc.create(username, password);
                    if (i > 0) {
                        System.out.println("Them thanh cong");
                    } else {
                        System.out.println("Them that bai ");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case 2:
                System.out.print("Nhap ten : ");
                username = s.nextLine();
                try {
                    jdbc.display(username);
                } catch (Exception e) {
                    System.out.println(e);
                }
            break;
            }
        }while (choice != 3);
    }  
}

class JDBCSingleton { 
    private static JDBCSingleton jdbc;
    private JDBCSingleton() {

    }

    public static JDBCSingleton getInstance() {
        //only one is create
        if (jdbc == null) {
            jdbc = new JDBCSingleton();
        }
         return jdbc;
    }

    private static Connection getConnection() throws Exception {
        return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=studentAccount;user=sa;password=123456");
    }

    // Thêm dữ liệu vào db 
    public int create(String username, String pass) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        int cnt = 0;

        try {
            c = this.getConnection();
            ps = c.prepareStatement("insert into class(class_id,class_name) values(?,?)");
            ps.setString(1, username);
            ps.setString(2, pass);
            cnt = ps.executeUpdate();

        } catch (Exception e) {
             System.out.print(e.toString());
        } finally {
            if (ps != null) {
                 ps.close();
            }
             if (c != null) {
                c.close();
            }
        }
         return cnt;
    }

    //Hiển dữ liệu
    public void display(String id) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int cnt = 0;
        try {
            con = this.getConnection();
            ps = con.prepareStatement("select * from class where class_id = ?");
            ps.setString(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Ten " + rs.getString("class_id") + " va mat khau " + rs.getString("class_name"));
                cnt++;
            }

            if (cnt == 0) {
                 System.out.println("Khong co tai khoan nao ton tai");
            }
        } catch (Exception e) {
             System.out.println(e);
        } finally {
            if (rs != null) {
                 rs.close();
            }
            if (ps != null) {
                 ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}