/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg19.pkg1updowncasting;

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
        // upcasting: super references child class
        cat c1 = new cat();
        animal a1 = c1;
        animal a2 = (animal)c1;
        
        c1.meow();
        a1.eat(); // a1 will call eat of animal class
        a1.sleep(); // a1 will call sleep of cat class, not animal class
        
        //downcasting: create cat object without using new cat()
        animal a3 = new cat();
        cat c2 = (cat)a3;
        c1.meow();
        
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
