/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg22.hashmap;
import java.util.*;
import java.util.HashMap;
/**
 *
 * @author asus
 */
public class NewClass1 {
    public static void main(String[] args) {
        HashMap<Integer,String> hm = new HashMap<Integer,String>();
        
        hm.put(1,"A");
        hm.put(2,"B");
        hm.put(3,"C");
        hm.put(4,"D");
        hm.put(5,"E");
        
        Set set = hm.entrySet();
        Iterator itr = set.iterator();
        
        while(itr.hasNext()){
            Map.Entry me = (Map.Entry)itr.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        
    }
}
