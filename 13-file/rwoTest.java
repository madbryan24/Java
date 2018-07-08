import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

 
public class rwoTest {
 
    public static void main(String[] args) {
        SinhVien sv = new SinhVien();
        sv.setTen("Nguyen Van A");
        sv.setTuoi(23);
        sv.setDiem(10);
        String fileName = "demo.txt";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream =  new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(sv);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch ( IOException e){
            System.out.println("Error: " + e);
        }
	
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            SinhVien sv1 = new SinhVien();
            sv1 = (SinhVien)objectInputStream.readObject();
            System.out.println("Ten cua sinh vien la : " + sv1.getTen());
            System.out.println("Tuoi cua sinh vien la : " + sv1.getTuoi());
            System.out.println("Diem cua sinh vien la : " + sv1.getDiem());

        }catch ( IOException e){
	    System.out.println("Error: " + e);
        }catch ( ClassNotFoundException e){
            System.out.println("Error: " + e);
        }
	
    }
    
}
class SinhVien implements Serializable{
    private String ten;
    private int tuoi;
    private int diem;
    public void setTen(String ten ){
        this.ten = ten;        
    }
    public String getTen(){
        return this.ten;
    }
    public void setTuoi( int tuoi){
        this.tuoi = tuoi;
        
    }
    public int getTuoi(){
        return this.tuoi;
    }
    public void setDiem( int diem){
        this.diem = diem;
        
    }
    public int getDiem(){
        return this.diem;
    }
}
