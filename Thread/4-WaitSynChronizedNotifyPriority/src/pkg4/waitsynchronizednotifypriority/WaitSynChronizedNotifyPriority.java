/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4.waitsynchronizednotifypriority;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class WaitSynChronizedNotifyPriority {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        customer c = new customer();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                c.withdraw(2000);
            }
        });
        t1.setPriority(5); // lower-priority thread will be notified later
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                c.withdraw(3000);
            }
        });
        t3.setPriority(10); // higher-priority thread will be notified first
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                c.deposit(13000);
            }
        });
        t1.start(); 
        t3.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(WaitSynChronizedNotifyPriority.class.getName()).log(Level.SEVERE, null, ex);
        }
        t2.start();
        
    }
    
}

class customer{
    private int balance = 1000;
    
    public customer(){
        System.out.println("Your balance is: \n"+ balance);
    }
         //synchronized allow only one thread access the vari at the same time
    public synchronized void withdraw(int amount){
        System.out.println("Withdrawing "+amount+"...");
        if(balance < amount){
            try{
                System.out.println("Your balance is not enough\n");
                wait(); // the Thread will wait until being notified
            }catch (InterruptedException ie) {
            System.err.println(ie.toString());
            }  
        }
        balance -= amount;
        System.out.println("Withdrawing "+ amount +" successfully");
        System.out.println("Your balance is: "+ balance +"\n");
    }
    public synchronized void deposit(int amount){
        System.out.println("Depositing "+amount+"...");
        balance += amount;
        System.out.println("Depositing "+ amount + " successfully");
        System.out.println("Your balance is: "+ balance +"\n");
        
        notifyAll(); //notify all the wait thread, higher-priority thread will be notified first
    }
}