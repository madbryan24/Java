/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passingresultsettest;

import java.sql.ResultSet;
import java.sql.SQLException;
import static passingresultsettest.PassingResultSetTest.rs;

/**
 *
 * @author asus
 */
public class PassingClass {
    private ResultSet rs;
    public PassingClass(){
        System.out.println("Hi, I'm Passing Class");
    }
    public void setResultSet(ResultSet rs){
        this.rs = rs;
    }
    public void print() throws SQLException{
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
    }
    
}
