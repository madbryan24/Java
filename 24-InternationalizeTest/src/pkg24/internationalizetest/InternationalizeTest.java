/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg24.internationalizetest;

import java.util.Locale;
import java.util.ResourceBundle;
 
/**
 *
 * @author asus
 */
public class InternationalizeTest {
    static ResourceBundle bundle;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Locale l1 = new Locale("en","EN");
        Locale l3 = new Locale("fr","FR");
        bundle = ResourceBundle.getBundle("pkg24.internationalizetest/messageBundle",l1);
        System.out.println("Message in " + l1 + " is: "+ bundle.getString("greeting"));
        bundle = ResourceBundle.getBundle("pkg24.internationalizetest/messageBundle",l3);
        System.out.println("Message in " + l3 + " is: "+ bundle.getString("greeting"));
    }
    
}
