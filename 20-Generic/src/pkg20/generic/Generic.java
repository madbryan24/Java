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
public class Generic {

    /**
     * @param args the command line arguments
     */
    public static <E> void  printArray(E[] inputArray){
              // Hien thi cac phan tu mang              
         for ( E element : inputArray ){        
            System.out.printf( "%s ", element );
         }
         System.out.println();
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println( "Mang intArray bao gom:" );
        printArray( intArray  ); // truyen mot mang Integer

        System.out.println( "\nMang doubleArray bao gom:" );
        printArray( doubleArray ); // truyen mot mang Double

        System.out.println( "\nMang charArray bao gom:" );
        printArray( charArray ); // truyen mot mang Character
    }
    
}
