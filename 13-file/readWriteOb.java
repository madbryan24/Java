import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;


public class readWriteOb{
    public static void main(String[] args){
	String filename = "readWriteOb.txt";
	student s1 = new student();
	s1.setName("Ha Le Thinh");
	s1.setAge(20);
	
	try{
	    FileOutputStream fo = new FileOutputStream(filename);
	    ObjectOutputStream oo = new ObjectOutputStream(fo);

	    oo.writeObject(s1);

	    System.out.println("Writing to FILE Successfully");
	    oo.close();
	    fo.close();
	}catch(IOException e){
	    System.out.println("Error: " + e);
	}
	//WRITE TO FILE

	try{
	    FileInputStream fi = new FileInputStream(filename);
	    ObjectInputStream oi = new ObjectInputStream(fi);
	    
	    student s2 = new student();
	    s2 =(student)oi.readObject();
	    System.out.println("Reading FILE Successfully");
	    System.out.println(s2.getName());
	    System.out.println(s2.getAge());
	    
	    oi.close();
	    fi.close();	    
	}catch(IOException e){
	    System.out.println("Error: " + e);
	}catch (ClassNotFoundException e){
            System.out.println("Error: " + e);
        }
    }   
}

class student implements Serializable{
    private String name;
    private int age; //cannot get private info
    public void action(){
	System.out.println("Studying");
    }

    public void setName(String name){
	this.name = name;
    }
    public String getName(){
	return name;
    }

    public void setAge(int age){
	this.age = age;
    }
    public int getAge(){
	return age;
    }
}
