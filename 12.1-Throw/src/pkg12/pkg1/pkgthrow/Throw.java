/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg12.pkg1.pkgthrow;

/**
 *
 * @author asus
 */
public class Throw {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n1 = 9,n2 = 0;
        try{
            double d = calculate(n1,n2);
            System.out.println("Result: " + d);
        }catch(Exception e){
            System.out.println("Exception" + e);
            e.printStackTrace();
        }
    }
    public static double calculate(int n1,int n2) throws Exception{
        if (n2 == 0) 
            throw new ArithmeticException("Cannot divide by 0"); // throw new Exception
        else 
            return (double)(n1/n2);
    }
    
}
