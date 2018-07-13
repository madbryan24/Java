/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20.generic;

/**
 *
 * @author asus
 */
public class BoundedType {
    public static <T extends Comparable<T>> T max(T x,T y,T z){
        T maxi = x;
        if(y.compareTo(maxi) > 0) maxi = y;
        if(z.compareTo(maxi) > 0) maxi = z;
        
        return maxi;
    }
    
    public static void main(String[] args) {
        int x=1,y=2;
        int z=3;
        String s1 = "orange",s2 = "green",s3 = "linh";
        System.out.println("max is " + max(x, y, z));
        System.out.println("max1 is " + max(s1,s2,s3));
        
    }
}
