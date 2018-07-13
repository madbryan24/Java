/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg21.iterator;

import java.util.*;
import java.util.ArrayList;
/**
 *
 * @author asus
 */
public class Iterator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList a = new ArrayList();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        
        java.util.Iterator i = a.iterator();
        while(i.hasNext()){
            System.out.print(i.next() + " ");
        }
        System.out.println();
        
        ListIterator li = a.listIterator();
        while(li.hasNext()){
            li.set(li.next() + "1");
        }
        while(li.hasPrevious()){
            System.out.print(li.previous()+ " ");
        }
        System.out.println();
            
    }
    
}
