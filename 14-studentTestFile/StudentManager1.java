/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Klaus
 */
public class StudentManager1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi ban nhap so luong sinh vien : ");
        n = sc.nextInt();
        sc.nextLine();
        ArrayList<SinhVien> data = new ArrayList<SinhVien>();
        for ( int i = 0; i < n; i ++){
            SinhVien sv = new SinhVien();
            String ten;
            System.out.println("Moi ban nhap ten cho sinh vien");
            ten = sc.nextLine();
            sv.setTen(ten);
            data.add(sv);
        }
        String fileName = "demo.txt";
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(StudentManager1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex){
                Logger.getLogger(StudentManager1.class.getName()).log(Level.SEVERE, null, ex);       
        }
        List<SinhVien> data1 = null;
            try {
                FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);
                data1 = (List<SinhVien>) ois.readObject();
                ArrayList<SinhVien> data2 = new ArrayList<>(data1.size());
                data2.addAll(data1);
                for ( int i = 0; i < data2.size(); i ++){
                    System.out.println("Ten cua sinh vien la : " +data2.get(i).getTen());
                }
            } catch (FileNotFoundException ex1) {
                Logger.getLogger(StudentManager1.class.getName()).log(Level.SEVERE, null, ex1);
            } catch (IOException | ClassNotFoundException ex){
                Logger.getLogger(StudentManager1.class.getName()).log(Level.SEVERE, null, ex);                
            }
}

}
class SinhVien implements Serializable{
    private static final long serialVersionUID = 1L;
    private String ten;
    public void setTen(String ten){
        this.ten = ten;
    }
    public String getTen(){
        return ten;
    }
}
