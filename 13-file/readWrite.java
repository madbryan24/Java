import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class readWrite{
    public static void main(String[] args){
	String filename = "readWrite.txt";
	try{
	    FileWriter fw = new FileWriter(filename);
	    BufferedWriter bw = new BufferedWriter(fw);

	    bw.write("Linh ham is mine");

	    bw.close();
	    fw.close();
	}catch(IOException e){
	    System.out.println("Error: " + e);
	}
	//WRITE TO FILE

	try{
	    FileReader fr = new FileReader(filename);
	    BufferedReader br = new BufferedReader(fr);

	    String line = br.readLine();
	    System.out.println(line);

	    br.close();
	    fr.close();
	}catch(IOException e){
	    System.out.println("Error: " + e);
	}
    }   
}
