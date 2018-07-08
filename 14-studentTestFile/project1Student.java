
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.IOException;
import java.io.EOFException;
import java.lang.IndexOutOfBoundsException;
import java.io.Serializable;

import java.util.*;

public class project1Student{
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<student> a = new ArrayList<student>();
    private static int count=0;
    private static final String filename = "student.txt";
    
    public static void main(String[] args) {
	int choice;
	do{
	    System.out.println("MENU");
	    System.out.println("1. Add more student");
	    System.out.println("2. Delete student");
	    System.out.println("3. Edit student");
	    System.out.println("4. Alphabet Order");
	    System.out.println("5. Display list of students");
	    System.out.println("6. Writing to File");
	    System.out.println("7. Reading File");
	    System.out.println("8. ");
	    System.out.print("Enter the function you want to execute: ");
	    choice = sc.nextInt();
	    sc.nextLine();
	    if(choice!=1 && choice!=2 && choice!=3 && choice!=4 && choice!=5 && choice!=6 && choice!=7 && choice!=8){
		System.out.println("Wrong input, please try again \n");
	    }

	    switch (choice){
            case 1:{
		addStudent();
            }
                break;

            case 2:{
		delStudent();
            }
                break;

            case 3:{
		editStudent();
            }
                break;

            case 4:{
		orderStudent();
            }
                break;

            case 5:{
		displayArrayList(a);
            }
                break;

            case 6:{
		writingToFile();
	    }
                break;
	    case 7:{
		readingFile();
	    }
                break;
	    case 8:{
	    }
                break;

            default: break;
	    }
	}while(choice!=8);
    }
    public static void writingToFile(){			
	try{
	    FileOutputStream fo = new FileOutputStream(filename);
	    ObjectOutputStream oo = new ObjectOutputStream(fo);

	    if(a.size() == 0) System.out.println("THE LIST IS EMPTY");
	    else{
		for(int i=0;i<a.size();i++){
		    oo.writeObject(a.get(i));
		}
		System.out.println("Writing to FILE Successfully");
	    }
	    
	    oo.close();
	    fo.close();
	}catch(IOException e){
	    System.out.println("Error: " + e);
	}
	//WRITE TO FILE
    }

    public static void readingFile(){
	ArrayList<student> a2 = new ArrayList<student>();
	try{
	    FileInputStream fi = new FileInputStream(filename);
	    ObjectInputStream oi = new ObjectInputStream(fi);

	    student s = new student();	    
	    while((s = (student)oi.readObject()) != null){
		a2.add(s);
	    }	    

	    oi.close();
	    fi.close();
	    
	}catch(EOFException e){
	    //print nothing
	}catch(IOException e){
	    System.out.println("Error: " + e);
	}catch (ClassNotFoundException e){
            System.out.println("Error: " + e);
        }finally{
	    displayArrayList(a2);
	}

    }
    
    public static void addStudent(){
	count++;
	student s1 = new student();
	System.out.println("Student " + count);
		
	System.out.print("Name: ");
	s1.setName(sc.nextLine());
	System.out.print("Age: ");
	s1.setAge(sc.nextInt());
	System.out.print("Score: ");
	s1.setScore(sc.nextFloat());
		
	a.add(s1);
	System.out.println("Adding student SUCCESSFULLY");
	System.out.println("");
    }

    public static void delStudent(){
	String name = "";
	int check =0;
	System.out.println("Please enter student you want to Delete:");
	name = sc.nextLine();
	if(a.size() == 0) System.out.println("THE LIST IS EMPTY");
	else{
	    for(int i=0;i<a.size();i++){
		if(a.get(i).getName().equals(name) == true){
		    a.remove(i);
		    System.out.printf("Deleting %s SUCCESSFULLY %n%n", name);
		    check =1;
		}
	    }
	    if(check == 0 ) System.out.println("Invalid student");
	}
    }

    public static void editStudent(){
	String name = "";
	int check =0;
	System.out.println("Please enter student you want to Delete:");
	name = sc.nextLine();
	if(a.size() == 0) System.out.println("THE LIST IS EMPTY");
	else{
	    for(int i=0;i<a.size();i++){
		if(a.get(i).getName().equals(name) == true){
		    System.out.print("Name: ");
		    a.get(i).setName(sc.nextLine());
		    System.out.print("Age: ");
		    a.get(i).setAge(sc.nextInt());
		    System.out.print("Score: ");
		    a.get(i).setScore(sc.nextFloat());
		    System.out.printf("Editing %s SUCCESSFULLY %n%n", name);
		    check =1;
		}
	    }
	    if(check == 0 ) System.out.println("Invalid student");
	}	
    }

    public static void orderStudent(){
	int min;
	int i,j;
	for(i=0;i<a.size()-1;i++){
	    min=i;
	    for(j=i+1;j<a.size();j++){
		if(a.get(j).getName().compareTo(a.get(i).getName()) < 0)
		    min =j;
	    }
	    student tmp = a.get(i);
	    try{		
		a.set(i,a.get(min));		
	    }catch(IndexOutOfBoundsException e){
		System.out.println("Error: " + e);
	    }
	    try{
		a.set(min,tmp);
	    }catch(IndexOutOfBoundsException e){
		System.out.println("Error: " + e);
	    }
	}
	System.out.println("Ordering the list SUCCESSFULLY");
	System.out.println("");
    }
    
    public static void displayArrayList(ArrayList<student> a){
	if(a.size() == 0) System.out.println("THE LIST IS EMPTY");
	else{
	    System.out.printf("%-25s%10s%10s%n","NAME","AGE","SCORE");
	    for(int i=0;i<a.size();i++){		
	        System.out.printf("%-25s%10d%10.1f%n",a.get(i).getName(),a.get(i).getAge(),a.get(i).getScore());
	    }
	    System.out.println("");
	}
    }
}

class student implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int age;
    private float score;
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

    public void setScore(float score){
	this.score = score;
    }
    public float getScore(){
	return score;
    }
}
