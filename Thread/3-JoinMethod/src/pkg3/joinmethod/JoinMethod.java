/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3.joinmethod;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class JoinMethod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        thirdThread t3 = new thirdThread("Three");
        thirdThread t4 = new thirdThread("Four");
        t3.start();
        //t4 will wait until t3 is finished
        try{
            t3.join();
        }catch (InterruptedException ie) {
            System.err.println(ie.toString());
        }  
        t4.start();
    }
    
}

class thirdThread extends Thread{
    public thirdThread(String s){
        super(s);  
    }
    
    @Override
    public void run(){
         for(int i =0; i<5;i++){
            System.out.println("Extends | " + getName() + ": " +i);
            try{
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(thirdThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}