/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1.createthread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class CreateThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    //c1 Runnable
        firstThread thread1 = new firstThread();
        secondThread thread2 = new secondThread();
        
        Thread t1 = new Thread(thread1);
        t1.start();
        
        Thread t2 = new Thread(thread2);
        t2.start();
        
    //c2 Thread
        thirdThread t3 = new thirdThread("Three");
        thirdThread t4 = new thirdThread("Four");
        t3.start();
        t4.start();
    }
    
}

class firstThread implements Runnable{

    @Override
    public void run() {
        for(int i =0; i<5;i++){
            System.out.println("First: "+i);
            try{
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(firstThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }  
}

class secondThread implements Runnable{

    @Override
    public void run() {
        for(int i =0; i<5;i++){
            System.out.println("Second: "+i);
            try{
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(secondThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }  
}

class thirdThread extends Thread{
    public thirdThread(String s){
        super(s);  
    }
    
    @Override
    public void run(){
         for(int i =0; i<5;i++){
            System.out.println(getName() + ": " +i);
            try{
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(secondThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
