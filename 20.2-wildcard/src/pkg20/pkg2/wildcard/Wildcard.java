/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg20.pkg2.wildcard;

/**
 *
 * @author asus
 */
public class Wildcard {
    static double d = (new Integer(6)).doubleValue();
    static Integer d1 = new Integer(5);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RestricExample<Double> t = new RestricExample<Double>();
        t.number = 5.0;
        System.out.println(checkEquals(t));
        //System.out.println(checkEquals2(t));
    }
    private static boolean checkEquals(RestricExample<Double> e) {
        return (d != e.number.doubleValue());
    }
/*
    private static boolean checkEquals2(RestricExample<?> e) {
        return (d1.doubleValue() == e.number.doubleValue());
    }
*/
}

class RestricExample<T>{
    public T number;
}
