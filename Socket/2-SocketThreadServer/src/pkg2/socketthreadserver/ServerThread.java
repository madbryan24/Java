/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.socketthreadserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
class ServerThread extends Thread{
    private Socket clientSocket;
    private int clientNumber;
    public ServerThread(Socket clientSocket,int clientNumber){
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
            while(sc.hasNextLine()){
                //receive msg
                String receiveString = sc.nextLine();
                System.out.println("Receive from client: "+receiveString);    
                
                //send msg
                printWriter.println("Forwards from Server" + receiveString);
                printWriter.println("Server is waiting to accept user...");
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            System.out.println("Server Work has Stopped");
        }
    }
    
}
