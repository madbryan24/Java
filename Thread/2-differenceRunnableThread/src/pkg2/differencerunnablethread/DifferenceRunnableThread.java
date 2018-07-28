/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.differencerunnablethread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class DifferenceRunnableThread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    //c1 Runnable | Nhiều đối tượng thread
        firstThread thread1 = new firstThread();
        secondThread thread2 = new secondThread();
        
        Thread t1 = new Thread(thread1);
        t1.start();
        
        Thread t2 = new Thread(thread2);
        t2.start();
        
    //c2 Thread | Mỗi thread tương ứng với một thể hiện
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
            System.out.println("Implements | " + "First: "+i);
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
            System.out.println("Implements | " + "Second: "+i);
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
            System.out.println("Extends | " + getName() + ": " +i);
            try{
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(thirdThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}