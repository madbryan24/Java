/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg17.multipleparameters;


/**
 *
 * @author asus
 */
public class MultipleParameters {

    public static int sumVar(int... a){ // multiple parameters
        int sum =0;
        for(int i=0;i<a.length;i++){
            sum += a[i];
        }
        return sum;
    } 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] a = {1,2,3,4,5,6,7,8,9,0};        
        System.out.println("Sum is: " + sumVar(a));
    }
    
}
