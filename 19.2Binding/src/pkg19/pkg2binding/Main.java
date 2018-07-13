/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg19.pkg2binding;

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
        // static binding: datatype is defined when compiling
        // final, private, static key -> static binding
        // No overloading in static binding
        animal a = new animal();
        a.sleep();
        
        // Dynamic binding: datatype is defined in runtime
        animal a1 = new animal();
        cat c1 = new cat();
        animal[] Array = {a1,c1};
        for(int i=0; i<Array.length; i++){
            Array[i].sleep();
        }    
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