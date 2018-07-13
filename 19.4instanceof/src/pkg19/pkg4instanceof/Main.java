/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg19.pkg4instanceof;

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
        //vd1
        animal a1 = new animal();
        cat c1 = new cat();
        System.out.println(c1 instanceof cat); //T
        System.out.println(c1 instanceof animal); //T
        System.out.println(a1 instanceof cat); //F
        
        //vd2
        animal a2 = new cat();
        if(a2 instanceof cat){
            cat c2 = (cat)a2;
            System.out.println("Downcasting");
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