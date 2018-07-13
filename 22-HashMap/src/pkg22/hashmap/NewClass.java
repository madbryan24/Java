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
public class NewClass {
    public static void main(String[] args) {
        // TODO code application logic here
         // Tao mot hash map
      HashMap<String,Double> hm = new HashMap<String,Double>();
      // Dat cac phan tu vao map
      hm.put("Zara", new Double(3434.34));
      hm.put("Mahnaz", new Double(123.22));
      hm.put("Ayan", new Double(1378.00));
      hm.put("Daisy", new Double(99.22));
      hm.put("Qadir", new Double(-19.08));
      
      // Lay mot tap hop cac entry
      Set set = hm.entrySet();
      // Lay mot iterator
      Iterator i = set.iterator();
      // Hien thi cac phan tu
      while(i.hasNext()) {
         Map.Entry me = (Map.Entry)i.next();
         System.out.print(me.getKey() + ": ");
         System.out.println(me.getValue());
      }
      System.out.println();
      // Gui 1000 vao trong tai khoan cua Zara
      double balance = ((Double)(hm.get("Zara"))).doubleValue();
      hm.put("Zara", new Double(balance + 1000));
      System.out.println("Balance hien tai cua Zara la: " +
      hm.get("Zara"));
    }

}
