/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3.clientframe;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class serverThread extends Thread{
    private Socket clientSocket;
    private int clientNumber;
    public serverThread(Socket clientSocket,int clientNumber){
        this.clientSocket = clientSocket;
        this.clientNumber = clientNumber;
        System.out.println("Client Number: "+this.clientNumber +" at "+this.clientSocket);
    }
    public void run(){
        try {
            InputStream inputStream = clientSocket.getInputStream();
            Scanner sc = new Scanner(inputStream);
            //send
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);
            
            int[] num = new int[2];
            int i=0;
            int sum =0;
            String receiveString=null;
                while(sc.hasNextLine()){
                    //receive msgs
                    for(i=0;i<2;i++){
                        receiveString = sc.nextLine();
                        num[i] = Integer.parseInt(receiveString); 
                        sum += num[i];
                        i++;
                    }
                    //send msg
                        printWriter.println(sum);  
                        System.out.println("Transfer to client successfully");
                }
            inputStream.close();
            outputStream.close();   
                   
        } catch (IOException ex) {
            Logger.getLogger(serverThread.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            System.out.println("Server Work has Stopped");
        }
    }

}
