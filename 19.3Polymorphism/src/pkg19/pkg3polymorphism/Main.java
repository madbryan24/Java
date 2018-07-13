/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg19.pkg3polymorphism;

/**
 *
 * @author asus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // only overload the method, not the variable
        animal a1 = new animal();
        animal a2 = new cat();
        animal a3 = new blackcat();
        a1.sleep();
        a2.sleep();
        a3.sleep();
        
    }
    
}

class animal{
    public void eat(){
        System.out.println("Eating...");
    }

    public void sleep() {
        System.out.println("Sleeping...");
    }
}

class cat extends animal{
    public void meow(){
        System.out.println("Meowing...");
    }

    public void sleep() {
        System.out.println("Cat's Sleeping...");
    }
}

class blackcat extends cat{
    public String color = "Black";
    public void meow(){
        System.out.println("Meowing...");
    }

    public void sleep() {
        System.out.println("Black Cat's Sleeping...");
    }
}