/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg18.datatypetransform;

/**
 *
 * @author asus
 */
public class DataTypeTransform {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double d = (new Integer(Integer.MAX_VALUE)).doubleValue();
        int i = new Integer(Integer.MAX_VALUE);
        System.out.println(i);
        System.out.println(d); // 2.147483647E9
        
        String s = "456";
        int n = Integer.parseInt(s);
        System.out.println(n); //456
        
        String s1 = "11.13";
        double n1 = Double.valueOf(s1);
        System.out.println(n1); //11.13
        
        String input = "test 1-2-3";
        int output = 0;
        for (int index=0;index<input.length();index++) {
            char c = input.charAt(index);
            if (Character.isDigit(c)){
               output = output * 10 + Character.digit(c, 10);
               System.out.println(output);
            }
        }
        System.out.println(output); //123
        
        

       
        
    }
    
}
