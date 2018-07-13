/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg5string;

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
        StringBuffer buffer = new StringBuffer(15);
        buffer.append("This is ") ;
        buffer.append("String") ;
        buffer.insert(7," a") ;
        buffer.append('.');
        System.out.println(buffer.length()); // 17
        System.out.println(buffer.capacity()); // 32
        String output = buffer.toString() ;
        System.out.println(output); // "This is a String."
    }
    
}
